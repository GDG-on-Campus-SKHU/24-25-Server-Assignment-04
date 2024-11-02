package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Enrollment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class EnrollmentListResponseDto {
    List<EnrollmentInfoResponseDto> enrollments;

    public static EnrollmentListResponseDto from(List<EnrollmentInfoResponseDto> enrollments){
        return EnrollmentListResponseDto.builder()
                .enrollments(enrollments)
                .build();
    }
}
