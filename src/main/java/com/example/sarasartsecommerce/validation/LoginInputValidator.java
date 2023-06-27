package com.example.sarasartsecommerce.validation;

import com.example.sarasartsecommerce.models.LoginInput;
import com.example.sarasartsecommerce.utils.LoginInputTypeDetector;
import com.google.i18n.phonenumbers.NumberParseException;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LoginInputValidator implements ConstraintValidator<ValidEmailOrPhoneNumber, String> {
    @Override
    public boolean isValid(String login, ConstraintValidatorContext context) {
        try {
            LoginInputTypeDetector inputType = new LoginInputTypeDetector(login);
            return inputType.getLoginInput() != LoginInput.ERROR;
        } catch (NumberParseException e) {
            throw new RuntimeException(e);
        }
    }
}
