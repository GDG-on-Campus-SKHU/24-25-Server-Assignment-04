package net.skhu.student.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.skhu.student.domain.Enrollment;

//수강신청에 대한 상세 정보와 학생, 강의정보를 응답으로 전달하는데 사용
@Getter
@Builder
@AllArgsConstructor
public class EnrollmentInfoResponseDto {
    private Long id;
    private String title;
    private Long date;
    private Long studentId;
    private String studentName;
    private Long lectureId;
    private String lectureTitle;

    public static EnrollmentInfoResponseDto from(Enrollment enrollment){
        return EnrollmentInfoResponseDto.builder()
                .id(enrollment.getId())
                .title(enrollment.getTitle())
                .date(enrollment.getDate())
                .studentId(enrollment.getStudent().getId())
                .studentName(enrollment.getStudent().getName())
                .lectureId(enrollment.getLecture().getId())
                .lectureTitle(enrollment.getLecture().getTitle())
                .build();
    }
}
