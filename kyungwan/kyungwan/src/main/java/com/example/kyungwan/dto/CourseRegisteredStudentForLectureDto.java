package com.example.kyungwan.dto;

import com.example.kyungwan.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CourseRegisteredStudentForLectureDto {
    private Long id;
    private String name;
    private Long studentNumber;

    public static CourseRegisteredStudentForLectureDto from(Student student) {
        return CourseRegisteredStudentForLectureDto.builder()
                .id(student.getId())
                .name(student.getName())
                .studentNumber(student.getStudentNumber())
                .build();
    }
}
