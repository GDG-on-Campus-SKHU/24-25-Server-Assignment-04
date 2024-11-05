package net.skhu.student.domain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

//중간 테이블
@Entity
@Getter
@NoArgsConstructor//기본생성자 생성
public class Enrollment {//수강신청 정보

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)//다대일 관계
    @JoinColumn(name = "student_id")// 두 엔티티 연결하는 외래키 컬럼 지정. 수강 학생
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)//다대일 관계
    @JoinColumn(name = "lecture_id") // 수강 강의
    private Lecture lecture;

    @Builder
    public Enrollment(Long id, Student student, Lecture lecture){
        this.id=id;
        this.student=student;
        this.lecture=lecture;
    }
}