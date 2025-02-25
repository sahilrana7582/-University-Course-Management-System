package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student extends Person {

    @Column(name = "enrollment_year", nullable = false)
    private String enrollmentYear;

    @Column(name = "student_id", nullable = false, unique = true)
    private Long studentId;
}
