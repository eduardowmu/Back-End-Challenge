package br.com.desafio.vaga.service.impl;

import br.com.desafio.vaga.dto.ResponseDto;
import br.com.desafio.vaga.model.EntityModel;
import br.com.desafio.vaga.service.Facade;
import br.com.desafio.vaga.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

public class LoginServiceImpl extends Facade implements LoginService {

    @Override
    public ResponseDto login(EntityModel em) {
        return null;
    }
}