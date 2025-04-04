package com.flickstream.user.service;

//import com.flickstream.user.data.RedisCache;

import com.flickstream.user.model.User;
import com.flickstream.user.model.dto.UserRegistrationRequest;
import com.flickstream.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private RedisCache redisCache;

    @Override
    public User registerUser(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setEmail(userRegistrationRequest.getEmail());
        user.setPassword(userRegistrationRequest.getPassword());
        return userRepository.save(user);
    }

    @Override
    public boolean loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent() && user.get().getPassword().equals(password);
    }

//    @Override
//    public Optional<User> authenticate(String email, String password) {
//        //check cache
////        User cachedUser = redisCache.getUserFromCache(email);
////        if (cachedUser != null && cachedUser.getPassword().equals(password)) {
////            return Optional.of(cachedUser);
////        }
//        //fetch from DB
//        User user = userRepository.findByEmail(email);
//        if(user!=null && user.getPassword().equals(password)) {
////            redisCache.cacheUser(user);
//            return Optional.of(user);
//        }
//        return Optional.empty();
//    }

//    @Override
//    public Optional<User> getUser(String email) {
//        return Optional.ofNullable(userRepository.findByEmail(email));
//    }
}
