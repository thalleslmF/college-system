package com.example.demo.request;

import com.example.demo.entity.Semester;
import com.example.demo.entity.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class SemesterRequest {
    private List<SubjectRequest> subjects;
    private int number;

    public Semester toEntity() {
        var semester = new Semester(this.subjects.stream().map(it -> it.toEntity(null)).collect(Collectors.toList()), this.number);
        semester.getSubjects().forEach(it -> it.setSemester(semester));
        return semester;
    }
}
