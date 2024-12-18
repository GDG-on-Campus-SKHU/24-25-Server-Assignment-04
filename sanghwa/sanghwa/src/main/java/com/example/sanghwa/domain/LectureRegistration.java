package com.example.sanghwa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity //DB에 같은 이름의 테이블하고 매핑된다.
public class LectureRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY) //lecture의 기본키를 가져온다
    @JoinColumn(name = "lecture_id") //기본키를 외래키로 사용
    private Lecture lecture;

    @ManyToOne(fetch=FetchType.LAZY) //student의 기본키를 가져온다
    @JoinColumn(name = "student_id")//기본키를 외래키로 사용
    private Student student;

    @Builder
    public LectureRegistration(Long id, Lecture lecture, Student student) {
        this.id = id;
        this.lecture = lecture;
        this.student = student;
    }

    public String getLectureTitle(){
        return lecture.getTitle();
    }

    public String getStudentName(){
        return student.getName();
    }
}

