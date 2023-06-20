package com.example.sarasartsecommerce.services;

import com.example.sarasartsecommerce.dto.signUpFormDTO;
import com.example.sarasartsecommerce.entities.User;

public class CreateUser {

    public CreateUser(){}

    public User execute(signUpFormDTO user) {
        return new User(user);
    }
}
