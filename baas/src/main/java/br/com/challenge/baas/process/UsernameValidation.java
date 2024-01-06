package br.com.challenge.baas.process;

import br.com.challenge.baas.dto.RegisterReqDto;
import br.com.challenge.baas.exception.BusinessException;
import br.com.challenge.baas.model.EntityModel;
import br.com.challenge.baas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsernameValidation implements Validation {
    private final UserRepository userRepository;
    @Autowired
    public UsernameValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void process(EntityModel em) {
        RegisterReqDto data = (RegisterReqDto)em;
        if(this.userRepository.findByUsername(data.username()).isPresent()) {
            throw new BusinessException("Já existe cliente com este usuario");
        }
    }
}
