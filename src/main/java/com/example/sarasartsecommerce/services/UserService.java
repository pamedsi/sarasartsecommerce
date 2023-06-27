package com.example.sarasartsecommerce.services;

import com.example.sarasartsecommerce.dto.SignInFormDTO;
import com.example.sarasartsecommerce.dto.SignUpFormDTO;
import com.example.sarasartsecommerce.entities.User;
import com.example.sarasartsecommerce.models.LoginInput;
import com.example.sarasartsecommerce.models.ResponseBodyMessage;
import com.example.sarasartsecommerce.repositories.UserRepository;
import com.example.sarasartsecommerce.utils.LoginInputTypeDetector;
import com.google.i18n.phonenumbers.NumberParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // Create
    public ResponseEntity<?> signUp(SignUpFormDTO user) {
        User newUser = new User(user);
        repository.save(newUser);
        return ResponseEntity.ok(new ResponseBodyMessage("Usuário cadastrado!"));
    }

    // Read
    public ResponseEntity<?> signIn(SignInFormDTO loginForm) throws NumberParseException {

        LoginInput loginInput = new LoginInputTypeDetector(loginForm.login()).getLoginInput();
        List<User> queryResult = null;

        switch (loginInput) {
            case ERROR -> throw new RuntimeException("Login inválido!");
            case EMAIL -> queryResult = repository.findSingleByEmail(loginForm.login());
            case PHONE_NUMBER -> queryResult = repository.findSingleByPhoneNumber(loginForm.login());
        }

        String unauthorizedMessage = "Login ou senha incorretos!";
        if (queryResult.size() == 0) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseBodyMessage(unauthorizedMessage));
        boolean correctPassword = Objects.equals(queryResult.get(0).getPassword(), loginForm.password());
        if (!correctPassword) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseBodyMessage(unauthorizedMessage));
        return ResponseEntity.ok(new ResponseBodyMessage("Bem-vindo!"));
    }

    // Update

    // Delete
}
