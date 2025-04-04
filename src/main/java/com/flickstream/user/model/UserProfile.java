package com.flickstream.user.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "user_profiles")
@Getter
@Setter
public class UserProfile {
    @MongoId
    private String id;

    private String name;
    private String phone;

}
