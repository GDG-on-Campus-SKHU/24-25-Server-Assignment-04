package com.example.courseregistrationsystem.domain;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor                              //기본생성자 생성
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                            //학생 고유번호

    @Column(name = "student_number", unique = true)
    private Long studentNumber;                     //학번

    @Column(nullable = false)
    private String name;                        //학생 이름

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)           //강의 와 학생의 외래키 설정
    private List<CourseRegistration> courseRegistrations = new ArrayList<>();

    @Builder
    public Student(Long studentNumber,String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }

    public void update(Long studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }

}
