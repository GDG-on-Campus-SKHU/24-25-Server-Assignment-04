package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Course;
import com.example.courseregistration.domain.Enrollment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Builder
public class CourseInfoResponseDto {
    private Long courseId;
    private String name;
    private String instructor;
    private List<Enrollment> enrollments;

    public static CourseInfoResponseDto from(Course course){
        return CourseInfoResponseDto.builder()
                .courseId(course.getCourseId())
                .name(course.getName())
                .instructor(course.getInstructor())
                .enrollments(course.getEnrollments())
                .build();
    }
}
