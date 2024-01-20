package br.edu.challenge.baas.process;

import br.edu.challenge.baas.exception.BusinessException;
import br.edu.challenge.baas.model.EntityModel;
import br.edu.challenge.baas.model.User;
import jakarta.validation.Valid;

public class PasswordValidation implements Validation {
    @Override
    public void process(EntityModel em) {
        User user = (User) em;
        if(!user.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$") &&
                user.getPassword().length() < 6) {
            throw new BusinessException("Senha inválida! Deve conter, pelo menos, uma letra maiúscula e minúscula, um caractere " +
                    "especial e um número");
        }
    }
}