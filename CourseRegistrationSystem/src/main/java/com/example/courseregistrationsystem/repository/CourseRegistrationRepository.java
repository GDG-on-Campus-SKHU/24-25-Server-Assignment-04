package com.example.courseregistrationsystem.repository;


import com.example.courseregistrationsystem.domain.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
    boolean existsByStudent_IdAndLecture_Id(Long studentId, Long lectureId);
    void deleteByStudent_IdAndLecture_Id(Long studentId, Long lectureId);
    List<CourseRegistration> findByLectureId(Long lectureId);
    List<CourseRegistration> findByStudentId(Long studentId);
}
