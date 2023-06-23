package com.example.sarasartsecommerce.services;

import com.example.sarasartsecommerce.dto.SignInFormDTO;
import com.example.sarasartsecommerce.entities.User;
import com.example.sarasartsecommerce.models.LoginInput;
import com.example.sarasartsecommerce.models.ResponseBodyMessage;
import com.example.sarasartsecommerce.repositories.UserRepository;
import com.example.sarasartsecommerce.validation.LoginInputValidator;
import com.google.i18n.phonenumbers.NumberParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

public class SignIn {

    public ResponseEntity<?> execute (@RequestBody SignInFormDTO loginForm, UserRepository repository) throws NumberParseException {
//        LoginInput loginInput = new LoginInputValidator(loginForm.getLogin()).getLoginInput();
        List<User> queryResult = repository.findSingleByPhoneNumber(loginForm.getLogin());
//        List<User> queryResult = null;
//        switch (loginInput) {
//            case ERROR -> throw new RuntimeException("Login inválido!");
//            case EMAIL -> queryResult = repository.findSingleByEmail(loginForm.getLogin());
//            case PHONE_NUMBER -> queryResult = repository.findSingleByPhoneNumber(loginForm.getLogin());
//        }
//
        String unauthorizedMessage = "Login ou senha incorretos!";
        if (queryResult.size() == 0) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseBodyMessage(unauthorizedMessage, 401));
        boolean correctPassword = Objects.equals(queryResult.get(0).getPassword(), loginForm.getPassword());
        if (!correctPassword) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseBodyMessage(unauthorizedMessage, 401));
        return ResponseEntity.ok(new ResponseBodyMessage("Bem-vindo!", 200));
//        return null;
    }

}
