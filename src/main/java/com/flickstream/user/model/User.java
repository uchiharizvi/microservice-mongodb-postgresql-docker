package com.flickstream.user.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="user_data")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
}
