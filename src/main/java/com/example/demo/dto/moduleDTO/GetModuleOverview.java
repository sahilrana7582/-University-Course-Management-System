package com.example.demo.dto.moduleDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetModuleOverview {
    private Long id;
    private String moduleName;
    private String moduleDescription;
}
