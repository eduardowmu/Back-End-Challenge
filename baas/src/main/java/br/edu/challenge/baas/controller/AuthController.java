package br.edu.challenge.baas.controller;

import br.edu.challenge.baas.dto.AuthenticationDto;
import br.edu.challenge.baas.dto.LoginResponseDto;
import br.edu.challenge.baas.dto.SignupDto;
import br.edu.challenge.baas.dto.SignupRespDto;
import br.edu.challenge.baas.model.User;
import br.edu.challenge.baas.repository.UserRepository;
import br.edu.challenge.baas.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository repository,
                          TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    public ResponseEntity<SignupRespDto> signup(@RequestBody @Valid SignupDto dto) {

        return ResponseEntity.ok().body(new SignupRespDto("Usuário criado com sucesso"));
    }
}