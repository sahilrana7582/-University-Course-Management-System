package com.example.demo.dto.courseDTO;


import com.example.demo.model.CourseModule;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCourse {

    private Long id;

    @NotBlank
    private String courseName;

    @NotBlank
    private String courseCode;

    private Long creditScore;

    private Long department_id;

    private String courseDescription;


    private int totalTerms;

    private int totalDurationInMonths;

    private int totalDurationInYears;

    private Set<CourseModule> modules;


}
