package net.skhu.student.controller;
import lombok.RequiredArgsConstructor;
import net.skhu.student.dto.request.EnrollmentSaveRequestDto;
import net.skhu.student.dto.response.EnrollmentInfoResponseDto;
import net.skhu.student.dto.response.EnrollmentListResponseDto;
import net.skhu.student.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    @PostMapping //수강신청 정보 -C
    public ResponseEntity<EnrollmentInfoResponseDto> save(@RequestBody EnrollmentSaveRequestDto enrollmentSaveRequestDto){
        return new ResponseEntity<>(enrollmentService.save(enrollmentSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}") //수강신청 저장 - R, id는 enrollmentId
    public ResponseEntity<EnrollmentInfoResponseDto> findByEnrollmentId(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(enrollmentService.findByEnrollmentId(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}") //수강신청 삭제 -D, id는 enrollmentId
    public ResponseEntity<EnrollmentInfoResponseDto> deleteByEnrollmentId(@PathVariable(name="id") Long id){
        enrollmentService.deleteByEnrollmentId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<EnrollmentListResponseDto> findAllEnrollmentId(){
        return new ResponseEntity<>(enrollmentService.findAllEnrollmentId(), HttpStatus.OK);
    }
}
