package br.com.challenge.baas.process;

import br.com.challenge.baas.dto.RegisterReqDto;
import br.com.challenge.baas.exception.BusinessException;
import br.com.challenge.baas.model.EntityModel;

public class PasswordValidation implements Validation {
    @Override
    public void process(EntityModel em) {
        RegisterReqDto data = (RegisterReqDto)em;
        if(!data.confirmSenha().equals(data.password())) {
            throw new BusinessException("Senhas inconsistentes");
        }
    }
}