package com.example.demo.dto.departmentDTO;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddManyDepartments {
    private List<AddDepartment> addDepartments;
}
