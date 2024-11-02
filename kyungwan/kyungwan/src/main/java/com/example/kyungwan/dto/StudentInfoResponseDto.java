package com.example.kyungwan.dto;

import com.example.kyungwan.domain.Lecture;
import com.example.kyungwan.domain.Student;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Builder

public class StudentInfoResponseDto {
    private Long id;
    private String name;
    private Long studentNumber;;


    public static StudentInfoResponseDto from(Student student) {
        return StudentInfoResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .studentNumber(student.getStudentNumber())
                .build();

    }
}
