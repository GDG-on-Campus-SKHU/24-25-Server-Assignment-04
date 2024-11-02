package com.example.kyungwan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class LectureSaveRequestDto {
    private String title;
    private String professor;
    private String slot;
    private String location;

}
