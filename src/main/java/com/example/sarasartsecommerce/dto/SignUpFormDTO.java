package com.example.sarasartsecommerce.dto;

import com.example.sarasartsecommerce.models.UserRole;
import com.example.sarasartsecommerce.validation.ValidPassword;
import jakarta.validation.constraints.Email;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
public record SignUpFormDTO (
    String name,
    @Email
    String email,
    String phoneNumber,
    @ValidPassword
    String password,
    LocalDate birthDate // "YYYY-MM-DD"
){}