package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Course;
import com.example.courseregistration.domain.Enrollment;
import com.example.courseregistration.domain.Student;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EnrollmentInfoResponseDto {
    private Long enrollmentId;
    private Long studentId;
    private Long courseId;

    public static EnrollmentInfoResponseDto from(Enrollment enrollment){
        return EnrollmentInfoResponseDto.builder()
                .enrollmentId(enrollment.getEnrollmentId())
                .studentId(enrollment.getStudent().getStudentId())
                .courseId(enrollment.getCourse().getCourseId())
                .build();
    }
}
