package com.example.demo.controller;


import com.example.demo.dto.professorDTO.CreateProfessorWithPersonInfoDTO;
import com.example.demo.dto.professorDTO.GetProfessorDTO;
import com.example.demo.dto.studentDTO.CreateStudentAsPersonDTO;
import com.example.demo.model.Professor;
import com.example.demo.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;


    @PostMapping
    public GetProfessorDTO createProfessorAsPerson(@RequestBody @Valid CreateProfessorWithPersonInfoDTO createProfessorWithPersonInfoDTO){
        return professorService.createProfessorAsPerson(createProfessorWithPersonInfoDTO);
    }

    @GetMapping
    public List<Professor> getAllProfessor(){
        return professorService.getAllProfessor();
    }
}
