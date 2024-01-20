package br.edu.challenge.baas.exception;


import jakarta.servlet.ServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler {
    Logger logger = LoggerFactory.getLogger(ResourceExceptionHandler.class);
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<StandardError> businessException(BusinessException ex, ServletRequest request) {
        StandardError error = StandardError.builder()
            .timeStamp(System.currentTimeMillis())
            .message(ex.getMessage())
            .status(HttpStatus.NOT_ACCEPTABLE.value())
            .build();

        logger.error(error.toString());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
    }
}