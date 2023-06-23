package com.example.sarasartsecommerce.models;

import com.example.sarasartsecommerce.validation.LoginInputValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LoginInputValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailOrPhoneNumber {

    String message() default "E-mail ou número de telefone inválido!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
