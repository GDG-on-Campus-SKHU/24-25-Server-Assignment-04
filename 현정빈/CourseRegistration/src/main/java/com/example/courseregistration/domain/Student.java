package com.example.courseregistration.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//Student Entity 클래스 정의
@Entity
@Getter
@NoArgsConstructor
public class Student {
    //학생 아이디를 기본키로 설정, 자동 생성으로 설정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    //학생 이름
    private String name;

    // Student 엔티티와 Enrollment 엔티티 간의 일대다 관계 설정
    // 'mappedBy' 속성은 이 관계의 주인이 Enrollment 엔티티의 'student' 필드임을 명시함
    // 즉, Enrollment 테이블에 외래 키가 존재하여 Student의 studentId를 참조함
    // 'fetch = FetchType.LAZY'는 지연 로딩으로, enrollments 컬렉션이 필요할 때만 데이터를 로드함
    // 'cascade = CascadeType.ALL'은 Student 엔티티의 변경이 enrollments에도 전파됨
    // 'orphanRemoval = true'는 Student에서 제거된 Enrollment가 자동으로 삭제되도록 함
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    //빌더 패턴을 사용하여 객체 생성
    @Builder
    public Student(Long studentId, String name, List<Enrollment> enrollments){
        this.studentId = studentId;
        this.name = name;
        this.enrollments = enrollments;
    }

    //학생 이름을 업데이트 하는 메서드
    public void update(String name) {
        this.name = name;
    }
}
