package net.skhu.student.dto.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.skhu.student.domain.Student;

//데이터를 생성할 때 필요한 요청 정보
//request 사용자에게 받을 값들
@Getter
@NoArgsConstructor
@AllArgsConstructor //this
public class StudentSaveRequestDto {
    private Long id;
    private String name;

    public Student toEntity(){//dto를 Student 엔티티로 변환하여 DB에 저장
        return Student.builder()
                .id(id)
                .name(name)
                .build();
    }
}