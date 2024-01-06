package br.com.desafio.vaga.service;

import br.com.desafio.vaga.dto.ResponseDto;
import br.com.desafio.vaga.model.EntityModel;

public interface LoginService {
    ResponseDto login(EntityModel em);
}