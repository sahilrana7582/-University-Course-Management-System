package com.example.demo.controller;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{userId}/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping
    public UserProfile createUserProfile(@PathVariable Long userId, @RequestBody UserProfile userProfile) {
        return userProfileService.createUserProfile(userId, userProfile);
    }

    @GetMapping
    public UserProfile getUserProfile(@PathVariable Long userId) {
        return userProfileService.getUserProfile(userId);
    }

    @PutMapping
    public UserProfile updateUserProfile(@PathVariable Long userId, @RequestBody UserProfile userProfile){
        return userProfileService.updateUserProfile(userId, userProfile);
    }
}

