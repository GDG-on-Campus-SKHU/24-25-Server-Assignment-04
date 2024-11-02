package com.example.kyungwan.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class StudentListResponseDto {
    List<StudentInfoResponseDto> studentInfoResponseDtoList;

    public static StudentListResponseDto from(List<StudentInfoResponseDto> studentResponseDtoList) {
        return StudentListResponseDto.builder()
                .studentInfoResponseDtoList(studentResponseDtoList)
                .build();

    }

}
