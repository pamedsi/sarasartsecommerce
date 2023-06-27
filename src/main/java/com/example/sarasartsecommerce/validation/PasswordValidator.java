package com.example.sarasartsecommerce.validation;

import com.example.sarasartsecommerce.utils.PasswordRegex;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return new PasswordRegex().validate(password);
    }
}
