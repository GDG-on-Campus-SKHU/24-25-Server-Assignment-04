package net.skhu.student.dto.response;
import lombok.Builder;
import lombok.Getter;
import net.skhu.student.domain.Student;

//받아온 정보들을 바탕에 데이터베이스 -> 프론트
@Getter
@Builder
public class StudentInfoResponseDto {//클라이언트에 응답할 학생 정보 담고 있음.
    private Long id;
    private String name;

    public static StudentInfoResponseDto from(Student student){ //Student 엔티티에서 정보를 받아와 Dto로 변환
        return StudentInfoResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .build();
    }
}