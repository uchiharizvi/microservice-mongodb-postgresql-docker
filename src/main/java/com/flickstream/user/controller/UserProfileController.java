package com.flickstream.user.controller;

import com.flickstream.user.model.UserProfile;
import com.flickstream.user.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/profiles")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping
    public ResponseEntity<UserProfile> createProfile(@RequestBody UserProfile profile) {
        return ResponseEntity.ok(userProfileService.createProfile(profile));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfile> getProfile(@PathVariable String userId) {
        Optional<UserProfile> profile = userProfileService.getProfileByUserId(userId);
        return profile.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

}
