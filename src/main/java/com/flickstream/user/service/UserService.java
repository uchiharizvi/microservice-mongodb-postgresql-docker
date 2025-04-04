package com.flickstream.user.service;

import com.flickstream.user.model.User;
import com.flickstream.user.model.dto.UserRegistrationRequest;

import java.util.Optional;

public interface UserService {
    User registerUser(UserRegistrationRequest userRegistrationRequest);
    boolean loginUser(String email, String password);
//    Optional<User> getUser(String email);
}
