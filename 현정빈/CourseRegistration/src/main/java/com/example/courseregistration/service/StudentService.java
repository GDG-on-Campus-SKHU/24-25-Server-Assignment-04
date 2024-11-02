package com.example.courseregistration.service;

import com.example.courseregistration.domain.Student;
import com.example.courseregistration.dto.StudentInfoResponseDto;
import com.example.courseregistration.dto.StudentSaveRequestDto;
import com.example.courseregistration.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    //학생 정보 추가
    @Transactional 
    public StudentInfoResponseDto save(StudentSaveRequestDto studentSaveRequestDto){
        Student student = studentSaveRequestDto.toEntity();
        studentRepository.save(student);
        return StudentInfoResponseDto.from(student);
    }

    //학생 정보 조회
    @Transactional(readOnly = true)
    public StudentInfoResponseDto findByStudentId(Long studentId) {
        log.info("student read 요청 -{}", studentId);
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        log.info("학생 확인 -{}", student );
        return StudentInfoResponseDto.from(student);
    }

    //학생 정보 수정
    @Transactional
    public StudentInfoResponseDto updateByStudentId(Long studentId, StudentSaveRequestDto studentSaveRequestDto){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        student.update(studentSaveRequestDto.getName());
        return StudentInfoResponseDto.from(student);
    }

    //학생 정보 삭제
    @Transactional
    public void deleteByStudentId(Long studentId){
        studentRepository.deleteById(studentId);
    }
}
