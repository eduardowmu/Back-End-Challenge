package br.com.challenge.baas.security;


import br.com.challenge.baas.exception.BusinessException;
import br.com.challenge.baas.model.User;
import br.com.challenge.baas.repository.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;


@PropertySource("classpath:application.properties")
@Service
public class TokenService {
    @Value("${api.token.secret}")
    private String secret;

    private final UserRepository userRepository;

    public TokenService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getUsername())
                    //.withExpiresAt(genExpirationDate())
                    .sign(algorithm);

            User gotUser = this.userRepository.findByUsername(user.getUsername()).orElseThrow(
                    () -> new BusinessException("Usuário não encontrado " + user.getUsername()));

            gotUser.setToken(token);
            //salva o token para confirmar que o usuário está logado.
            this.userRepository.save(gotUser);

            return token;
        } catch(JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            return "";
        }
    }

    public User findByToken(String token) {
        return this.userRepository.findByToken(token).orElseThrow(() -> new BusinessException("Não Autenticado"));
    }

    public void deleteToken(String token) {
        Optional<User> user = this.userRepository.findByToken(token);
        if(user.isPresent()) {
            user.get().setToken(null);
            this.userRepository.save(user.get());
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}