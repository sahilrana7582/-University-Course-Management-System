package com.example.demo.dto.userprofile;


import com.example.demo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserProfileDTO {
    private Long id;
    private int age;
    private String phone;
    private Gender gender;
    private Long userId;
}
