package com.example.demo.dto.courseDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GetCourseInfo {

    private Long id;

    @NotBlank
    private String courseName;

    @NotBlank
    private String courseCode;

    private Long creditScore;

    private String courseDescription;

    private String departmentName;

    private String enrolledStudents;

}
