package com.flickstream.user.model.dto;

import lombok.Data;

@Data
public class UserRegistrationRequest {
    private String email;
    private String password;
}
