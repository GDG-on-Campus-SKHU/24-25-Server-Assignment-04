package net.skhu.student.controller;

import lombok.RequiredArgsConstructor;
import net.skhu.student.dto.request.StudentSaveRequestDto;
import net.skhu.student.dto.response.StudentInfoResponseDto;
import net.skhu.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentInfoResponseDto> save(@RequestBody StudentSaveRequestDto studentSaveRequestDto){
        return new ResponseEntity<>(studentService.save(studentSaveRequestDto), HttpStatus.CREATED);
    }
}
