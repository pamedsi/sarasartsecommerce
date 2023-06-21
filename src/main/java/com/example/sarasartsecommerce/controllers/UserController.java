package com.example.sarasartsecommerce.controllers;

import com.example.sarasartsecommerce.dto.signUpFormDTO;
import com.example.sarasartsecommerce.entities.User;
import com.example.sarasartsecommerce.models.ResponseBodyMessage;
import com.example.sarasartsecommerce.repositories.UserRepository;
import com.example.sarasartsecommerce.services.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    @RequestMapping (value = "/signup")
    public ResponseEntity<?> signUpUser(@RequestBody signUpFormDTO user) {
//        try {
            User newUser = new CreateUser().execute(user);
            repository.save(newUser);
            return ResponseEntity.ok(new ResponseBodyMessage("Usuário cadastrado!", 200));
//        }
//        catch (DataAccessException error) {
//            return ResponseEntity.ok(new ResponseBodyMessage(error.getMessage(), 10));
//        }
    }
}
