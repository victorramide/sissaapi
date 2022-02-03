package br.com.sissa.sissaapi.config.security;

import br.com.sissa.sissaapi.model.Advogado;
import br.com.sissa.sissaapi.repository.AdvogadoRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {


    private TokensService tokensService;
    private AdvogadoRepository advogadoRepository;

    public AutenticacaoViaTokenFilter(TokensService tokensService, AdvogadoRepository advogadoRepository) {
        this.tokensService = tokensService;
        this.advogadoRepository = advogadoRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(request);
        boolean valido = tokensService.isTokenValido(token);
        if(valido){
            autenticarCliente(token);
        }
        filterChain.doFilter(request, response);
    }

    private void autenticarCliente(String token) {
        Long idUsuario = tokensService.getIdUsuario(token);
        Advogado advogado = advogadoRepository.findById(idUsuario).get();
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(advogado, null, advogado.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }
}
