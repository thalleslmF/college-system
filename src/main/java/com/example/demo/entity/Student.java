package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Student {
    @GeneratedValue
    @Id
    private Long id;
    @OneToOne
    private Course course;
    private String name;
    @OneToOne
    private Semester semester;
}
