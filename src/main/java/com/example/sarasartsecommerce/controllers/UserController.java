package com.example.sarasartsecommerce.controllers;

import com.example.sarasartsecommerce.dto.SignUpFormDTO;
import com.example.sarasartsecommerce.models.LoginForm;
import com.example.sarasartsecommerce.repositories.UserRepository;
import com.example.sarasartsecommerce.services.SignIn;
import com.example.sarasartsecommerce.services.SignUp;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    @RequestMapping (value = "/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpFormDTO user) {
        return new SignUp().execute(user, repository);
    }
    @PostMapping
    @RequestMapping (value = "/signin")
    public ResponseEntity<?> signIn(@RequestBody LoginForm loginForm) {
        return new SignIn().execute(loginForm, repository);
    }
    @PostMapping
    @RequestMapping (value = "/signout")
    public ResponseEntity<?> signOut(@RequestBody LoginForm loginForm) {
    return null;
    }
}
