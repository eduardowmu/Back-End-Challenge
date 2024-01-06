package br.com.desafio.vaga.service.impl;

import br.com.desafio.vaga.dto.ResponseDto;
import br.com.desafio.vaga.model.EntityModel;
import br.com.desafio.vaga.process.DocumentValidation;
import br.com.desafio.vaga.repository.ClientRepository;
import br.com.desafio.vaga.repository.UserRepository;
import br.com.desafio.vaga.service.Facade;
import br.com.desafio.vaga.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RegisterServiceImpl extends Facade implements RegisterService {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    @Autowired
    public RegisterServiceImpl(UserRepository userRepository, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;

        this.roles = new HashMap<>();

        DocumentValidation dv = new DocumentValidation(this.clientRepository);
    }
    @Override
    public ResponseDto signup(EntityModel em) {
        return null;
    }
}