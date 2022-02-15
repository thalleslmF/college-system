package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private Subject[] subjects;
}
