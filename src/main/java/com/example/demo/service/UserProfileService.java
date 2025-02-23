package com.example.demo.service;

import com.example.demo.dto.userprofile.GetUserProfileDTO;
import com.example.demo.dto.userprofile.UserProfileDTO;
import com.example.demo.model.User;
import com.example.demo.model.UserProfile;
import com.example.demo.respository.UserProfileRepository;
import com.example.demo.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRespository userRespository;


    public GetUserProfileDTO getUserProfile(Long userId) {
        User existingUser = userRespository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        UserProfile userProfile = existingUser.getUserProfile();

        if (userProfile == null) {
            throw new RuntimeException("User Profile Not Found");
        }

        return new GetUserProfileDTO(
                userProfile.getId(),
                userProfile.getAge(),
                userProfile.getPhone(),
                userProfile.getGender(),
                existingUser.getId()
        );
    }

    public UserProfileDTO createUserProfile(Long userId, UserProfileDTO userProfileDTO) {
        User existingUser = userRespository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        UserProfile newUserProfile = new UserProfile();
        newUserProfile.setAge(userProfileDTO.getAge());
        newUserProfile.setPhone(userProfileDTO.getPhone());
        newUserProfile.setGender(userProfileDTO.getGender());
        newUserProfile.setUser(existingUser);

        UserProfile savedProfile = userProfileRepository.save(newUserProfile);

        return new UserProfileDTO(
                savedProfile.getAge(),
                savedProfile.getPhone(),
                savedProfile.getGender(),
                savedProfile.getUser().getId()
        );
    }

    public UserProfileDTO updateUserProfile(Long userId, UserProfileDTO userProfile) {
        User existingUser = userRespository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found!"));

        UserProfile existingProfile = userProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User Profile Not Found!"));

        if (userProfile.getAge() > 0) {
            existingProfile.setAge(userProfile.getAge());
        }
        if (userProfile.getPhone() != null && !userProfile.getPhone().trim().isEmpty()) {
            existingProfile.setPhone(userProfile.getPhone());
        }
        if (userProfile.getGender() != null) {
            existingProfile.setGender(userProfile.getGender());
        }

        UserProfile updatedProfile = userProfileRepository.save(existingProfile);

        return new UserProfileDTO(
                updatedProfile.getAge(),
                updatedProfile.getPhone(),
                updatedProfile.getGender(),
                userId
        );
    }



}
