package br.com.challenge.baas.service.impl;

import br.com.challenge.baas.dto.ResponseDto;
import br.com.challenge.baas.model.EntityModel;
import br.com.challenge.baas.process.DocumentValidation;
import br.com.challenge.baas.repository.ClientRepository;
import br.com.challenge.baas.repository.UserRepository;
import br.com.challenge.baas.service.Facade;
import br.com.challenge.baas.service.RegisterService;
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