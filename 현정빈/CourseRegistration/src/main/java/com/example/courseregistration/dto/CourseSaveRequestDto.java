package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Course 저장 요청을 위한 DTO 클래스 정의
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseSaveRequestDto {
    //저장 요청에서 강의명을 포함하는 필드
    private String name;
    //저장 요청에서 교수명을 포함하는 필드
    private String instructor;

    //DTO를 Course 엔티티로 변환하는 메서드
    public Course toEntity(){
        //Course 객체를 생성하여 반환(빌더 패턴)
        return Course.builder()
                .name(name)
                .instructor(instructor)
                .build();
    }
}
