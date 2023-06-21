package com.example.sarasartsecommerce.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity <String> NotFound (ResponseStatusException ex){
        return null;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> UserNotFound() {
//        return ResponseEntity.notFound().build();
        return null;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <String> InvalidInput () {
//        return ResponseEntity.notFound().build();
        return null;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> AlreadyRegistered () {
        return null;
    }
}
