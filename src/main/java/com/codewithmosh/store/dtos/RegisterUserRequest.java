package com.codewithmosh.store.dtos;

import com.codewithmosh.store.validation.Lowercase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Maksimalno 255 karaktera")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Lowercase(message = "Email mora imati samo mala slova")
    private String email;

    @NotBlank(message = "Pasword je obavezno polje")
    @Size(min = 6, max = 25, message = "Pasvord mora biti izmedju 6 i 25 karaktera")
    private String password;
}
