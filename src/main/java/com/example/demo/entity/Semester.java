package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Semester {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semester")
    private List<Subject> subjects;
    private int number;
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="course_id")
    private Course course;

    public Semester() {
    }

    public Semester(List<Subject> subjects, int number) {
        this.subjects = subjects;
        this.number = number;
    }
}
