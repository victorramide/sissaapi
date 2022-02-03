package br.com.sissa.sissaapi.config.security;

import br.com.sissa.sissaapi.model.Advogado;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokensService {

    @Value("${sissa.jwt.expiration}")
    private String expiration;

    @Value("${sissa.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {

        Advogado logado = (Advogado) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("SISSA API") //Qual aplicação está gerando o token
                .setSubject(logado.getId().toString()) //Quem é o usuário autenticado
                .setIssuedAt(hoje) //Data de geração do token
                .setExpiration(dataExpiracao) //Data de expiração do token
                .signWith(SignatureAlgorithm.HS256, secret) //criptografia do token
                .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
