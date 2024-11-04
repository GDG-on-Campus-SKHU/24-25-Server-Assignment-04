package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Enrollment;
import com.example.courseregistration.domain.Student;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

// 학생 정보를 응답하기 위한 DTO 클래스 정의
@Getter
@Builder
public class StudentInfoResponseDto {
    //학생 아이디
    private Long studentId;
    //학생 이름
    private String name;

    // Student 엔티티 객체를 받아서 StudentInfoResponseDto로 변환하는 정적 메서드
    public static StudentInfoResponseDto from(Student student){
        // Student 엔티티의 정보를 기반으로 StudentInfoResponseDto 객체를 생성하여 반환
        return StudentInfoResponseDto.builder()
                .studentId(student.getStudentId())
                .name(student.getName())
                .build();
    }
}
