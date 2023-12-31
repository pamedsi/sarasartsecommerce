package com.example.sarasartsecommerce.controllers;

import com.example.sarasartsecommerce.dto.SignInFormDTO;
import com.example.sarasartsecommerce.dto.SignUpFormDTO;
import com.example.sarasartsecommerce.services.UserService;

import com.google.i18n.phonenumbers.NumberParseException;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    Create
    @PostMapping
    @RequestMapping(value = "/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpFormDTO user) {
        return userService.signUp(user);
    }
    //    Read
    @PostMapping
    @RequestMapping (value = "/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInFormDTO loginForm) throws NumberParseException {
            return userService.signIn(loginForm);
    }
    @PostMapping
    @RequestMapping (value = "/signout")
    public ResponseEntity<?> signOut(@RequestBody SignInFormDTO loginForm) {
        return null;
    }
}
