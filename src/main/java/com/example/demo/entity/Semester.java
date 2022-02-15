package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Semester {
    @GeneratedValue
    @Id
    private Long id;
    @ManyToOne
    private Subject[] subjects;
    private int number;
}
