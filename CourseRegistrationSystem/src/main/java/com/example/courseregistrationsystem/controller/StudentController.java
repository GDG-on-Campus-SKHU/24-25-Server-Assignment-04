package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.dto.studentDto.StudentInfoResponseDto;
import com.example.courseregistrationsystem.dto.studentDto.StudentListResponseDto;
import com.example.courseregistrationsystem.dto.studentDto.StudentSaveRequestDto;
import com.example.courseregistrationsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentInfoResponseDto> save(@RequestBody StudentSaveRequestDto studentSaveRequestDto) {
        return new ResponseEntity<>(studentService.save(studentSaveRequestDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> updateByStudentId(@PathVariable(name = "studentId") Long studentId, @RequestBody StudentSaveRequestDto studentSaveRequestDto) {
        return new ResponseEntity<>(studentService.updateByStudentId(studentId, studentSaveRequestDto), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> getByStudentId(@PathVariable(name = "studentId") Long studentId) {
        return new ResponseEntity<>(studentService.getStudentByStudentId(studentId), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteByStudentId(@PathVariable(name = "studentId") Long studentId) {
        studentService.deleteByStudentId(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<StudentListResponseDto> findAllStudents() {
        return new ResponseEntity<>(studentService.findAllLectures(), HttpStatus.OK);
    }

}
