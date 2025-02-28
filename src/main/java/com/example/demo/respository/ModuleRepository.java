package com.example.demo.respository;

import com.example.demo.model.CourseModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ModuleRepository extends JpaRepository<CourseModule, Long> {
    boolean existsByModuleName(String moduleName);
    Optional<CourseModule> findByModuleName(String moduleName);
}
