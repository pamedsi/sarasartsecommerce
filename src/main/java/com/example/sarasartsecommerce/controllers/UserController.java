package com.example.sarasartsecommerce.controllers;

import com.example.sarasartsecommerce.dto.signUpFormDTO;
import com.example.sarasartsecommerce.entities.User;
import com.example.sarasartsecommerce.models.LoginForm;
import com.example.sarasartsecommerce.models.ResponseBodyMessage;
import com.example.sarasartsecommerce.repositories.UserRepository;
import com.example.sarasartsecommerce.services.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping (value = "/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    @RequestMapping (value = "/signup")
    public ResponseEntity<?> signUp(@RequestBody signUpFormDTO user) {
            User newUser = new CreateUser().execute(user);
            repository.save(newUser);
            return ResponseEntity.ok(new ResponseBodyMessage("Usuário cadastrado!", 200));
    }
    @PostMapping
    @RequestMapping (value = "/signin")
    public ResponseEntity<?> signIn(@RequestBody LoginForm loginForm) {
        List<User> queryResult = repository.findSingleByLogin(loginForm.getLogin());
        String unauthorizedMessage = "Login ou senha incorretos!";
        if (queryResult.size() == 0) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseBodyMessage(unauthorizedMessage, 401));
        if (!Objects.equals(queryResult.get(0).getPassword(), loginForm.getPassword())) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseBodyMessage(unauthorizedMessage, 401));
        return ResponseEntity.ok(new ResponseBodyMessage("Bem-vindo!", 200));
    }
}
