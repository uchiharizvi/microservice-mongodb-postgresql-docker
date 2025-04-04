package com.flickstream.user.service;

import com.flickstream.user.model.UserProfile;

import java.util.Optional;

public interface UserProfileService {
    UserProfile createProfile(UserProfile profile);
    Optional<UserProfile> getProfileByUserId(String userId);
}
