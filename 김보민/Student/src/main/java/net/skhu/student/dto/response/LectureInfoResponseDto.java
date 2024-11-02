package net.skhu.student.dto.response;
import lombok.Builder;
import lombok.Getter;
import net.skhu.student.domain.Enrollment;
import net.skhu.student.domain.Lecture;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class LectureInfoResponseDto {
    private Long id;
    private String title;
    private Long number;
    private List<Enrollment> enrollments;

    public static LectureInfoResponseDto from(Lecture lecture) {
        return LectureInfoResponseDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .number(lecture.getNumber())
                .enrollments(lecture.getEnrollments())
                .build();
    }

    public static List<LectureInfoResponseDto> from(List<Lecture> lectures){
        return lectures.stream()
                .map(LectureInfoResponseDto::from)
                .collect(Collectors.toList());
    }
}