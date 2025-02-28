package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "modules")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CourseModule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "module_name", unique = true)
    private String moduleName;

    @Column(name = "module_description")
    private String moduleDescription;

    @ManyToMany(mappedBy = "modules")
    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course) {
        courses.add(course);
        course.getModules().add(this);
    }
}
