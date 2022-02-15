package com.example.demo.controller;

import com.example.demo.request.CourseRequest;
import com.example.demo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void save (@RequestBody CourseRequest courseRequest) {

    }
}
