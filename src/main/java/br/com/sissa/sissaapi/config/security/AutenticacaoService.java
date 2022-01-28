package br.com.sissa.sissaapi.config.security;

import br.com.sissa.sissaapi.model.Advogado;
import br.com.sissa.sissaapi.repository.AdvogadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private AdvogadoRepository advogadoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Advogado> advogado = advogadoRepository.findByEmail(username);
        if(advogado.isPresent()){
            return advogado.get();
        }
        throw new UsernameNotFoundException("Dados Inválidos");
    }
}
