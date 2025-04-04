package com.flickstream.user.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_profiles")
@Getter
@Setter
public class UserProfile {
    @Id
    private String id;
    private String userId; //reference userid from postgresql
    private String fullName;
    private String bio;
    private String profileImageURL;
}
