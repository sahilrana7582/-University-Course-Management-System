package com.example.demo.service;


import com.example.demo.dto.studentDTO.CreateStudentAsPersonDTO;
import com.example.demo.dto.studentDTO.CreateStudentDTO;
import com.example.demo.dto.studentDTO.GetStudentDTO;
import com.example.demo.model.Student;
import com.example.demo.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public GetStudentDTO createNewStudent(CreateStudentAsPersonDTO dto) {
        Student student = new Student();

        // Setting inherited Person fields
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setPhone(dto.getPhone());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());
        student.setGender(dto.getGender());

        student.setEnrollmentYear(dto.getEnrollmentYear());
        student.setStudentId(dto.getStudentId());

        Student savedStudent = studentRepository.save(student);

        GetStudentDTO response = new GetStudentDTO();
        response.setId(savedStudent.getId());
        response.setFirstName(savedStudent.getFirstName());
        response.setLastName(savedStudent.getLastName());
        response.setPhone(savedStudent.getPhone());
        response.setEmail(savedStudent.getEmail());
        response.setAge(savedStudent.getAge());
        response.setGender(savedStudent.getGender());
        response.setEnrollmentYear(savedStudent.getEnrollmentYear());
        response.setStudentId(savedStudent.getStudentId());

        return response;
    }


    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
}
