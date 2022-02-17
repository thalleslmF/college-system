package com.example.demo.request;

import com.example.demo.entity.Subject;
import com.example.demo.entity.Teacher;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectRequest {
    private String name;
    private long teacherId;

    public Subject toEntity(Teacher teacher) {
        return new Subject(this.name, teacher);
    }
}
