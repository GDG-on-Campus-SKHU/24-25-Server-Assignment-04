package net.skhu.student.controller;
import lombok.RequiredArgsConstructor;
import net.skhu.student.dto.request.StudentSaveRequestDto;
import net.skhu.student.dto.response.StudentInfoResponseDto;
import net.skhu.student.dto.response.StudentListResponseDto;
import net.skhu.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    //ResponseEntity: HTTP 해더, 상태코드, 응답 본문 설정.

    @PostMapping
    public ResponseEntity<StudentInfoResponseDto> save(@RequestBody StudentSaveRequestDto studentSaveRequestDto){
        return new ResponseEntity<>(studentService.save(studentSaveRequestDto), HttpStatus.CREATED); //응답 본문, 상태
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentInfoResponseDto> findByStudentId(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(studentService.findByStudentId(id), HttpStatus.OK); //응답 본문
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentInfoResponseDto> updateByStudentId(@PathVariable(name="id") Long id,
                                                                    @RequestBody StudentSaveRequestDto studentSaveRequestDto){
        return new ResponseEntity<>(studentService.updateByStudentId(id, studentSaveRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentInfoResponseDto> deleteByStudentId(@PathVariable(name="id") Long id){
        studentService.deleteByStudentId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<StudentListResponseDto> findAllStudentId(){
        return new ResponseEntity<>(studentService.findAllStudentId(), HttpStatus.OK);
    }
}
