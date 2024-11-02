package net.skhu.student.service;
import lombok.RequiredArgsConstructor;
import net.skhu.student.domain.Lecture;
import net.skhu.student.dto.request.LectureSaveRequestDto;
import net.skhu.student.dto.response.LectureInfoResponseDto;
import net.skhu.student.repository.LectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    @Transactional
    public LectureInfoResponseDto save(LectureSaveRequestDto lectureSaveRequestDto){
        Lecture lecture = lectureSaveRequestDto.toEntity();
        lectureRepository.save(lecture);

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional(readOnly = true)
    public LectureInfoResponseDto findByLectureId(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));
        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public LectureInfoResponseDto updateByLectureId(Long lectureId, LectureSaveRequestDto lectureSaveRequestDto){
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        lecture.update(lectureSaveRequestDto.getTitle(), lectureSaveRequestDto.getNumber());
        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public void deleteByLectureId(Long lectureId){
        lectureRepository.deleteById(lectureId);
    }

}