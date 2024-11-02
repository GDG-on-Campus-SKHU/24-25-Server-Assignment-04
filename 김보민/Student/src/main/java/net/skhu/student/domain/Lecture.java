package net.skhu.student.domain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Id;
@Entity
@Getter
@NoArgsConstructor
public class Lecture {//강의 정보
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title; //강의 제목
    private Long number; //강의실 번호
    @OneToMany(mappedBy="lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    @Builder
    public Lecture(Long id, String title, Long number, List<Enrollment> enrollments){
        this.id=id;
        this.title=title;
        this.number=number;
        this.enrollments = enrollments;
    }

    public void update(String title, Long number){ //수정 필요하면 고치기
        this.title=title;
        this.number=number;
    }
}