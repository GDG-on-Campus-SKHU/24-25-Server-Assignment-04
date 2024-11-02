package com.example.courseregistration.controller;

import com.example.courseregistration.dto.StudentInfoResponseDto;
import com.example.courseregistration.dto.StudentSaveRequestDto;
import com.example.courseregistration.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentInfoResponseDto> save(@RequestBody StudentSaveRequestDto studentSaveRequestDto){
        return new ResponseEntity<>(studentService.save(studentSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> findByStudentId(@PathVariable Long studentId) {
        log.info("student read 요청 -{}", studentId);
        return new ResponseEntity<>(studentService.findByStudentId(studentId), HttpStatus.OK);
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> updateStudentId(@PathVariable Long studentId, @RequestBody StudentSaveRequestDto studentSaveRequestDto){
        return new ResponseEntity<>(studentService.updateByStudentId(studentId, studentSaveRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> deleteByStudentId(@PathVariable Long studentId){
        studentService.deleteByStudentId(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
