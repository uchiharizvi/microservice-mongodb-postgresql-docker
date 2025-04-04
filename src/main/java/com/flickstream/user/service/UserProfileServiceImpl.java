package com.flickstream.user.service;

import com.flickstream.user.model.UserProfile;
import com.flickstream.user.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile createProfile(UserProfile profile) {
        return userProfileRepository.save(profile);
    }

    @Override
    public Optional<UserProfile> getProfileByUserId(String userId) {
        return userProfileRepository.findByUserId(userId);
    }
}
