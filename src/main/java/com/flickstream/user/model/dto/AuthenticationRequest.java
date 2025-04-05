package com.flickstream.user.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthenticationRequest {
    @Email
    @NotBlank
    private String email;
    private String password;
}
