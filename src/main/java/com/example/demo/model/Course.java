package com.example.demo.model;


import com.example.demo.dto.courseDTO.GetCourse;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_description", nullable = false)
    private String courseDescription;

    @Column(name = "course_code", nullable = false, unique = true)
    private String courseCode;


    @Column(name = "course_credit", nullable = false)
    private Long courseCredits;


    private int totalTerms;


    @Transient
    private int totalDurationInMonths(){
        return totalTerms * 6;
    }

    @Transient
    private int totalDurationInYears(){
        return totalDurationInMonths() / 12;
    }

    @ManyToMany
    @JoinTable(
            name = "course_module",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    @JsonManagedReference
    private Set<CourseModule> modules;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonBackReference
    private Department department;

    @ManyToMany(mappedBy = "courses")
    @JsonBackReference
    private Set<Student> students;

    public String getDepartmentName() {
        return department != null ? department.getName() : null;
    }

    public int getEnrolledStudentCount() {
        return students != null ? students.size() : 0;
    }

}
