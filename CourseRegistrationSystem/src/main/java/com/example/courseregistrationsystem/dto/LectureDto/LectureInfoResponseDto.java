package com.example.courseregistrationsystem.dto.LectureDto;

import com.example.courseregistrationsystem.domain.CourseRegistration;
import com.example.courseregistrationsystem.domain.Lecture;
import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.dto.studentDto.StudentInfoResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;



@Getter
@Builder
public class LectureInfoResponseDto {
    private Long id;
    private String lectureName;
    private String professorName;
    private Integer credit;


    // Dto -> Entity
    public static LectureInfoResponseDto from(Lecture lecture) {
        return LectureInfoResponseDto.builder()
                .id(lecture.getId())
                .lectureName(lecture.getLectureName())
                .professorName(lecture.getProfessorName())
                .credit(lecture.getCredit())
                .build();
    }
}
