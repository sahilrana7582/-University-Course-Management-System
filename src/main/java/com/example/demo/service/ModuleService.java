package com.example.demo.service;


import com.example.demo.dto.courseDTO.CourseSummary;
import com.example.demo.dto.courseDTO.GetCourse;
import com.example.demo.dto.moduleDTO.CreateModule;
import com.example.demo.dto.moduleDTO.GetModuleInfo;
import com.example.demo.model.Course;
import com.example.demo.model.CourseModule;
import com.example.demo.respository.CourseRepository;
import com.example.demo.respository.ModuleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public GetModuleInfo createModuleAndAssignToCourse(String courseId, CreateModule createModule) {
        Course course = courseRepository.findByCourseCode(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found!"));

        CourseModule existingModule = moduleRepository.findByModuleName(createModule.getModuleName())
                .orElse(null);

        if (existingModule == null) {
            existingModule = new CourseModule();
            existingModule.setModuleName(createModule.getModuleName());
            existingModule.setModuleDescription(createModule.getModuleDescription());
            existingModule.setCourses(new HashSet<>()); // Ensure courses set is initialized
            moduleRepository.save(existingModule);
        }

        if (!existingModule.getCourses().contains(course)) {
            existingModule.getCourses().add(course);
        }

        if (!course.getModules().contains(existingModule)) {
            course.getModules().add(existingModule);
        }

        courseRepository.save(course);

        return new GetModuleInfo(existingModule);
    }



}
