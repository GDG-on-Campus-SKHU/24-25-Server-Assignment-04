package com.example.courseregistrationsystem.dto.CourseRegistrationDto.courseRegistrationDto;

import com.example.courseregistrationsystem.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CourseRegistrationStudentsResponseDto {
    private Long id;
    private Long studentNumber;
    private String name;

    public static CourseRegistrationStudentsResponseDto from(Student student) {
        return CourseRegistrationStudentsResponseDto.builder()
                .id(student.getId())
                .studentNumber(student.getStudentNumber())
                .name(student.getName())
                .build();
    }
}
