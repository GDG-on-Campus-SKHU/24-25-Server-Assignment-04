package net.skhu.student.dto.response;
import lombok.Builder;
import lombok.Getter;
import java.util.List;
//수강신청 정보를 하나의 응답으로 담아 전송

@Builder
@Getter
public class EnrollmentListResponseDto {
    List<EnrollmentInfoResponseDto> enrollmentInfoResponseDTO;

    public static EnrollmentListResponseDto from(List<EnrollmentInfoResponseDto> enrollmentInfoResponseDTO){
        return EnrollmentListResponseDto.builder()
                .enrollmentInfoResponseDTO(enrollmentInfoResponseDTO)
                .build();
    }
}
