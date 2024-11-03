package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.domain.Lecture;
import com.example.courseregistrationsystem.domain.Student;
import com.example.courseregistrationsystem.dto.LectureDto.LectureInfoResponseDto;
import com.example.courseregistrationsystem.dto.LectureDto.LectureListResponseDto;
import com.example.courseregistrationsystem.dto.LectureDto.LectureSaveRequestDto;
import com.example.courseregistrationsystem.dto.studentDto.StudentInfoResponseDto;
import com.example.courseregistrationsystem.dto.studentDto.StudentSaveRequestDto;
import com.example.courseregistrationsystem.repository.LectureRepository;
import com.example.courseregistrationsystem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    @Transactional
    public LectureInfoResponseDto save(LectureSaveRequestDto lectureSaveRequestDto) {
        Lecture lecture = Lecture.builder()
                .lectureName(lectureSaveRequestDto.getLectureName())
                .professorName(lectureSaveRequestDto.getProfessorName())
                .credit(lectureSaveRequestDto.getCredit())
                .build();
        lectureRepository.save(lecture);

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public LectureInfoResponseDto findByLectureId(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public LectureInfoResponseDto updateByLectureId(Long lectureId, LectureSaveRequestDto lectureSaveRequestDto) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        lecture.update(lectureSaveRequestDto.getLectureName(), lectureSaveRequestDto.getProfessorName(),lectureSaveRequestDto.getCredit() );
        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public void deleteByLectureId(Long lectureId) {
        lectureRepository.deleteById(lectureId);
    }

    @Transactional
    public LectureListResponseDto findAllLectures() {
        List<Lecture> lectureList = lectureRepository.findAll();

        List<LectureInfoResponseDto> lectureInfoResponseDtos = lectureList.stream()
                .map(LectureInfoResponseDto::from)
                .toList();

        return LectureListResponseDto.from(lectureInfoResponseDtos);
    }
}
