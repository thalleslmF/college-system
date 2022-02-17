package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Course {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Semester> semesters;
    private String name;

    public Course(List<Semester> semesters, String name) {
        this.semesters = semesters;
        this.name = name;
    }

    public Course() {
    }
}
