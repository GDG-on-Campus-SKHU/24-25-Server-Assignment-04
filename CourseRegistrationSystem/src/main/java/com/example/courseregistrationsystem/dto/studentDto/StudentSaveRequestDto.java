package com.example.courseregistrationsystem.dto.studentDto;

import com.example.courseregistrationsystem.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveRequestDto {
    private Long studentNumber;
    private String name;

    public Student toEntity() {
        return Student.bui
        lder()
                .studentNumber(studentNumber)
                .name(name)
                .build();
    }
}
