package com.example.sarasartsecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;


@Getter
public class SignInFormDTO {
    @NotBlank // (message = "O nome de usuário é obrigatório")
    private String login;
    @NotBlank (message = "A senha é obrigatória")
    private String password;
}