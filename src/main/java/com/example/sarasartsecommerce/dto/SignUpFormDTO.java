package com.example.sarasartsecommerce.dto;

import com.example.sarasartsecommerce.models.UserRole;
import java.time.LocalDateTime;

public class SignUpFormDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private UserRole userRole;
    private String birthDate;
    private LocalDateTime userSince;
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() { return name; }

    public UserRole getUserRole() { return userRole; }

    public LocalDateTime getUserSince() { return userSince; }

    public String getPhoneNumber() { return phoneNumber; }

    public String getBirthDate() { return birthDate; }
}
