package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Student 저장 요청을 위한 DTO 클래스 정의
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveRequestDto {
    //저장 요청에서 학생이름을 포함하는 필드
private String name;

//DTO를 Student 엔티티로 변환하는 메서드
public Student toEntity(){
    //Student 객체를 생성하여 반환(빌더 패턴)
    return Student.builder()
            .name(name)
            .build();
}
}
