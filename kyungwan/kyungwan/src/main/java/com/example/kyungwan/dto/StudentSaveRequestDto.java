package com.example.kyungwan.dto;

import com.example.kyungwan.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class StudentSaveRequestDto {
    private String name;
    private Long studentNumber;

    public Student toEntity(){
        return Student.builder()
                .name(name)
                .studentNumber(studentNumber)
                .build();
    }
}
