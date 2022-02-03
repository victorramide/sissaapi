package br.com.sissa.sissaapi.controller;


import br.com.sissa.sissaapi.config.security.TokensService;
import br.com.sissa.sissaapi.controller.dto.TokenDto;
import br.com.sissa.sissaapi.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokensService tokensService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokensService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDto(token,"Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }

    }
}
