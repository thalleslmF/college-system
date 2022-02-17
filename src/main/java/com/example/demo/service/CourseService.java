package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CourseService {

    public Course create(Course course);
    public Course update(long id);
    public void delete(long id);
    public Course findById(long id);

}
