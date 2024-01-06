package br.com.desafio.vaga.controller;

import br.com.desafio.vaga.dto.LoginReqDto;
import br.com.desafio.vaga.dto.RegisterReqDto;
import br.com.desafio.vaga.dto.ResponseDto;
import br.com.desafio.vaga.exception.BusinessException;
import br.com.desafio.vaga.model.User;
import br.com.desafio.vaga.security.TokenService;
import br.com.desafio.vaga.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginReqDto data){
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.userName(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok(new ResponseDto(token));
        }catch (RuntimeException e) {
            throw new BusinessException("Usuário ou senha inválida");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signup(@RequestBody @Valid RegisterReqDto data) {
        return ResponseEntity.ok().body(this.registerService.signup(data));
    }

    @DeleteMapping("/logoff")
    public void logoff(@RequestHeader("Authorization") String token) {
        this.tokenService.deleteToken(token.replaceAll("Bearer ", ""));
    }
}