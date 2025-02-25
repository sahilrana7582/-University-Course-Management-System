package com.example.demo.service;

import com.example.demo.dto.departmentDTO.AddDepartment;
import com.example.demo.dto.departmentDTO.GetDepartment;
import com.example.demo.model.Department;
import com.example.demo.respository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public GetDepartment addDepartment(AddDepartment addDepartment) {
        Department department = new Department();
        department.setName(addDepartment.getName());
        department.setCode(addDepartment.getCode());

        Department savedDepartment = departmentRepository.save(department);

        return new GetDepartment(savedDepartment.getId(), savedDepartment.getName(), savedDepartment.getCode());
    }


    public List<Department> getDepartment(){
        return departmentRepository.findAll();
    }

}
