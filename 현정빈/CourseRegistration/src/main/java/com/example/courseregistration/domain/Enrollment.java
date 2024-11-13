package com.example.courseregistration.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Enrollment Entity 클래스 정의
@Entity
@NoArgsConstructor
@Getter
public class Enrollment {
    //수강신청 아이디를 기본키로 설정, 자동 생성 설정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long enrollmentId;

    //Enrollment와 Student의 다대일 관계, 외래키 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student")
    private Student student;

    //Enrollment와 Course의 다대일 관계, 외래키 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")
    private Course course;

    //빌더 패턴으로 객체 생성(Enrollment 객체를 생성할 때 Student와 Course 필드를 설정)
    @Builder
    public Enrollment(Student student, Course course){
        this.student = student;
        this.course = course;
    }
}
