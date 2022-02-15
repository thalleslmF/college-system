package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

public interface CourseService {

    public Course create(Course course);
    public Course update(long id);
    public void delete(long id);
    public Course findById(String id);

}
