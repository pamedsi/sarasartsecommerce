package com.example.sarasartsecommerce.models;

import java.time.LocalDate;
import java.util.Date;

public class LoginForm {
    private String login;
    private String password;
    private LocalDate agora;

    // Getters e Setters

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getAgora() {
        return agora;
    }
}
