package com.example.demo.controller;

import com.example.demo.dto.departmentDTO.AddDepartment;
import com.example.demo.dto.departmentDTO.AddManyDepartments;
import com.example.demo.dto.departmentDTO.GetDepartment;
import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public GetDepartment addDepartment(@RequestBody @Valid AddDepartment addDepartment){
        return departmentService.addDepartment(addDepartment);
    }

    @GetMapping
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<GetDepartment>> insertManyDepartments(@RequestBody AddManyDepartments addManyDepartments) {
        List<GetDepartment> savedDepartments = departmentService.insertManyDepartments(addManyDepartments);
        return ResponseEntity.ok(savedDepartments);
    }
}
