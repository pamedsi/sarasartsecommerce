package com.example.sarasartsecommerce.controllers;

import com.example.sarasartsecommerce.dto.SignInFormDTO;
import com.example.sarasartsecommerce.dto.SignUpFormDTO;
import com.example.sarasartsecommerce.repositories.UserRepository;
import com.example.sarasartsecommerce.services.SignIn;
import com.example.sarasartsecommerce.services.SignUp;
import com.google.i18n.phonenumbers.NumberParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping (value = "/sign")
public class SignController {
    @Autowired
    private UserRepository repository;
    @PostMapping
    @RequestMapping(value = "/up")
    public ResponseEntity<?> signUp(@RequestBody SignUpFormDTO user) {

        return new SignUp().execute(user, repository);
    }
    @PostMapping
    @RequestMapping (value = "/in")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInFormDTO loginForm) throws NumberParseException {
        return new SignIn().execute(loginForm, repository);
    }
    @PostMapping
    @RequestMapping (value = "/out")
    public ResponseEntity<?> signOut(@RequestBody SignInFormDTO loginForm) {
        return null;
    }
}
