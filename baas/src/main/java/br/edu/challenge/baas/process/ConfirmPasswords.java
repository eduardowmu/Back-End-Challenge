package br.edu.challenge.baas.process;

import br.edu.challenge.baas.dto.SignupDto;
import br.edu.challenge.baas.exception.BusinessException;
import br.edu.challenge.baas.model.EntityModel;

public class ConfirmPasswords implements Validation{
    @Override
    public void process(EntityModel em) {
        SignupDto dto = (SignupDto) em;
        if(!dto.password().equals(dto.confirmPassword())) {
            throw new BusinessException("As senhas não batem!");
        }
    }
}