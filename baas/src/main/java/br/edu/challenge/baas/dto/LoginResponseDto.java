package br.edu.challenge.baas.dto;

import br.edu.challenge.baas.model.EntityModel;
import org.antlr.v4.runtime.misc.NotNull;

public record LoginResponseDto(@NotNull String token) implements EntityModel {
}