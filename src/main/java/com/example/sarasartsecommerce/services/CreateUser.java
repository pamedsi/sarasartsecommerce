package com.example.sarasartsecommerce.services;

import com.example.sarasartsecommerce.dto.SignUpFormDTO;
import com.example.sarasartsecommerce.entities.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CreateUser {
    public User execute(SignUpFormDTO user) {
        return new User(user);
    }
}