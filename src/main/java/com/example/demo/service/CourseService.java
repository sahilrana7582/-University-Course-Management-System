package com.example.demo.service;


import com.example.demo.dto.courseDTO.CreateCourse;
import com.example.demo.dto.courseDTO.CreateManyCourses;
import com.example.demo.dto.courseDTO.GetAllCourseOverview;
import com.example.demo.dto.courseDTO.GetCourse;
import com.example.demo.dto.departmentDTO.AddDepartment;
import com.example.demo.model.Course;
import com.example.demo.model.Department;
import com.example.demo.respository.CourseRepository;
import com.example.demo.respository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        course.setTotalTerms(createCourse.getTotalTerms());
        Course savedCourse = courseRepository.save(course);

        int totalDurationInMonths = savedCourse.getTotalTerms() * 6;
        int totalDurationInYears = totalDurationInMonths / 12;


        return new GetCourse(
                savedCourse.getId(),
                savedCourse.getCourseName(),
                savedCourse.getCourseCode(),
                savedCourse.getCourseCredits(),
                department.getId(),
                savedCourse.getCourseDescription(),
                savedCourse.getTotalTerms(),
                totalDurationInMonths,
                totalDurationInYears,
                savedCourse.getModules()
        );
    }


    @Transactional
    public List<GetAllCourseOverview> addManyCourses(CreateManyCourses createManyCourses) {
        List<CreateCourse> newCourses = createManyCourses.getCourses();

        List<Course> savedCourses = newCourses.stream().map(courseDto -> {
            Course course = new Course();
            course.setCourseName(courseDto.getCourseName());
            course.setCourseDescription(courseDto.getCourseDescription());
            course.setCourseCode(courseDto.getCourseCode());
            course.setCourseCredits(courseDto.getCourseCredit());
            course.setTotalTerms(courseDto.getTotalTerms());


            if (courseDto.getDepartment() != null) {
                Department department = departmentRepository.findByCode(courseDto.getDepartment())
                        .orElseThrow(() -> new RuntimeException("Department not found"));
                course.setDepartment(department);
            }
            return courseRepository.save(course);
        }).toList();

        return savedCourses.stream().map(course -> new GetAllCourseOverview(
                course.getId(),
                course.getCourseName(),
                course.getCourseCode(),
                course.getCourseCredits(),
                course.getDepartment().getName(),
                course.getCourseDescription(),
                course.getTotalTerms()
        )).collect(Collectors.toList());
    }

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }


    public GetCourse getCourseInfo(String courseCode) {
        Course course =  courseRepository.findByCourseCode(courseCode)
                .orElseThrow(() -> new RuntimeException("Course not found with courseCode: " + courseCode));

         int totalDurationInMonths = course.getTotalTerms() * 6;
         int totalDurationInYears = totalDurationInMonths / 12;

        return new GetCourse(
                course.getId(),
                course.getCourseName(),
                course.getCourseCode(),
                course.getCourseCredits(),
                course.getId(),
                course.getCourseDescription(),
                course.getTotalTerms(),
                totalDurationInMonths,
                totalDurationInYears,
                course.getModules()
        );
    }

}
