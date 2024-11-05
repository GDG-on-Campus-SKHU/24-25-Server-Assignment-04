package net.skhu.student.service;
import lombok.RequiredArgsConstructor;
import net.skhu.student.domain.Student;
import net.skhu.student.dto.request.StudentSaveRequestDto;
import net.skhu.student.dto.response.StudentInfoResponseDto;
import net.skhu.student.dto.response.StudentListResponseDto;
import net.skhu.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service //Dao가 DB에서 받아온 데이터를 전달받아 가공하는것
@RequiredArgsConstructor
public class StudentService { //학생 관련 비즈니스 로직 관리
    private final StudentRepository studentRepository;

    @Transactional
    public StudentInfoResponseDto save(StudentSaveRequestDto studentSaveRequestDto){//들어온 요청에다가 저장. create
        Student student = studentSaveRequestDto.toEntity(); //Dto를 엔티티로 변환
        studentRepository.save(student);
        //save(): student를 통해 Student 엔티티 생성 저장. 그리고 StudentInfoResponseDto로 반환
        return StudentInfoResponseDto.from(student);
    }

    @Transactional(readOnly = true)
    public StudentInfoResponseDto findByStudentId(Long studentId) { //예외처리 - 찾아서 없는 것
        Student student = studentRepository.findById(studentId)// Id로 찾기
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public StudentInfoResponseDto updateByStudentId(Long studentId, StudentSaveRequestDto studentSaveRequestDto) {
        Student student = studentRepository.findById(studentId) //Id로 찾기
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        student.update(studentSaveRequestDto.getId(), studentSaveRequestDto.getName());
        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public void deleteByStudentId(Long studentId){
        studentRepository.deleteById(studentId);
    }

    @Transactional(readOnly=true) //읽기 전용. 찾을거나 수정할거 있을 때 사용하는거임.
    public StudentListResponseDto findAllStudentId(){
        List<Student> students = studentRepository.findAll();
        List<StudentInfoResponseDto> studentInfoResponseDTO = students.stream() //students라는 stream 생성 -> 리스트 요소 처리
                .map(StudentInfoResponseDto::from) //response 에 있는 from 정적 메소드 호출.
                //Student 객체를 StudentInfoREsponseDto 객체로 변환
                .toList(); //다시 List로 변환
        //최종적으로 List<StudentInfoResponseDto> 타입의 리스트 생성

        return StudentListResponseDto.from(studentInfoResponseDTO);
        //StudentList에 넣어주기.
    }
}