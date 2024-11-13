package com.example.courseregistration.repository;

import com.example.courseregistration.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
