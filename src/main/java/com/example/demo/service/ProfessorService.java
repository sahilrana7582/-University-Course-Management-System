package com.example.demo.service;


import com.example.demo.dto.professorDTO.CreateProfessorWithPersonInfoDTO;
import com.example.demo.dto.professorDTO.GetProfessorDTO;
import com.example.demo.dto.studentDTO.CreateStudentAsPersonDTO;
import com.example.demo.model.Professor;
import com.example.demo.respository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;


    public GetProfessorDTO createProfessorAsPerson(CreateProfessorWithPersonInfoDTO createProfessorWithPersonInfoDTO) {
        Professor newProfessor = new Professor();

        newProfessor.setFirstName(createProfessorWithPersonInfoDTO.getFirstName());
        newProfessor.setLastName(createProfessorWithPersonInfoDTO.getLastName());
        newProfessor.setPhone(createProfessorWithPersonInfoDTO.getPhone());
        newProfessor.setEmail(createProfessorWithPersonInfoDTO.getEmail());
        newProfessor.setAge(createProfessorWithPersonInfoDTO.getAge());
        newProfessor.setGender(createProfessorWithPersonInfoDTO.getGender());

        newProfessor.setSpecialization(createProfessorWithPersonInfoDTO.getSpecialization());
        newProfessor.setTitle(createProfessorWithPersonInfoDTO.getTitle());
        newProfessor.setProfessorId(createProfessorWithPersonInfoDTO.getProfessorId());

        Professor savedProfessor = professorRepository.save(newProfessor);

        GetProfessorDTO getProfessorDTO = new GetProfessorDTO();
        getProfessorDTO.setId(savedProfessor.getId());
        getProfessorDTO.setFirstName(savedProfessor.getFirstName());
        getProfessorDTO.setLastName(savedProfessor.getLastName());
        getProfessorDTO.setPhone(savedProfessor.getPhone());
        getProfessorDTO.setEmail(savedProfessor.getEmail());
        getProfessorDTO.setAge(savedProfessor.getAge());
        getProfessorDTO.setGender(savedProfessor.getGender());
        getProfessorDTO.setSpecialization(savedProfessor.getSpecialization());
        getProfessorDTO.setTitle(savedProfessor.getTitle());
        getProfessorDTO.setProfessorId(savedProfessor.getProfessorId());

        return getProfessorDTO;
    }

    public List<Professor> getAllProfessor(){
        return professorRepository.findAll();
    }

}
