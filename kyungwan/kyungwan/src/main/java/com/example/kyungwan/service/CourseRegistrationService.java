package com.example.kyungwan.service;

import com.example.kyungwan.domain.CourseRegistration;
import com.example.kyungwan.domain.Lecture;
import com.example.kyungwan.domain.Student;
import com.example.kyungwan.dto.CourseRegisteredLectureForStudentDto;
import com.example.kyungwan.dto.CourseRegisteredLecturesResponseDto;
import com.example.kyungwan.dto.CourseRegisteredStudentForLectureDto;
import com.example.kyungwan.dto.CourseRegisteredStudentsResponseDto;
import com.example.kyungwan.repository.CourseRegistrationRepository;
import com.example.kyungwan.repository.LectureRepository;
import com.example.kyungwan.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseRegistrationService {
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @Transactional
    public void CourseRegistration(Long studentId, Long lectureId) {
        if (CourseRegistrationRepository.existsById(studentId, lectureId)) {
            throw new IllegalArgumentException("이미 수강 신청한 강의입니다.");
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        CourseRegistration courseRegistration = CourseRegistration.of(student, lecture);
        CourseRegistrationRepository.save(courseRegistration);
    }

    @Transactional
    public CourseRegisteredStudentsResponseDto getStudentByLecture(Long lectureId) {
        List<CourseRegisteredStudentForLectureDto> students = courseRegistrationRepository.findByLectureId(lectureId).stream()
                .map(CourseRegistration::getStudent)
                .map(CourseRegisteredStudentForLectureDto::from)
                .collect(Collectors.toList());

        return new CourseRegisteredStudentsResponseDto(students);
    }

    @Transactional
    public CourseRegisteredLecturesResponseDto getLecturesByStudent(Long studentId) {
        List<CourseRegisteredLectureForStudentDto> lectures = courseRegistrationRepository.findByStudentId(studentId).stream()
                .map(CourseRegistration::getLecture)
                .map(CourseRegisteredLectureForStudentDto::from)
                .collect(Collectors.toList());

        return new CourseRegisteredLecturesResponseDto(lectures);
    }

    @Transactional
    public void resetCourseRegistration(Long studentId, Long lectureId) {
        if(!courseRegistrationRepository.existsById(studentId, lectureId)) {
            throw new IllegalArgumentException("수강 신청 내역이 없습니다.");
        }
        courseRegistrationRepository.deleteById(studentId, lectureId);
    }

}
