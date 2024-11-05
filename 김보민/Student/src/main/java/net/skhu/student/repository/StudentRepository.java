package net.skhu.student.repository;
import net.skhu.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //기본 인터페이스. JPA 사용하여 엔티티 처리하는데 필요한 메소드 제공
}
