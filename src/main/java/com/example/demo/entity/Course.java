package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Course {
    @GeneratedValue
    @Id
    private Long id;
    @ManyToOne
    private Semester[] semesters;
    private String name;
}
