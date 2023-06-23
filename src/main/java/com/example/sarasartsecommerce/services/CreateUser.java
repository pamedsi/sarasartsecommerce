package com.example.sarasartsecommerce.services;

import com.example.sarasartsecommerce.dto.SignUpFormDTO;
import com.example.sarasartsecommerce.entities.User;

public class CreateUser {

    public CreateUser(){}

    public User execute(SignUpFormDTO user) {
        return new User(user);
    }
}