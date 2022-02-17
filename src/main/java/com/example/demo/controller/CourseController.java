package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.request.CourseRequest;
import com.example.demo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/courses")
@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void save (@RequestBody CourseRequest courseRequest) {
        this.courseService.create(courseRequest.toEntity());
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Course findById(@PathVariable  Long id) {
        return this.courseService.findById(id);
    }
}
