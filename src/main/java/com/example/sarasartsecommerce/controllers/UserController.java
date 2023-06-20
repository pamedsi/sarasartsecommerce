package com.example.sarasartsecommerce.controllers;

import com.example.sarasartsecommerce.dto.signUpFormDTO;
import com.example.sarasartsecommerce.entities.User;
import com.example.sarasartsecommerce.repositories.UserRepository;
import com.example.sarasartsecommerce.services.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/signup")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    public void signUpUser(@RequestBody signUpFormDTO user) {
        User newUser = new CreateUser().execute(user);
        repository.save(newUser);
    }
}
