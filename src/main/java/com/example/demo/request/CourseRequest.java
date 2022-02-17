package com.example.demo.request;

import com.example.demo.entity.Course;
import com.example.demo.entity.Semester;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CourseRequest {
        private List<SemesterRequest> semesters;
        private String name;

        public Course toEntity() {
               var semesters =  this.semesters.stream().map(semester -> semester.toEntity()).collect(Collectors.toList());
               var course = new Course(semesters, name);
               semesters.forEach(it -> it.setCourse(course));
               return course;
        }
}
