package com.codewithmosh.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Email nesme da bude prazan")
    @Email
    private String email;

    @NotBlank(message = "Password polje ne sme da bude prazno")
    private String password;
}
