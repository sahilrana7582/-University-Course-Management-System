package com.example.demo.controller;


import com.example.demo.dto.moduleDTO.CreateModule;
import com.example.demo.dto.moduleDTO.GetModuleInfo;
import com.example.demo.dto.moduleDTO.GetModuleOverview;
import com.example.demo.model.CourseModule;
import com.example.demo.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{moduleId}")
    public GetModuleInfo getModuleById(@PathVariable Long moduleId){
        return moduleService.getModuleInfo(moduleId);
    }

    @GetMapping
    public List<GetModuleOverview> getAllModules(){
        return moduleService.getAllModules();
    }

}
