package com.example.demo.dto.studentDTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetStudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int age;
    private String gender;
    private String enrollmentYear;
    private Long studentId;
}
