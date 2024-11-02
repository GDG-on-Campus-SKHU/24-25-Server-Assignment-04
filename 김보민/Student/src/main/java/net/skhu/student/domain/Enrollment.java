package net.skhu.student.domain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
@Entity
@Getter
@NoArgsConstructor//기본생성자 생성
@Builder
public class Enrollment {//수강신청 정보

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Long date; //수강 신청 날짜

    @ManyToOne(fetch = FetchType.LAZY)//다대일 관계
    @JoinColumn(name = "student_id")// 두 엔티티 연결하는 외래키 컬럼 지정. 수강 학생
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)//다대일 관계
    @JoinColumn(name = "lecture_id") // 수강 강의
    private Lecture lecture;

    public Enrollment(Long id,String title, Long date, Student student, Lecture lecture) {
        this.id = id;
        this.title=title;
        this.date = date;
        this.student = student;
        this.lecture = lecture;
    }
}