package com.example.kyungwan.service;

import com.example.kyungwan.domain.Student;
import com.example.kyungwan.dto.StudentInfoResponseDto;
import com.example.kyungwan.dto.StudentListResponseDto;
import com.example.kyungwan.dto.StudentSaveRequestDto;
import com.example.kyungwan.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public StudentInfoResponseDto save(StudentSaveRequestDto studentSaveRequestDto) {
        Student student = studentSaveRequestDto.toEntity();
        studentRepository.save(student);

        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public StudentInfoResponseDto findByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 학생입니다."));

        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public StudentInfoResponseDto updateByStudentId(Long studentId, StudentSaveRequestDto studentSaveRequestDto) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 학생입니다."));

        student.update(studentSaveRequestDto.getName(), studentSaveRequestDto.getStudentNumber());
        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Transactional(readOnly = true)
    public StudentListResponseDto findAllLectures() {
        List<Student> students = studentRepository.findAll();

        List<StudentInfoResponseDto> studentInfoResponseDtoList = students.stream()
                .map(StudentInfoResponseDto::from)
                .toList();

        return StudentListResponseDto.from(studentInfoResponseDtoList);
    }


}
