package net.skhu.student.repository;
import net.skhu.student.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
//실제 DB 저장
//저장하는 동작. DB에 직접 넣는 동작 직접