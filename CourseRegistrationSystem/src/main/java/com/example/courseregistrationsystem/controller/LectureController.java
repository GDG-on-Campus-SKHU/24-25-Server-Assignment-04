package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.dto.LectureDto.LectureInfoResponseDto;
import com.example.courseregistrationsystem.dto.LectureDto.LectureListResponseDto;
import com.example.courseregistrationsystem.dto.LectureDto.LectureSaveRequestDto;
import com.example.courseregistrationsystem.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures")
public class LectureController {
    private final LectureService lectureService;

    @PostMapping
    public ResponseEntity<LectureInfoResponseDto> save(@RequestBody LectureSaveRequestDto lectureSaveRequestDto) {
        return new ResponseEntity<>(lectureService.save(lectureSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{lectureId}")
    public ResponseEntity<LectureInfoResponseDto> findByLectureId(@PathVariable(name = "lectureId") Long lectureId) {
        return new ResponseEntity<>(lectureService.findByLectureId(lectureId), HttpStatus.OK);
    }

    @PatchMapping("/{lectureId}")
    public ResponseEntity<LectureInfoResponseDto> updateByLectureId(@PathVariable(name = "lectureId") Long lectureId,
                                                                    @RequestBody LectureSaveRequestDto lectureSaveRequestDto) {
        return new ResponseEntity<>(lectureService.updateByLectureId(lectureId, lectureSaveRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{lectureId}")
    public ResponseEntity<Void> deleteByLectureId(@PathVariable(name = "lectureId") Long lectureId) {
        lectureService.deleteByLectureId(lectureId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<LectureListResponseDto> findAllLectures() {
        return new ResponseEntity<>(lectureService.findAllLectures(), HttpStatus.OK);
    }

}
