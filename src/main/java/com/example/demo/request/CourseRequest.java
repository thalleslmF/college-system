package com.example.demo.request;

import com.example.demo.entity.Semester;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {
        private SemesterRequest[] semesters;
        private String name;
}
