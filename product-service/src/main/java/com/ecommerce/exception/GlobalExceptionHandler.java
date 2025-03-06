package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public Mono<ResponseEntity<String>> handlerProductNotFound(ProductNotFoundException ex){
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Mono<ResponseEntity <ValidProductResponse>> handleValidationExceptions(MethodArgumentNotValidException ex){
        ValidProductResponse errors = new ValidProductResponse(
                "Error de validacion",
                new Date(),
                ex.getBindingResult().getFieldError().getDefaultMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors));
    }
}
