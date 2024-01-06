package br.com.desafio.vaga.dto;

import br.com.desafio.vaga.model.EntityModel;

public record LoginReqDto(String userName, String password) implements EntityModel {
}
