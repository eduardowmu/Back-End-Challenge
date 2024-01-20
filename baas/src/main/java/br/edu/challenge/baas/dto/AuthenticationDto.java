package br.edu.challenge.baas.dto;

import br.edu.challenge.baas.model.EntityModel;
import org.antlr.v4.runtime.misc.NotNull;

public record AuthenticationDto(@NotNull String username, @NotNull String password) implements EntityModel {
}