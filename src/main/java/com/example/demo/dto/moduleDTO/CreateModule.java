package com.example.demo.dto.moduleDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateModule {

    @NotBlank(message = "Module name is required")
    private String moduleName;

    private String moduleDescription;
}
