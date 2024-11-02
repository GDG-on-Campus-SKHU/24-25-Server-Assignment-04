package net.skhu.student.controller;

import lombok.RequiredArgsConstructor;
import net.skhu.student.dto.request.EnrollmentSaveRequestDto;
import net.skhu.student.dto.request.LectureSaveRequestDto;
import net.skhu.student.dto.response.EnrollmentInfoResponseDto;
import net.skhu.student.dto.response.EnrollmentListResponseDto;
import net.skhu.student.dto.response.LectureInfoResponseDto;
import net.skhu.student.service.EnrollmentService;
import net.skhu.student.service.LectureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    private final LectureService lectureService;

    @PostMapping
    public ResponseEntity<EnrollmentInfoResponseDto> save(@RequestBody EnrollmentSaveRequestDto enrollmentSaveRequestDto){
        return new ResponseEntity<>(enrollmentService.save(enrollmentSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{enrollmentId}")
    public ResponseEntity<EnrollmentInfoResponseDto> findByEnrollmentId(@PathVariable(name="enrollmentId") Long enrollmentId){
        return new ResponseEntity<>(enrollmentService.findByEnrollmentId(enrollmentId), HttpStatus.OK);
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<EnrollmentInfoResponseDto> deleteByEnrollmentId(@PathVariable(name="enrollmentId") Long enrollmentId){
        enrollmentService.deleteByEnrollmentId(enrollmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<EnrollmentListResponseDto> findAllEnrollments(){
        return new ResponseEntity<>(enrollmentService.findAllEnrollments(), HttpStatus.OK);
    }
}
