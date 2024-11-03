package com.example.courseregistrationsystem.controller;


import com.example.courseregistrationsystem.dto.CourseRegistrationDto.courseRegistrationDto.CourseRegistrationsLectureListResponseDto;
import com.example.courseregistrationsystem.dto.CourseRegistrationDto.courseRegistrationDto.CourseRegistrationsStudentsListResponseDto;
import com.example.courseregistrationsystem.service.CourseRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courseRegistrations")
public class CourseRegistrationController {
    private final CourseRegistrationService courseRegistrationService;

    @PostMapping("/students/{studentId}/lectures/{lectureId}")
    public ResponseEntity<Void> CourseRegistration(@PathVariable("studentId") Long studentId,@PathVariable Long lectureId) {
        courseRegistrationService.CourseRegistrationRepository(studentId, lectureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/students/{studentId}/lectures")
    public ResponseEntity<CourseRegistrationsLectureListResponseDto> getLecturesByStudentId(@PathVariable Long studentId) {
        CourseRegistrationsLectureListResponseDto lectureResponse = courseRegistrationService.getLecturesByStudent(studentId);
        return ResponseEntity.ok(lectureResponse);
    }

    @GetMapping("/lectures/{lectureId}/students")
    public ResponseEntity<CourseRegistrationsStudentsListResponseDto> getStudentsByLectureId(@PathVariable Long lectureId) {
        CourseRegistrationsStudentsListResponseDto studentsResponse = courseRegistrationService.getStudentsByLectureId(lectureId);
        return ResponseEntity.ok(studentsResponse);
    }

    @DeleteMapping("/students/{studentId}/lectures/{lectureId}")
    public ResponseEntity<Void> cancelLectureRegistration(@PathVariable Long studentId, @PathVariable Long lectureId) {
        courseRegistrationService.cancelCourseRegistration(studentId, lectureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

