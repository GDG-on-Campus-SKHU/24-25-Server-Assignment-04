package com.example.kyungwan.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long studentNumber;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseRegistration> courseRegistrations = new ArrayList<>();

    @Builder
    public Student( String name , Long studentNumber ) {
        this.name = name;
        this.studentNumber = studentNumber;

    }

    public void update(String name, Long studentNumber){
        this.name = name;
        this.studentNumber = studentNumber;

    }
}
