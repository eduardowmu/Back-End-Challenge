package br.com.desafio.vaga.dto;

import br.com.desafio.vaga.model.EntityModel;
import org.antlr.v4.runtime.misc.NotNull;

public record RegisterReqDto(@NotNull String username, @NotNull String password, @NotNull String confirmSenha,
                          @NotNull String name, @NotNull String cpfCnpj) implements EntityModel {
}