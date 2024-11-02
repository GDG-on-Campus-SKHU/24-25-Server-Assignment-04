package net.skhu.student.controller;
import lombok.RequiredArgsConstructor;
import net.skhu.student.dto.request.StudentSaveRequestDto;
import net.skhu.student.dto.response.StudentInfoResponseDto;
import net.skhu.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentInfoResponseDto> save(@RequestBody StudentSaveRequestDto studentSaveRequestDto){
        return new ResponseEntity<>(studentService.save(studentSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> findByStudentId(@PathVariable(name="studentId") Long studentId){
        return new ResponseEntity<>(studentService.findByStudentId(studentId), HttpStatus.OK);
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> updateByStudentId(@PathVariable(name="studentId") Long studentId,
                                                                    @RequestBody StudentSaveRequestDto studentSaveRequestDto){
        return new ResponseEntity<>(studentService.updateByStudentId(studentId, studentSaveRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> deleteByStudentId(@PathVariable(name="studentId") Long studentId){
        studentService.deleteByStudentId(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
