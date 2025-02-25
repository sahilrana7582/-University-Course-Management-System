package com.example.demo.dto.studentDTO;

import jakarta.validation.constraints.NotBlank;

public class CreateStudentDTO {

    @NotBlank
    private String enrollmentYear;

    private Long studentId;
}
