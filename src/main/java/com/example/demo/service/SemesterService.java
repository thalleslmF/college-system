package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Semester;

public interface SemesterService {
    public Semester create(Semester semester);
    public Semester update(long id);
    public void delete(long id);
    public Semester findById(long id);
}
