package com.example.courseregistrationsystem.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                            //고유번호

    private String lectureName;                 //강의이름

    private String professorName;               //교수이름

    private Integer credit;                     //학점

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)           //강의와 수강신청의 외래키 설정
    private List<CourseRegistration> courseRegistrations = new ArrayList<>();

    @Builder
    public Lecture(String lectureName, String professorName, Integer credit) {
        this.lectureName = lectureName;
        this.professorName = professorName;
        this.credit = credit;
    }

    public void update(String lectureName, String professorName, Integer credit) {
        this.lectureName = lectureName;
        this.professorName = professorName;
        this.credit = credit;
    }
}

