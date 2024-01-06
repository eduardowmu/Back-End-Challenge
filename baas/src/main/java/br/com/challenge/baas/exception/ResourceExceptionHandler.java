package br.com.challenge.baas.exception;

import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler
{	@ExceptionHandler(BusinessException.class)
public ResponseEntity<StandardError> objectNotFoundException(
        BusinessException ex, ServletRequest request)
{	StandardError error = StandardError.builder()
        .timeStamp(System.currentTimeMillis())
        .message(ex.getMessage())
        .status(HttpStatus.NOT_FOUND.value())
        .build();

    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
}
}