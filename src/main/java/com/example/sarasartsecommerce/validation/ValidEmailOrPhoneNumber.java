package com.example.sarasartsecommerce.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginInputValidator.class)
public @interface ValidEmailOrPhoneNumber {
    String message() default "Invalid email or phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
