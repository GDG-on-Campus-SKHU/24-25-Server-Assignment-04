package com.example.courseregistrationsystem.repository;
import java.util.List;
import com.example.courseregistrationsystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
