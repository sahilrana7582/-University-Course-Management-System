package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student extends Person {

    @Column(name = "enrollment_year", nullable = false)
    private String enrollmentYear;

    @Column(name = "student_id", nullable = false, unique = true)
    private Long studentId;

    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonManagedReference
    private Set<Course> courses;
}
