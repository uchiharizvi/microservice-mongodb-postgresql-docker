package com.flickstream.user.model;

import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="${mongo.data.collection}")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
