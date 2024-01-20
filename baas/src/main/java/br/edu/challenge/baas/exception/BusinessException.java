package br.edu.challenge.baas.exception;

import br.edu.challenge.baas.model.EntityModel;

public class BusinessException extends RuntimeException implements EntityModel {
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }
}