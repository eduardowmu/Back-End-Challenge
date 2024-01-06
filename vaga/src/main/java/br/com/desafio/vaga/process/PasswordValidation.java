package br.com.desafio.vaga.process;

import br.com.desafio.vaga.dto.RegisterReqDto;
import br.com.desafio.vaga.exception.BusinessException;
import br.com.desafio.vaga.model.EntityModel;

public class PasswordValidation implements Validation {
    @Override
    public void process(EntityModel em) {
        RegisterReqDto data = (RegisterReqDto)em;
        if(!data.confirmSenha().equals(data.password())) {
            throw new BusinessException("Senhas inconsistentes");
        }
    }
}