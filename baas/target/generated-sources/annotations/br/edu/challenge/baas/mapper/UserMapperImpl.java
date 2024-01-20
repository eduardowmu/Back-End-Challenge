package br.edu.challenge.baas.mapper;

import br.edu.challenge.baas.dto.SignupDto;
import br.edu.challenge.baas.dto.SignupRespDto;
import br.edu.challenge.baas.model.Client;
import br.edu.challenge.baas.model.User;
import br.edu.challenge.baas.utils.FormatUtils;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-19T23:33:20-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(SignupDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    @Override
    public Client toClient(SignupDto dto) {
        if ( dto == null ) {
            return null;
        }

        Client client = new Client();

        return client;
    }

    @Override
    public SignupRespDto toSignupRespDto(User user) {
        if ( user == null ) {
            return null;
        }

        String msg = null;

        SignupRespDto signupRespDto = new SignupRespDto( msg );

        return signupRespDto;
    }
}
