package com.example.courseregistration.service;

import com.example.courseregistration.domain.Course;
import com.example.courseregistration.domain.Student;
import com.example.courseregistration.dto.CourseInfoResponseDto;
import com.example.courseregistration.dto.CourseSaveRequestDto;
import com.example.courseregistration.dto.StudentInfoResponseDto;
import com.example.courseregistration.dto.StudentSaveRequestDto;
import com.example.courseregistration.repository.CourseRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional
    public CourseInfoResponseDto save(CourseSaveRequestDto courseSaveRequestDto){
        Course course = courseSaveRequestDto.toEntity();
        courseRepository.save(course);
        return CourseInfoResponseDto.from(course);
    }

    @Transactional(readOnly = true)
    public CourseInfoResponseDto findByCourseId(Long courseId){
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));
        return CourseInfoResponseDto.from(course);
    }

    @Transactional
    public CourseInfoResponseDto updateByCourseId(Long courseId, CourseSaveRequestDto courseSaveRequestDto){
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));
        course.update(courseSaveRequestDto.getName(), courseSaveRequestDto.getInstructor());
        return CourseInfoResponseDto.from(course);
    }

    @Transactional
    public void deleteByCourseId(Long courseId){
        courseRepository.deleteById(courseId);
    }
}
