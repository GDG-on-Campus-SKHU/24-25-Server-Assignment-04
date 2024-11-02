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

    @PostMapping("/student{studentNumber}/lecture/{lectureId)")
    public ResponseEntity<Void> LectureRegistration(@PathVariable Long studentNumber, @PathVariable Long lectureId) {
        courseRegistrationService.CourseRegistration(studentNumber, lectureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/student/{studentNumber}/lectures")
    public ResponseEntity<CourseRegisteredLecturesResponseDto> getLecturesByStudentNumber(@PathVariable Long studentNumber) {
        CourseRegisteredLecturesResponseDto lecturesResponse = courseRegistrationService.getLecturesByStudent(studentNumber);
        return  ResponseEntity.ok(lecturesResponse);
    }

    @GetMapping("/lecture/{lectureId}/students")
    public ResponseEntity<CourseRegisteredStudentsResponseDto> getStudentsByLectureId(@PathVariable Long lectureId) {
        CourseRegisteredStudentsResponseDto studentResponse = courseRegistrationService.getStudentByLecture(lectureId);
        return  ResponseEntity.ok(studentResponse);
    }

    @DeleteMapping("/student/{studentNumber}/lecture/{lectureId}")
    public ResponseEntity<Void> resetLectureRegistration(@PathVariable Long studentNumber, @PathVariable Long lectureId) {
        courseRegistrationService.resetCourseRegistration(studentNumber,lectureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
