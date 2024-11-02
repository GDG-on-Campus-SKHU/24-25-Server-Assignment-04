package com.example.kyungwan.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="lecture_id", nullable = false)
    private Lecture lecture;

    public static CourseRegistration of(Student student, Lecture lecture) {
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.student = student;
        courseRegistration.lecture = lecture;
        return courseRegistration;
    }

    public CourseRegistration(Student student, Lecture lecture) {
        this.student = student;
        this.lecture = lecture;
    }
}




