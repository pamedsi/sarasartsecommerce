package com.example.sarasartsecommerce.services;

import com.example.sarasartsecommerce.dto.SignUpFormDTO;
import com.example.sarasartsecommerce.entities.User;
import com.example.sarasartsecommerce.models.ResponseBodyMessage;
import org.springframework.http.ResponseEntity;
import com.example.sarasartsecommerce.repositories.UserRepository;

public class SignUp {
    public ResponseEntity<?> execute(SignUpFormDTO user, UserRepository repository) {
        User newUser = new CreateUser().execute(user);
        repository.save(newUser);
        return ResponseEntity.ok(new ResponseBodyMessage("Usuário cadastrado!", 200));
    }
}