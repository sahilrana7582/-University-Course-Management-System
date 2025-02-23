package com.example.demo.controller;

import com.example.demo.dto.userprofile.GetUserProfileDTO;
import com.example.demo.dto.userprofile.UserProfileDTO;
import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{userId}/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping
    public ResponseEntity<UserProfileDTO> createUserProfile(@PathVariable Long userId, @Valid @RequestBody UserProfileDTO userProfile) {
        return ResponseEntity.ok(userProfileService.createUserProfile(userId, userProfile));
    }

    @GetMapping
    public ResponseEntity<GetUserProfileDTO> getUserProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(userProfileService.getUserProfile(userId));
    }

    @PutMapping
    public ResponseEntity<UserProfileDTO> updateUserProfile(@PathVariable Long userId, @Valid @RequestBody UserProfileDTO userProfile){
        return ResponseEntity.ok(userProfileService.updateUserProfile(userId, userProfile));
    }
}

