package com.example.demo.dto.courseDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourse {


    @NotBlank
    private String courseName;

    @NotBlank
    private String courseCode;

    private Long courseCredit;

    private String department;

    private String courseDescription;


}
