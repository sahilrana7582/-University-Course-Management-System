package com.example.demo.controller;

import com.example.demo.dto.courseDTO.CreateCourse;
import com.example.demo.dto.courseDTO.GetCourse;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;



    @PostMapping
    public GetCourse addCourse(@RequestBody @Valid CreateCourse createCourse){
        return courseService.addCourse(createCourse);
    }

    @GetMapping
    public List<Course> getCourse(){
        return courseService.getAllCourse();
    }
}
