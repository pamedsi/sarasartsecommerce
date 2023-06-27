package com.example.sarasartsecommerce.exception;

import com.example.sarasartsecommerce.models.ResponseBodyMessage;
import com.google.i18n.phonenumbers.NumberParseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity <?> InvalidInput () {
        String message = "Login ou senha incorretos!";
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseBodyMessage(message));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> AlreadyRegistered () {
        return null;
    }

    @ExceptionHandler (NumberParseException.class)
    public ResponseEntity<String> InvalidPhoneNumber () { return null; }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<String> NullError () { return null; }
}
