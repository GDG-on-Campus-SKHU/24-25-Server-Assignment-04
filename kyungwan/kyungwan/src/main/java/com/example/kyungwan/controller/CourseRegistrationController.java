package com.example.kyungwan.controller;

import com.example.kyungwan.dto.CourseRegisteredLecturesResponseDto;
import com.example.kyungwan.dto.CourseRegisteredStudentsResponseDto;
import com.example.kyungwan.service.CourseRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courseRegistration")
public class CourseRegistrationController {
    private final CourseRegistrationService courseRegistrationService;

    @PostMapping("/student/{studentId}/lecture/{lectureId}")
    public ResponseEntity<Void> CourseRegistration(@PathVariable Long studentId, @PathVariable Long lectureId) {
        courseRegistrationService.CourseRegistration(studentId, lectureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}/lectures")
    public ResponseEntity<CourseRegisteredLecturesResponseDto> getLecturesByStudentNumber(@PathVariable Long studentId) {
        CourseRegisteredLecturesResponseDto lecturesResponse = courseRegistrationService.getLecturesByStudent(studentId);
        return  ResponseEntity.ok(lecturesResponse);
    }

    @GetMapping("/lecture/{lectureId}/students")
    public ResponseEntity<CourseRegisteredStudentsResponseDto> getStudentsByLectureId(@PathVariable Long lectureId) {
        CourseRegisteredStudentsResponseDto studentResponse = courseRegistrationService.getStudentByLecture(lectureId);
        return  ResponseEntity.ok(studentResponse);
    }

    @DeleteMapping("/student/{studentId}/lecture/{lectureId}")
    public ResponseEntity<Void> resetLectureRegistration(@PathVariable Long studentId, @PathVariable Long lectureId) {
        courseRegistrationService.resetCourseRegistration(studentId,lectureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
