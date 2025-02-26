package com.example.demo.controller;


import com.example.demo.dto.studentDTO.CreateStudentAsPersonDTO;
import com.example.demo.dto.studentDTO.CreateStudentDTO;
import com.example.demo.dto.studentDTO.GetStudentDTO;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public GetStudentDTO createNewStudentWithPerson(@RequestBody @Valid CreateStudentAsPersonDTO createStudentAsPersonDTO){
        return studentService.createNewStudent(createStudentAsPersonDTO);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public GetStudentDTO enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId){
        return studentService.enrollStudentInCourse(studentId, courseId);
    }

}
