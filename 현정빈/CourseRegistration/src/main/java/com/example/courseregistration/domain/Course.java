package com.example.courseregistration.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    private String name;
    private String instructor;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    @Builder
    public Course(Long courseId, String name, String instructor, List<Enrollment> enrollments){
        this.courseId = courseId;
        this.name = name;
        this.instructor = instructor;
        this.enrollments = enrollments;
    }

    public void update(String name, String instructor){
        this.name = name;
        this.instructor = instructor;
    }
}
