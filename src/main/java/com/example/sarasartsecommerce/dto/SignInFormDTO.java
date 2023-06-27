package com.example.sarasartsecommerce.dto;

import com.example.sarasartsecommerce.validation.ValidEmailOrPhoneNumber;
import com.example.sarasartsecommerce.validation.ValidPassword;

public record SignInFormDTO (
    @ValidEmailOrPhoneNumber
    String login,
    @ValidPassword
    String password
) {}