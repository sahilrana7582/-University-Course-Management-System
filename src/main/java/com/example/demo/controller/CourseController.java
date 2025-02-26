package com.example.demo.controller;

import com.example.demo.dto.courseDTO.CreateCourse;
import com.example.demo.dto.courseDTO.CreateManyCourses;
import com.example.demo.dto.courseDTO.GetAllCourseOverview;
import com.example.demo.dto.courseDTO.GetCourse;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{courseCode}")
    public Course getCourseInfo(@PathVariable String courseCode){
        return courseService.getCourseInfo(courseCode);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<GetAllCourseOverview>> addManyCourses(@RequestBody CreateManyCourses createManyCourses) {
        List<GetAllCourseOverview> courses = courseService.addManyCourses(createManyCourses);
        return ResponseEntity.ok(courses);
    }
}
