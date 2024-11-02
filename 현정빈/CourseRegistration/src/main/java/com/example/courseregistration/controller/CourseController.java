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

    @PostMapping
    public ResponseEntity<CourseInfoResponseDto> save(@RequestBody CourseSaveRequestDto courseSaveRequestDto){
        return new ResponseEntity<>(courseService.save(courseSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> findByCourseId(@PathVariable Long courseId){
        return new ResponseEntity<>(courseService.findByCourseId(courseId), HttpStatus.OK);
    }

    @PatchMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> updateByCourseId(@PathVariable Long courseId, CourseSaveRequestDto courseSaveRequestDto){
        return new ResponseEntity<>(courseService.updateByCourseId(courseId, courseSaveRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> deleteByCourseId(@PathVariable Long courseId){
        courseService.deleteByCourseId(courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
