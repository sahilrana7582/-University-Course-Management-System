package com.example.demo.controller;


import com.example.demo.dto.moduleDTO.CreateModule;
import com.example.demo.dto.moduleDTO.GetModuleInfo;
import com.example.demo.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @PostMapping("/assign/{courseCode}")
    public ResponseEntity<GetModuleInfo> createModuleAndAssignToCourse(
            @PathVariable String courseCode,
            @RequestBody CreateModule createModule) {
        GetModuleInfo moduleInfo = moduleService.createModuleAndAssignToCourse(courseCode, createModule);
        return ResponseEntity.ok(moduleInfo);
    }

}
