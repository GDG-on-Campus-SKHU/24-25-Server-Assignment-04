package net.skhu.student.service;
import lombok.RequiredArgsConstructor;
import net.skhu.student.domain.Enrollment;
import net.skhu.student.domain.Lecture;
import net.skhu.student.domain.Student;
import net.skhu.student.dto.request.EnrollmentSaveRequestDto;
import net.skhu.student.dto.request.LectureSaveRequestDto;
import net.skhu.student.dto.response.EnrollmentInfoResponseDto;
import net.skhu.student.dto.response.EnrollmentListResponseDto;
import net.skhu.student.dto.response.LectureInfoResponseDto;
import net.skhu.student.repository.EnrollmentRepository;
import net.skhu.student.repository.LectureRepository;
import net.skhu.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {//수강신청 관련 비즈니스 로직
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @Transactional
    public EnrollmentInfoResponseDto save(EnrollmentSaveRequestDto enrollmentSaveRequestDto){
        //save() EnrollmentSaveRequestDto와 studentId를 받아 Enrollment 엔티티를 생성하고 저장
        Student student = studentRepository.findById(enrollmentSaveRequestDto.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        Lecture lecture = lectureRepository.findById(enrollmentSaveRequestDto.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        Enrollment enrollment = Enrollment.builder()
                .title(enrollmentSaveRequestDto.getTitle())
                .date(enrollmentSaveRequestDto.getDate())
                .student(student)
                .lecture(lecture)
                .build();
        enrollmentRepository.save(enrollment);
        return EnrollmentInfoResponseDto.from(enrollment);
    }

    @Transactional( readOnly = true) // 트랜잭션 읽기 전용
    public EnrollmentInfoResponseDto findByEnrollmentId(Long enrollmentId){
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 수강신청입니다."));

        return EnrollmentInfoResponseDto.from(enrollment);
    }

    @Transactional
    public LectureInfoResponseDto updateByLectureId(Long lectureId, LectureSaveRequestDto lectureSaveRequestDto){
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 수강신청입니다."));
        lecture.update(lectureSaveRequestDto.getTitle(), lectureSaveRequestDto.getNumber());

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public void deleteByEnrollmentId(Long enrollmentId){
        enrollmentRepository.deleteById(enrollmentId);
    }

    @Transactional( readOnly=true)
    public EnrollmentListResponseDto findAllEnrollments(){
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        List<EnrollmentInfoResponseDto> enrollmentInfoResponseDTO = enrollments.stream()
                .map(EnrollmentInfoResponseDto::from)
                .toList();
        return EnrollmentListResponseDto.from(enrollmentInfoResponseDTO);
    }
}
