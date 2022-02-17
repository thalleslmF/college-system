package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.SemesterRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.SemesterService;
import org.springframework.stereotype.Component;

@Component
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository, SemesterService semesterService) {
        this.courseRepository = courseRepository;
    }
    @Override
    public Course create(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public Course update(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Course findById(String id) {
        return null;
    }
}
