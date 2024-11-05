package net.skhu.student.service;
import lombok.RequiredArgsConstructor;
import net.skhu.student.domain.Lecture;
import net.skhu.student.dto.request.LectureSaveRequestDto;
import net.skhu.student.dto.response.LectureInfoResponseDto;
import net.skhu.student.dto.response.LectureListResponseDto;
import net.skhu.student.repository.LectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    @Transactional//c
    public LectureInfoResponseDto save(LectureSaveRequestDto lectureSaveRequestDto){
        Lecture lecture = lectureSaveRequestDto.toEntity();
        lectureRepository.save(lecture);

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional(readOnly = true)//R
    public LectureInfoResponseDto findByLectureId(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));
        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional//수정
    public LectureInfoResponseDto updateByLectureId(Long lectureId, LectureSaveRequestDto lectureSaveRequestDto){
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        lecture.update(lectureSaveRequestDto.getTitle(), lectureSaveRequestDto.getNumber());
        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional//D
    public void deleteByLectureId(Long lectureId){
        lectureRepository.deleteById(lectureId);
    }

    @Transactional(readOnly = true)
    public LectureListResponseDto findAllLectureId(){
        List<Lecture> lecture = lectureRepository.findAll();
        List<LectureInfoResponseDto> lectureInfoResponseDTO = lecture.stream()
                .map(LectureInfoResponseDto::from)
                .toList();
        return LectureListResponseDto.from(lectureInfoResponseDTO);
    }
}