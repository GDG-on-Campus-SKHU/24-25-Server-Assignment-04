package com.example.courseregistration.service;

import com.example.courseregistration.domain.Course;
import com.example.courseregistration.domain.Enrollment;
import com.example.courseregistration.domain.Student;
import com.example.courseregistration.dto.CourseInfoResponseDto;
import com.example.courseregistration.dto.EnrollmentInfoResponseDto;
import com.example.courseregistration.dto.EnrollmentListResponseDto;
import com.example.courseregistration.dto.EnrollmentSaveRequestDto;
import com.example.courseregistration.repository.CourseRepository;
import com.example.courseregistration.repository.EnrollmentRepository;
import com.example.courseregistration.repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    //수강신청 생성
    @Transactional
    public EnrollmentInfoResponseDto enrollStudent(EnrollmentSaveRequestDto enrollmentSaveRequestDto){
        Student student = studentRepository.findById(enrollmentSaveRequestDto.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        Course course = courseRepository.findById(enrollmentSaveRequestDto.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        Enrollment enrollment = new Enrollment(student, course);
        enrollmentRepository.save(enrollment);
        return EnrollmentInfoResponseDto.from(enrollment);
    }

    //수강신청 조회
    @Transactional(readOnly = true)
    public EnrollmentInfoResponseDto findByEnrollmentId(Long enrollmentId){
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 수강신청입니다."));
        return EnrollmentInfoResponseDto.from(enrollment);
    }

    //수강신청 삭제
    @Transactional
    public void deleteEnrollment(Long enrollmentId){
        enrollmentRepository.deleteById(enrollmentId);
    }

    //전체수강신청 조회
    @Transactional(readOnly = true)
    public EnrollmentListResponseDto findAllEnrollments() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();

        List<EnrollmentInfoResponseDto> enrollmentInfoResponseDto = enrollments.stream()
                .map(EnrollmentInfoResponseDto::from)
                .toList();

        return EnrollmentListResponseDto.from(enrollmentInfoResponseDto);
    }
}
