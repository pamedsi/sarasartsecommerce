package com.example.sarasartsecommerce.controllers;

import com.example.sarasartsecommerce.dto.SignInFormDTO;
import com.example.sarasartsecommerce.dto.SignUpFormDTO;
import com.example.sarasartsecommerce.repositories.UserRepository;
import com.example.sarasartsecommerce.services.SignIn;
import com.example.sarasartsecommerce.services.SignUp;
import com.google.i18n.phonenumbers.NumberParseException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping (value = "/user")
public class UserController {
    @Autowired
    private UserRepository repository;

}
