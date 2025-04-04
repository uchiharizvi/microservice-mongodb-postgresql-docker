package com.flickstream.user.controller;

import com.flickstream.user.model.User;
import com.flickstream.user.model.UserProfile;
import com.flickstream.user.repository.UserProfileRepository;
import com.flickstream.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/health")
public class HealthCheckController {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    public HealthCheckController(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @GetMapping("/db")
    public ResponseEntity<String> testDatabaseConnections() {
        try {
            //Test Posgtres
            User user = new User();
            user.setEmail("test@example.com");
            user.setPassword("secure");
            userRepository.save(user);

            //Test Mongo DB
            UserProfile profile = new UserProfile();
            profile.setId(UUID.randomUUID().toString());
            profile.setName("Test User");
            profile.setPhone("1234567890");
            userProfileRepository.save(profile);

            return ResponseEntity.ok("✅ Both DB connections are working!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("❌ Database connection failed: " + ex.getMessage());
        }

    }
}
