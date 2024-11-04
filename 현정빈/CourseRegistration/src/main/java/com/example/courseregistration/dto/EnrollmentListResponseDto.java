package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Enrollment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

// 수강신청 목록 정보를 응답하기 위한 DTO 클래스 정의
@Builder
@Getter
public class EnrollmentListResponseDto {
    // 수강신청 정보 목록을 담는 리스트
    List<EnrollmentInfoResponseDto> enrollments;

    // EnrollmentInfoResponseDto 리스트를 받아서 EnrollmentListResponseDto 객체로 변환하는 정적 메서드
    public static EnrollmentListResponseDto from(List<EnrollmentInfoResponseDto> enrollments){
        // 엔티티 리스트를 기반으로 DTO 객체 생성 및 반환
        return EnrollmentListResponseDto.builder()
                .enrollments(enrollments)
                .build();
    }
}
