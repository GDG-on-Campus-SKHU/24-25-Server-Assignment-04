package com.example.kyungwan.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class LectureListResponseDto {
    List<LectureInfoResponseDto> lectureInfoResponseDtoList;

    public static LectureListResponseDto from(List<LectureInfoResponseDto> lectureInfoResponseDtoList) {
        return LectureListResponseDto.builder()
                .lectureInfoResponseDtoList(lectureInfoResponseDtoList)
                .build();
    }
}
