package org.example.gdgweek4assignmentktw.controller;

import lombok.RequiredArgsConstructor;
import org.example.gdgweek4assignmentktw.dto.student.request.StudentSaveRequestDto;
import org.example.gdgweek4assignmentktw.dto.student.response.StudentInfoResponseDto;
import org.example.gdgweek4assignmentktw.dto.student.response.StudentListResponseDto;
import org.example.gdgweek4assignmentktw.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    //학생 생성
    @PostMapping
    public ResponseEntity<StudentInfoResponseDto> saveStudent(@RequestBody StudentSaveRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.save(dto));
    }

    // studentId로 학생 조회
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> findByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.findByStudentId(studentId));
    }

    // 전체 학생 조회
    @GetMapping
    public ResponseEntity<StudentListResponseDto> findAllStudents() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.findAllStudents());
    }

    // studentId로 학생 정보 수정
    @PatchMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> updateByStudentId(@PathVariable Long studentId, @RequestBody StudentSaveRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.updateByStudentId(studentId, dto));
    }

    // studentId로 학생 삭제
    @DeleteMapping("{studentId}")
    public ResponseEntity<String> deleteByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.deleteByStudentId(studentId));
    }

}
