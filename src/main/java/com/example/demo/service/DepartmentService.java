package com.example.demo.service;

import com.example.demo.dto.departmentDTO.AddDepartment;
import com.example.demo.dto.departmentDTO.AddManyDepartments;
import com.example.demo.dto.departmentDTO.GetDepartment;
import com.example.demo.dto.departmentDTO.GetDepartmentOverview;
import com.example.demo.model.Department;
import com.example.demo.respository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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




        @Transactional
        public List<GetDepartment> insertManyDepartments(AddManyDepartments addManyDepartments) {
            List<AddDepartment> departmentsToAdd = addManyDepartments.getAddDepartments();

            List<GetDepartment> result = departmentsToAdd.stream().map(deptDTO -> {
                Department department = new Department();
                department.setName(deptDTO.getName());
                department.setCode(deptDTO.getCode());

                Department savedDepartment = departmentRepository.save(department);

                GetDepartment getDept = new GetDepartment();
                getDept.setId(savedDepartment.getId());
                getDept.setName(savedDepartment.getName());
                getDept.setCode(savedDepartment.getCode());

                return getDept;
            }).collect(Collectors.toList());

            return result;
        }




    public List<GetDepartmentOverview> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream()
                .map(department -> new GetDepartmentOverview(
                        department.getId(),
                        department.getName(),
                        department.getCode(),
                        department.getCourses().size() // Only return the count of courses
                ))
                .collect(Collectors.toList());
    }


    public Department getDepartmentInfo(String departmentId){
        return departmentRepository.findByCode(departmentId).orElseThrow(()-> new RuntimeException("Department Not Found!"));
    }

}
