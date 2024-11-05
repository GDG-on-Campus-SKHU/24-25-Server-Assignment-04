package net.skhu.student.domain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Id;

@Entity//데이터베이스 테이블과 매핑
@Getter
@NoArgsConstructor//기본 생성자 생성
public class Student {//학생 정보
    @Id //기본키
    private Long id; //학생 학번
    private String name;//학생 이름

    //학생과 강의는 일대다 관계
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
    //DB에서 엔티티 가져오고 /부모 엔티티에 대해 수행된 작업 저장, 삭제 등 하고 / 부모 엔티티와의 관계가 끊어진 자식 엔티티 자동 삭제
    private List<Enrollment> enrollmentList = new ArrayList<>(); //enrollmentList에 저장

    @Builder
    public Student(Long id, String name){
        this.id=id;
        this.name = name;
    }

    public void update(Long id, String name){ //수정 필요하면 고치기
        this.id=id;
        this.name=name;
    }
}