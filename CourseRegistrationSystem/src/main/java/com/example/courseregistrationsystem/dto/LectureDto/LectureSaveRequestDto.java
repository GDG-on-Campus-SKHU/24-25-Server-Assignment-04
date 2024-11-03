package com.example.courseregistrationsystem.dto.LectureDto;


import com.example.courseregistrationsystem.domain.Lecture;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LectureSaveRequestDto {
    private String lectureName;
    private String professorName;
    private Integer credit;

    // Entity -> dto
    public Lecture toEntity() {
        return Lecture.builder()
                .lectureName(lectureName)
                .professorName(professorName)
                .credit(credit)
                .build();
    }
}
