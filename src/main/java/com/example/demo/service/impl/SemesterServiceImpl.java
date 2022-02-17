package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.Semester;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.SemesterRepository;
import com.example.demo.service.SemesterService;
import org.springframework.stereotype.Component;

@Component
public class SemesterServiceImpl implements SemesterService {

    private final SemesterRepository semesterRepository;

    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }


    @Override
    public Semester create(Semester semester) {
        return this.semesterRepository.save(semester);
    }

    @Override
    public Semester update(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Semester findById(long id) {
        return null;
    }
}
