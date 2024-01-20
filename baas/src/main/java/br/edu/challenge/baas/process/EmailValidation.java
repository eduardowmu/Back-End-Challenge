package br.edu.challenge.baas.process;

import br.edu.challenge.baas.exception.BusinessException;
import br.edu.challenge.baas.model.EntityModel;
import br.edu.challenge.baas.model.User;
import br.edu.challenge.baas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public class EmailValidation implements Validation {
    private final UserRepository userRepository;
    @Autowired
    public EmailValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void process(EntityModel em) {
        User user = (User) em;
        if(this.userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new BusinessException("Nome de usuário já existente! " + user.getUsername());
        }
    }
}