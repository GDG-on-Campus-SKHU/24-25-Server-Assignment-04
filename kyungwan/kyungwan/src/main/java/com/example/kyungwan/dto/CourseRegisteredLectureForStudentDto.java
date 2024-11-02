package com.example.kyungwan.dto;

import com.example.kyungwan.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CourseRegisteredLectureForStudentDto {
    private Long id;
    private String title;
    private String professor;
    private String location;
    private String slot ;

    public static CourseRegisteredLectureForStudentDto from(Lecture lecture){
        return CourseRegisteredLectureForStudentDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .professor(lecture.getProfessor())
                .location(lecture.getLocation())
                .slot(lecture.getSlot())
                .build();
    }


}
