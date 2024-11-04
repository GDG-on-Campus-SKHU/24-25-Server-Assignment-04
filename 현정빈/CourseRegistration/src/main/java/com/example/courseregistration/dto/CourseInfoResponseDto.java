package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Course;
import com.example.courseregistration.domain.Enrollment;
import lombok.Builder;
import lombok.Getter;

// 강의 정보를 응답하기 위한 DTO 클래스 정의
import java.util.List;
@Getter
@Builder
public class CourseInfoResponseDto {

    // 강의 아이디
    private Long courseId;
    // 강의명
    private String name;
    // 교수명
    private String instructor;

    // Course 엔티티 객체를 받아서 CourseInfoResponseDto로 변환하는 정적 메서드
    public static CourseInfoResponseDto from(Course course){
        // Course 엔티티의 정보를 기반으로 CourseInfoResponseDto 객체를 생성하여 반환
        return CourseInfoResponseDto.builder()
                .courseId(course.getCourseId())
                .name(course.getName())
                .instructor(course.getInstructor())
                .build();
    }
}
