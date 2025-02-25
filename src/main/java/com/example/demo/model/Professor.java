package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "professor")
@Getter
@Setter
public class Professor extends Person{

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "professor_id", nullable = false, unique = true)
    private Long professorId;


    @Column(name = "title")
    private String title;

}
