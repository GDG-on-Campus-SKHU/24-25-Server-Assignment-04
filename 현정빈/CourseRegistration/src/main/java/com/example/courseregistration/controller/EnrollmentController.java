package com.example.courseregistration.controller;

import com.example.courseregistration.domain.Enrollment;
import com.example.courseregistration.dto.EnrollmentInfoResponseDto;
import com.example.courseregistration.dto.EnrollmentListResponseDto;
import com.example.courseregistration.dto.EnrollmentSaveRequestDto;
import com.example.courseregistration.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentInfoResponseDto> enrollstudent(@RequestBody EnrollmentSaveRequestDto enrollmentSaveRequestDto){
        return new ResponseEntity<>(enrollmentService.enrollstudent(enrollmentSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{enrollmentId}")
    public ResponseEntity<EnrollmentInfoResponseDto> findByEnrollmentId(@PathVariable Long enrollmentId){
        return new ResponseEntity<>(enrollmentService.findByEnrollmentId(enrollmentId), HttpStatus.OK);
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<EnrollmentInfoResponseDto> deleteByEnrollmentId(@PathVariable Long enrollmentId){
        enrollmentService.deleteEnrollment(enrollmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<EnrollmentListResponseDto> findAllenroll() {
        return new ResponseEntity<>(enrollmentService.findAllenroll(), HttpStatus.OK);
    }
}
