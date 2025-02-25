package com.example.demo.dto.professorDTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProfessorWithPersonInfoDTO {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int age;
    private String gender;
    private String specialization;
    private String title;
    private Long professorId;


}
