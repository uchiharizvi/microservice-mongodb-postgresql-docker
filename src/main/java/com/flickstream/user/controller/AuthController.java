package com.flickstream.user.controller;

import com.flickstream.user.model.dto.AuthenticationRequest;
import com.flickstream.user.model.dto.LoginRequest;
import com.flickstream.user.security.JWTUtil;
import com.flickstream.user.security.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                        authenticationRequest.getPassword())
        );
        String token = jwtUtil.generateToken(authenticationRequest.getEmail());
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/login/v2")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        String token = jwtUtil.generateToken(loginRequest.getEmail());
        return ResponseEntity.ok(Map.of("token", token));
    }

}
