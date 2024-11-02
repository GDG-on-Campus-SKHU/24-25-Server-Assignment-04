package com.example.courseregistration.dto;

import com.example.courseregistration.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseSaveRequestDto {
    private String name;
    private String instructor;

    public Course toEntity(){
        return Course.builder()
                .name(name)
                .instructor(instructor)
                .build();
    }
}
