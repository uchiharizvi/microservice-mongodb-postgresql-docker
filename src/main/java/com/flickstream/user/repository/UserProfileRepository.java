package com.flickstream.user.repository;

import com.flickstream.user.model.User;
import com.flickstream.user.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    /*User findByEmail(String email);*/
}
