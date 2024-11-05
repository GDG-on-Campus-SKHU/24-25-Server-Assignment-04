package net.skhu.student.dto.response;
import lombok.Builder;
import lombok.Getter;
import net.skhu.student.domain.Lecture;

@Getter
@Builder
public class LectureInfoResponseDto {
    private Long id;
    private String title;
    private Long number;

    public static LectureInfoResponseDto from(Lecture lecture) { //lecture -> dto로 변경
        return LectureInfoResponseDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .number(lecture.getNumber())
                .build();
    }
}