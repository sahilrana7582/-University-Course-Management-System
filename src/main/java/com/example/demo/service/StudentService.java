package com.example.demo.service;


import com.example.demo.dto.studentDTO.CreateStudentAsPersonDTO;
import com.example.demo.dto.studentDTO.CreateStudentDTO;
import com.example.demo.dto.studentDTO.GetStudentDTO;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.respository.CourseRepository;
import com.example.demo.respository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;


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

    @Transactional
    public GetStudentDTO enrollStudentInCourse(Long studentId, Long courseId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Student student = studentOpt.get();
            Course course = courseOpt.get();

            student.getCourses().add(course);
            course.getStudents().add(student);

            studentRepository.save(student);
            courseRepository.save(course);

            GetStudentDTO dto = new GetStudentDTO();
            dto.setId(student.getId());
            dto.setFirstName(student.getFirstName());
            dto.setLastName(student.getLastName());
            dto.setPhone(student.getPhone());
            dto.setEmail(student.getEmail());
            dto.setAge(student.getAge());
            dto.setGender(student.getGender());
            dto.setEnrollmentYear(student.getEnrollmentYear());
            dto.setStudentId(student.getStudentId());
            dto.setCourses(student.getCourses());

            return dto;
        } else {
            throw new RuntimeException("Something Went Wrong! Either Student or Course not found.");
        }
    }

}
