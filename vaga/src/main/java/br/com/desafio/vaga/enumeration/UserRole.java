package br.com.desafio.vaga.enumeration;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}