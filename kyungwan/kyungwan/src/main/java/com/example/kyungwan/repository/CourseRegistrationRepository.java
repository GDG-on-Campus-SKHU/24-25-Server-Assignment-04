package com.example.kyungwan.repository;

import com.example.kyungwan.domain.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
    boolean existsById(Long studentId, Long lectureId);
    void deleteById(Long studentId, Long lectureId);
    List<CourseRegistration> findByStudentId(Long studentId);
    List<CourseRegistration> findByLectureId(Long lectureId);
}
