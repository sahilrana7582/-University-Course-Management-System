package com.example.demo.dto.moduleDTO;

import com.example.demo.model.CourseModule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetModuleInfo {
    private Long id;
    private String moduleName;
    private String moduleDescription;
    private List<CourseInfo> courses; // Changed from Set to List

    public GetModuleInfo(CourseModule module) {
        this.id = module.getId();
        this.moduleName = module.getModuleName();
        this.moduleDescription = module.getModuleDescription();
        this.courses = module.getCourses().stream()
                .map(course -> new CourseInfo(course.getId(), course.getCourseName())) // Only ID & Name
                .collect(Collectors.toList());
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CourseInfo {
        private Long id;
        private String courseName;
    }
}
