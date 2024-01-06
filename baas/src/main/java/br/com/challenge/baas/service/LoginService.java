package br.com.challenge.baas.service;

import br.com.challenge.baas.dto.ResponseDto;
import br.com.challenge.baas.model.EntityModel;

public interface LoginService {
    ResponseDto login(EntityModel em);
}