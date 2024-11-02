package com.example.kyungwan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CourseRegisteredLecturesResponseDto {
    private List<CourseRegisteredLectureForStudentDto> lectures;
}
