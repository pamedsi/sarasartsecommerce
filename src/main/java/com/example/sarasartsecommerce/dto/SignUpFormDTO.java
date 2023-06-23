package com.example.sarasartsecommerce.dto;

import com.example.sarasartsecommerce.models.UserRole;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class SignUpFormDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String birthDate;
}
