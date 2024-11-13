package com.example.courseregistration.controller;

import com.example.courseregistration.dto.CourseInfoResponseDto;
import com.example.courseregistration.dto.CourseSaveRequestDto;
import com.example.courseregistration.dto.StudentInfoResponseDto;
import com.example.courseregistration.dto.StudentSaveRequestDto;
import com.example.courseregistration.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    // 강의 정보를 저장하기 위한 post
    @PostMapping
    public ResponseEntity<CourseInfoResponseDto> save(@RequestBody CourseSaveRequestDto courseSaveRequestDto){
        return new ResponseEntity<>(courseService.save(courseSaveRequestDto), HttpStatus.CREATED);
    }

    // 특정 강의 정보를 조회하기 위한 get
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> findByCourseId(@PathVariable Long courseId){
        return new ResponseEntity<>(courseService.findByCourseId(courseId), HttpStatus.OK);
    }

    // 특정 강의 정보를 수정하기 위한 patch
    @PatchMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> updateByCourseId(@PathVariable Long courseId, @RequestBody CourseSaveRequestDto courseSaveRequestDto){
        return new ResponseEntity<>(courseService.updateByCourseId(courseId, courseSaveRequestDto), HttpStatus.OK);
    }

    // 특정 강의 정보를 삭제하기 위한 delete
    @DeleteMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> deleteByCourseId(@PathVariable Long courseId){
        courseService.deleteByCourseId(courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
