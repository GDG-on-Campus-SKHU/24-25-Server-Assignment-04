package net.skhu.student.service;
import lombok.RequiredArgsConstructor;
import net.skhu.student.domain.Enrollment;
import net.skhu.student.domain.Lecture;
import net.skhu.student.domain.Student;
import net.skhu.student.dto.request.EnrollmentSaveRequestDto;
import net.skhu.student.dto.response.EnrollmentInfoResponseDto;
import net.skhu.student.dto.response.EnrollmentListResponseDto;
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
        Student student = studentRepository.findById(enrollmentSaveRequestDto.getStudentId())
                //save() EnrollmentSaveRequestDto와 student의 Id를 받아 Enrollment 엔티티를 생성하고 저장
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        Lecture lecture = lectureRepository.findById(enrollmentSaveRequestDto.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .lecture(lecture)
                .build();
        enrollmentRepository.save(enrollment);
        return EnrollmentInfoResponseDto.from(enrollment);
    }

    //student의 Id -> 수강신청 목록 조회
    @Transactional(readOnly = true) // 트랜잭션 읽기 전용
    public EnrollmentInfoResponseDto findByEnrollmentId(Long id){ //student id로 수강신청 조회
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 수강신청 목록입니다."));
        return EnrollmentInfoResponseDto.from(enrollment);
    }

    //수강신청 삭제 - 학생 id
    @Transactional
    public void deleteByEnrollmentId(Long id){
        enrollmentRepository.deleteById(id);
    }

    @Transactional( readOnly=true)
    public EnrollmentListResponseDto findAllEnrollmentId(){
        List<Enrollment> enrollmentList = enrollmentRepository.findAll();
        List<EnrollmentInfoResponseDto> enrollmentInfoResponseDTO = enrollmentList.stream()
                .map(EnrollmentInfoResponseDto::from)
                .toList();
        return EnrollmentListResponseDto.from(enrollmentInfoResponseDTO);
    }
}
