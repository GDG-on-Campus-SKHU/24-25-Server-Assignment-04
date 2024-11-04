package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Course;
import com.example.courseregistration.domain.Enrollment;
import com.example.courseregistration.domain.Student;
import lombok.Builder;
import lombok.Getter;

// 수강신청 정보를 응답하기 위한 DTO 클래스 정의
@Builder
@Getter
public class EnrollmentInfoResponseDto {
    // 수강신청 아이디
    private Long enrollmentId;
    // 학생 아이디
    private Long studentId;
    // 강의 아이디
    private Long courseId;

    // Enrollment 엔티티를 받아서 EnrollmentInfoResponseDto로 변환하는 정적 메서드
    public static EnrollmentInfoResponseDto from(Enrollment enrollment){
        // 엔티티 객체의 정보를 기반으로 DTO 객체 생성 및 반환
        return EnrollmentInfoResponseDto.builder()
                .enrollmentId(enrollment.getEnrollmentId())
                .studentId(enrollment.getStudent().getStudentId())
                .courseId(enrollment.getCourse().getCourseId())
                .build();
    }
}
