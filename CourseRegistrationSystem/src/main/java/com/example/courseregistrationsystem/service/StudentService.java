package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.dto.studentDto.StudentInfoResponseDto;
import com.example.courseregistrationsystem.dto.studentDto.StudentListResponseDto;
import com.example.courseregistrationsystem.dto.studentDto.StudentSaveRequestDto;
import com.example.courseregistrationsystem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    public StudentInfoResponseDto updateByStudentId(Long studentId, StudentSaveRequestDto studentSaveRequestDto) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        student.update(studentSaveRequestDto.getStudentNumber(), studentSaveRequestDto.getName());

        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public StudentInfoResponseDto getStudentByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public void deleteByStudentId(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public StudentListResponseDto findAllLectures(){
        List<Student> students = studentRepository.findAll();

        List<StudentInfoResponseDto> studentInfoResponseDtos = students.stream()
                .map(StudentInfoResponseDto::from)
                .toList();

        return StudentListResponseDto.from(studentInfoResponseDtos);
    }
}
