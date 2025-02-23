package com.example.demo.dto.userprofile;


import com.example.demo.enums.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDTO {

    @Min(18)
    private int age;

    @NotBlank
    private String phone;

    @NotNull
    private Gender gender;

    private Long userId;
}
