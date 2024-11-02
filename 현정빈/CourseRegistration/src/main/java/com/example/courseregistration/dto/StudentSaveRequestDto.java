package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveRequestDto {
private String name;

public Student toEntity(){
    return Student.builder()
            .name(name)
            .build();
}
}
