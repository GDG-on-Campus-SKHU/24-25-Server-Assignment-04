package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Enrollment;
import com.example.courseregistration.domain.Student;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentInfoResponseDto {
    private Long studentId;
    private String name;
    private List<Enrollment> enrollments;

    public static StudentInfoResponseDto from(Student student){
        return StudentInfoResponseDto.builder()
                .studentId(student.getStudentId())
                .name(student.getName())
                .enrollments(student.getEnrollments())
                .build();
    }
}
