package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Subject {
    @GeneratedValue
    @Id
    private Long id;

    private String name;
    @OneToOne
    private Teacher teacher;
}
