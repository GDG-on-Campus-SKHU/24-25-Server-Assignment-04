package net.skhu.student.dto.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.skhu.student.domain.Lecture;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LectureSaveRequestDto {
    private String title;
    private Long number;

    public Lecture toEntity(){ //dto를 lecture 엔티티로 변환
        return Lecture.builder()
                .title(title)
                .number(number)
                .build();
    }
}
