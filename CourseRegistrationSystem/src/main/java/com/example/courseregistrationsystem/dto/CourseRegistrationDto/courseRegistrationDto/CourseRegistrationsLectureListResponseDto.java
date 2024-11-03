package com.example.courseregistrationsystem.dto.CourseRegistrationDto.courseRegistrationDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CourseRegistrationsLectureListResponseDto {
    private List<CourseRegistrationsLecturesResponseDto> lectures;

}
