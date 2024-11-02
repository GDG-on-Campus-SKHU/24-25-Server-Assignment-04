package net.skhu.student.service;
import lombok.RequiredArgsConstructor;
import net.skhu.student.domain.Student;
import net.skhu.student.dto.request.StudentSaveRequestDto;
import net.skhu.student.dto.response.StudentInfoResponseDto;
import net.skhu.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Dao가 DB에서 받아온 데이터를 전달받아 가공하는것
@RequiredArgsConstructor
public class StudentService { //학생 관련 비즈니스 로직 관리
    private final StudentRepository studentRepository;

    @Transactional
    public StudentInfoResponseDto save(StudentSaveRequestDto studentSaveRequestDto){
        Student student = studentSaveRequestDto.toEntity(); //Dto를 엔티티로 변환
        studentRepository.save(student);
        //save(): Student를 통해 Student 엔티티 생성 저장. 그리고 StudentInfoResponseDto로 반환
        return StudentInfoResponseDto.from(student);
    }

    @Transactional(readOnly = true)
    public StudentInfoResponseDto findByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public StudentInfoResponseDto updateByStudentId(Long studentId, StudentSaveRequestDto studentSaveRequestDto) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        student.update(studentSaveRequestDto.getName(), studentSaveRequestDto.getNumber());
        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public void deleteByStudentId(Long studentId){
        studentRepository.deleteById(studentId);
    }
}