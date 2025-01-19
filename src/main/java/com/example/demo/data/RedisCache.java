package com.example.demo.data;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class RedisCache {
    private static final String USER_CACHE = "USER_CACHE";
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    public void cacheUser(User user) {
        redisTemplate.opsForValue().set(USER_CACHE + ":" + user.getEmail(), user, Duration.ofHours(1));//lifetime of 1 hour
    }

    public User getUserFromCache(String email) {
        return redisTemplate.opsForValue().get(USER_CACHE + ":" + email);
    }
}
