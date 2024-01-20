package br.edu.challenge.baas.service.impl;

import br.edu.challenge.baas.dto.SignupDto;
import br.edu.challenge.baas.dto.SignupRespDto;
import br.edu.challenge.baas.enumeration.Event;
import br.edu.challenge.baas.mapper.UserMapper;
import br.edu.challenge.baas.model.Client;
import br.edu.challenge.baas.model.User;
import br.edu.challenge.baas.process.*;
import br.edu.challenge.baas.repository.ClientRepository;
import br.edu.challenge.baas.repository.UserRepository;
import br.edu.challenge.baas.service.Facade;
import br.edu.challenge.baas.service.SignupService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SignupServiceImpl extends Facade implements SignupService {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final UserMapper userMapper;
    public SignupServiceImpl(UserRepository userRepository, ClientRepository clientRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.userMapper = userMapper;

        EmailValidation ev = new EmailValidation(this.userRepository);
        PasswordValidation pv = new PasswordValidation();
        DocumentValidation dv = new DocumentValidation(this.clientRepository);

        List<Validation> signupProcesses = new ArrayList<>();
        signupProcesses.add(ev);
        signupProcesses.add(pv);
        signupProcesses.add(dv);

        Map<Event, List<Validation>> orderRoles = new HashMap<>();
        orderRoles.put(Event.SIGNUP, signupProcesses);

        this.rules.put(User.class.getSimpleName(), orderRoles);
    }

    @Override
    public SignupRespDto signup(SignupDto dto) {
        new ConfirmPasswords().process(dto);
        User user = this.userMapper.toUser(dto);
        Client client = this.userMapper.toClient(dto);
        user.setClient(client);
        this.execute(user, Event.SIGNUP);
        User createdUser = this.userRepository.saveAndFlush(user);
        return this.userMapper.toSignupRespDto(createdUser);
    }
}