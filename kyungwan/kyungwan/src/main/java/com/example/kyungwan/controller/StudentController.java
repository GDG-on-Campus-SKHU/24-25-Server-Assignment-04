package com.example.kyungwan.controller;

import com.example.kyungwan.dto.StudentInfoResponseDto;
import com.example.kyungwan.dto.StudentListResponseDto;
import com.example.kyungwan.dto.StudentSaveRequestDto;
import com.example.kyungwan.service.StudentService;
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

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> getByStudentId(@PathVariable(name = "studentId") Long studentId) {
        return new ResponseEntity<>(studentService.findByStudentId(studentId), HttpStatus.OK);
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> updateByStudentId(@PathVariable(name = "studentId") Long studentId,
                                                                    @RequestBody StudentSaveRequestDto studentSaveRequestDto) {
        return new ResponseEntity<>(studentService.updateByStudentId(studentId, studentSaveRequestDto), HttpStatus.OK);
    }


    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteByStudentId(@PathVariable(name = "studentId") Long studentId) {
        studentService.deleteById(studentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<StudentListResponseDto> findAllStudents() {
        return new ResponseEntity<>(studentService.findAllLectures(), HttpStatus.OK);
    }
}

