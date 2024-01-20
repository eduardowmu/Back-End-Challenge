package br.edu.challenge.baas.dto;

import br.edu.challenge.baas.model.EntityModel;
import jakarta.validation.constraints.NotNull;

public record SignupDto(@NotNull String username, @NotNull String password, @NotNull String confirmPassword,
                        @NotNull String name, @NotNull String document, @NotNull String address) implements EntityModel {
}