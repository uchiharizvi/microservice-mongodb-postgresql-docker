package com.flickstream.user.controller;

import com.flickstream.user.model.User;
import com.flickstream.user.model.dto.UserRegistrationRequest;
import com.flickstream.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        return userService.registerUser(userRegistrationRequest);
    }

//    @PostMapping("/authenticate")
//    public String authenticate(@RequestBody String email, @RequestParam String password) {
//        Optional<User> user = userService.authenticate(email, password);
//        return user.isPresent()?"Login successful" : "Invalid credentials";
//    }

//    @GetMapping("/{email}")
//    public User getUser(@PathVariable String email) {
//        return userService.getUser(email).orElse(null);
//    }

}
