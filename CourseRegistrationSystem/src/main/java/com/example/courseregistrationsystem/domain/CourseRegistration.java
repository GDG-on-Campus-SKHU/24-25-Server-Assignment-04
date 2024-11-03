package com.example.courseregistrationsystem.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)          //강의 와 학생의 외래키 설정
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)          //강의 와 학생의 외래키 설정
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    public static CourseRegistration of(Student student, Lecture lecture) {
        CourseRegistration registration = new CourseRegistration();
        registration.student = student;
        registration.lecture = lecture;
        return registration;
    }

    public CourseRegistration(Student student ,Lecture lecture) {
        this.student = student;
        this.lecture = lecture;
    }
}

