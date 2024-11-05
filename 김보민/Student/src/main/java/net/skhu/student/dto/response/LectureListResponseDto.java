package net.skhu.student.dto.response;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class LectureListResponseDto {
    List<LectureInfoResponseDto> lectureInfoResponseDto;
    public static LectureListResponseDto from(List<LectureInfoResponseDto> lectureInfoResponseDTO){
        return LectureListResponseDto.builder()
                .lectureInfoResponseDto(lectureInfoResponseDTO)
                .build();
    }
}
