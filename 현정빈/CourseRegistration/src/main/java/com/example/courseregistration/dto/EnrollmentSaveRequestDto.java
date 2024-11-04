package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Course;
import com.example.courseregistration.domain.Enrollment;
import com.example.courseregistration.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Enrollment 저장 요청을 위한 DTO 클래스 정의
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentSaveRequestDto {
    // 수강신청시 필요한 학생 아이디
    private Long studentId;
    // 수강신청시 필요한 강의 아이디
    private Long courseId;

    // DTO를 Enrollment 엔티티로 변환하는 메서드
    public Enrollment toEntity(Student student, Course course){
        // Student와 Course 객체를 받아서 Enrollment 객체를 생성하고 반환
        return Enrollment.builder()
                .student(student)
                .course(course)
                .build();
    }
}
