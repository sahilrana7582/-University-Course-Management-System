package com.example.demo.service;


import com.example.demo.dto.courseDTO.CreateCourse;
import com.example.demo.dto.courseDTO.GetCourse;
import com.example.demo.model.Course;
import com.example.demo.model.Department;
import com.example.demo.respository.CourseRepository;
import com.example.demo.respository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public GetCourse addCourse(CreateCourse createCourse) {
        Department department = departmentRepository.findByCode(createCourse.getDepartment())
                .orElseThrow(() -> new RuntimeException("Department Not Found!"));

        Course course = new Course();
        course.setCourseName(createCourse.getCourseName());
        course.setCourseCode(createCourse.getCourseCode());
        course.setDepartment(department);
        course.setCourseDescription(createCourse.getCourseDescription());
        course.setCourseCredits(createCourse.getCourseCredit());

        Course savedCourse = courseRepository.save(course);

        return new GetCourse(savedCourse.getId(), savedCourse.getCourseName(), savedCourse.getCourseCode(),  course.getCourseCredits(), department.getId(), savedCourse.getCourseDescription());
    }

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }


    public Course getCourseInfo(String courseCode) {
        return courseRepository.findByCourseCode(courseCode)
                .orElseThrow(() -> new RuntimeException("Course not found with courseCode: " + courseCode));
    }

}
