package com.example.kyungwan.service;

import com.example.kyungwan.domain.Lecture;
import com.example.kyungwan.dto.LectureInfoResponseDto;
import com.example.kyungwan.dto.LectureListResponseDto;
import com.example.kyungwan.dto.LectureSaveRequestDto;
import com.example.kyungwan.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    @Transactional
    public LectureInfoResponseDto save(LectureSaveRequestDto lectureSaveRequestDto) {
        Lecture lecture = Lecture.builder()
                .title(lectureSaveRequestDto.getTitle())
                .professor(lectureSaveRequestDto.getProfessor())
                .slot(lectureSaveRequestDto.getSlot())
                .location(lectureSaveRequestDto.getLocation())
                .build();
        lectureRepository.save(lecture);

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional(readOnly = true)
    public LectureInfoResponseDto findByLectureId(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 강의입니다."));

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public LectureInfoResponseDto updateByLectureId(Long lectureID, LectureSaveRequestDto lectureSaveRequestDto) {
        Lecture lecture = lectureRepository.findById(lectureID)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 강의입니다."));

        lecture.update(lectureSaveRequestDto.getTitle(),lectureSaveRequestDto.getProfessor(),
                lectureSaveRequestDto.getSlot(),lectureSaveRequestDto.getLocation());

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public void deleteByLectureId(Long lectureId) {
        lectureRepository.deleteById(lectureId);
    }

    @Transactional(readOnly = true)
    public LectureListResponseDto findAllLectures(){
        List<Lecture> lectures = lectureRepository.findAll();

        List<LectureInfoResponseDto> lectureInfoResponseDtoList = lectures.stream()
                .map(LectureInfoResponseDto::from)
                .toList();

        return LectureListResponseDto.from(lectureInfoResponseDtoList);
    }
}
