package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Course;
import com.example.courseregistration.domain.Enrollment;
import com.example.courseregistration.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentSaveRequestDto {
    private Long studentId;
    private Long courseId;

    public Enrollment toEntity(Student student, Course course){
        return Enrollment.builder()
                .student(student)
                .course(course)
                .build();
    }
}
