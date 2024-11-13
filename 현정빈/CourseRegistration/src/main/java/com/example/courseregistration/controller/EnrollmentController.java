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

    // 수강신청 정보를 저장하기 위한 post
    @PostMapping
    public ResponseEntity<EnrollmentInfoResponseDto> enrollStudent(@RequestBody EnrollmentSaveRequestDto enrollmentSaveRequestDto){
        return new ResponseEntity<>(enrollmentService.enrollStudent(enrollmentSaveRequestDto), HttpStatus.CREATED);
    }

    // 특정 수강신청 정보를 조회하기 위한 get
    @GetMapping("/{enrollmentId}")
    public ResponseEntity<EnrollmentInfoResponseDto> findByEnrollmentId(@PathVariable Long enrollmentId){
        return new ResponseEntity<>(enrollmentService.findByEnrollmentId(enrollmentId), HttpStatus.OK);
    }

    // 특정 수강신청 정보를 삭제하기 위한 delete
    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<EnrollmentInfoResponseDto> deleteByEnrollmentId(@PathVariable Long enrollmentId){
        enrollmentService.deleteEnrollment(enrollmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 수강신청 전체 목록을 조회하기 위한 get
    @GetMapping
    public ResponseEntity<EnrollmentListResponseDto> findAllEnrollments() {
        return new ResponseEntity<>(enrollmentService.findAllEnrollments(), HttpStatus.OK);
    }
}
