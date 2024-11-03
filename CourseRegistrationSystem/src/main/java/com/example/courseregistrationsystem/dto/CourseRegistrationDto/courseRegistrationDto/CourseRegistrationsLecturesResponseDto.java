package com.example.courseregistrationsystem.dto.CourseRegistrationDto.courseRegistrationDto;

import com.example.courseregistrationsystem.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CourseRegistrationsLecturesResponseDto {
    private Long id;
    private String lectureName;
    private String professorName;
    private Integer credit;

    public static CourseRegistrationsLecturesResponseDto from(Lecture lecture){
        return CourseRegistrationsLecturesResponseDto.builder()
                .id(lecture.getId())
                .lectureName(lecture.getLectureName())
                .professorName(lecture.getProfessorName())
                .credit(lecture.getCredit())
                .build();
    }
}
