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
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String professor;

    private String slot;

    private String location;

    @OneToMany(mappedBy = "lecture",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseRegistration> courseRegistrations = new ArrayList<>();

    @Builder
    public Lecture(String title, String professor, String slot, String location) {
        this.title = title;
        this.professor = professor;
        this.slot = slot;
        this.location = location;
    }
    public  void update(String title, String professor, String slot, String location){
        this.title = title;
        this.professor = professor;
        this.slot = slot;
        this.location = location;
    }

}
