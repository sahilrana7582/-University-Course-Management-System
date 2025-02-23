package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserProfile;
import com.example.demo.respository.UserProfileRepository;
import com.example.demo.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRespository userRespository;


    public UserProfile getUserProfile(Long userId){
        User existingUser = userRespository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        return existingUser.getUserProfile();
    }

    public UserProfile createUserProfile(Long userId, UserProfile userProfile) {
        User existingUser = userRespository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        userProfile.setUser(existingUser);

        return userProfileRepository.save(userProfile);
    }


}
