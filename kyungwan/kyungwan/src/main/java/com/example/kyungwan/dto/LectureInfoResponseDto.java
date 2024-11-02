package com.example.kyungwan.dto;

import com.example.kyungwan.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LectureInfoResponseDto {
    private Long id;
    private String title;
    private String professor;
    private String slot;
    private String location;

    public static LectureInfoResponseDto from(Lecture lecture) {
        return LectureInfoResponseDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .professor(lecture.getProfessor())
                .slot(lecture.getSlot())
                .location(lecture.getLocation())
                .build();
    }
}

