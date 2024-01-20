package br.edu.challenge.baas.mapper;

import br.edu.challenge.baas.dto.SignupDto;
import br.edu.challenge.baas.dto.SignupRespDto;
import br.edu.challenge.baas.model.Client;
import br.edu.challenge.baas.model.User;
import br.edu.challenge.baas.utils.FormatUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = FormatUtils.class)
public interface UserMapper {
    @Mapping(target = "user.username", expression = "java(dto.username())")
    @Mapping(target = "user.password", expression = "java(dto.password())")
    @Mapping(target = "user.userRole", expression = "java(UserRole.USER)")
    User toUser(SignupDto dto);

    @Mapping(target = "client.name", expression = "java(dto.name())")
    @Mapping(target = "client.document", expression = "java(dto.document())")
    @Mapping(target = "client.address", expression = "java(dto.address())")
    Client toClient(SignupDto dto);

    @Mapping(target = "signupRespDto.msg", expression = "java(\"Usuário \"+ user.getUsername() + \" cadastrado com sucesso!\")")
    SignupRespDto toSignupRespDto(User user);
}