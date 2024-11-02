package com.example.courseregistration.repository;

import com.example.courseregistration.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
