package br.com.challenge.baas.dto;

import br.com.challenge.baas.model.EntityModel;

public record LoginReqDto(String userName, String password) implements EntityModel {
}
