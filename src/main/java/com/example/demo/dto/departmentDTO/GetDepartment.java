package com.example.demo.dto.departmentDTO;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDepartment {
    private Long id;

    @NotBlank
    private String name;

    private Long code;
}
