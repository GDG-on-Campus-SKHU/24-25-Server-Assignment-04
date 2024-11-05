package net.skhu.student.dto.response;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class StudentListResponseDto {
    List<StudentInfoResponseDto> studentInfoResponseDto;
    public static StudentListResponseDto from(List<StudentInfoResponseDto> studentInfoResponseDTO){
        return StudentListResponseDto.builder()
                .studentInfoResponseDto(studentInfoResponseDTO)
                .build();
    }
}