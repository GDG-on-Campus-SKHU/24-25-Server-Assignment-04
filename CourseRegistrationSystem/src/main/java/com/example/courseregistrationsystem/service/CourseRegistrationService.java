package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.domain.CourseRegistration;
import com.example.courseregistrationsystem.domain.Lecture;
import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.dto.CourseRegistrationDto.courseRegistrationDto.CourseRegistrationStudentsResponseDto;
import com.example.courseregistrationsystem.dto.CourseRegistrationDto.courseRegistrationDto.CourseRegistrationsLecturesResponseDto;
import com.example.courseregistrationsystem.dto.CourseRegistrationDto.courseRegistrationDto.CourseRegistrationsLectureListResponseDto;
import com.example.courseregistrationsystem.dto.CourseRegistrationDto.courseRegistrationDto.CourseRegistrationsStudentsListResponseDto;
import com.example.courseregistrationsystem.repository.CourseRegistrationRepository;
import com.example.courseregistrationsystem.repository.LectureRepository;
import com.example.courseregistrationsystem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseRegistrationService {
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @Transactional                  //중복 방지 메소드
    public void CourseRegistrationRepository(Long studentId, Long lectureId) {
        if(courseRegistrationRepository.existsByStudent_IdAndLecture_Id(studentId, lectureId)) {
            throw new IllegalArgumentException("It's already been registered");
        }
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("Lecture not found"));

        CourseRegistration courseRegistration = CourseRegistration.of(student, lecture);
        courseRegistrationRepository.save(courseRegistration);
    }

    @Transactional
    public CourseRegistrationsStudentsListResponseDto getStudentsByLectureId(Long lectureId) {
        List<CourseRegistrationStudentsResponseDto> students = courseRegistrationRepository.findByLectureId(lectureId).stream()
                .map(CourseRegistration::getStudent)
                .map(CourseRegistrationStudentsResponseDto::from)
                .collect(Collectors.toList());
        return new CourseRegistrationsStudentsListResponseDto(students);
    }

    @Transactional
    public CourseRegistrationsLectureListResponseDto getLecturesByStudent(Long studentId) {
        List<CourseRegistrationsLecturesResponseDto> lectures = courseRegistrationRepository.findByStudentId(studentId).stream()
                .map(CourseRegistration::getLecture)
                .map(CourseRegistrationsLecturesResponseDto::from)
                .collect(Collectors.toList());
        return new CourseRegistrationsLectureListResponseDto(lectures);
    }

    @Transactional
    public void cancelCourseRegistration(Long studentId, Long lectureId) {
        if (!courseRegistrationRepository.existsByStudent_IdAndLecture_Id(studentId, lectureId)) {
            throw new IllegalArgumentException("no registered");
        }
        courseRegistrationRepository.deleteByStudent_IdAndLecture_Id(studentId, lectureId);
    }
}
