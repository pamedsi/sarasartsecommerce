package com.example.sarasartsecommerce.services;

import com.example.sarasartsecommerce.entities.User;
import com.example.sarasartsecommerce.models.LoginForm;
import com.example.sarasartsecommerce.models.ResponseBodyMessage;
import com.example.sarasartsecommerce.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

public class SignIn {

    public ResponseEntity<?> execute (@RequestBody LoginForm loginForm, UserRepository repository) {
        List<User> queryResult = repository.findSingleByLogin(loginForm.getLogin());
        String unauthorizedMessage = "Login ou senha incorretos!";
        if (queryResult.size() == 0) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseBodyMessage(unauthorizedMessage, 401));
        if (!Objects.equals(queryResult.get(0).getPassword(), loginForm.getPassword())) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseBodyMessage(unauthorizedMessage, 401));
        return ResponseEntity.ok(new ResponseBodyMessage("Bem-vindo!", 200));
    }
}
