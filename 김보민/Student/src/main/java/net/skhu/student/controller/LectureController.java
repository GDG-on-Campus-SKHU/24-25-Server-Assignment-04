package net.skhu.student.controller;
import lombok.RequiredArgsConstructor;
import net.skhu.student.dto.request.LectureSaveRequestDto;
import net.skhu.student.dto.response.LectureInfoResponseDto;
import net.skhu.student.dto.response.LectureListResponseDto;
import net.skhu.student.service.LectureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {
    private final LectureService lectureService;

    @PostMapping
    public ResponseEntity<LectureInfoResponseDto> save(@RequestBody LectureSaveRequestDto lectureSaveRequestDto){
        return new ResponseEntity<>(lectureService.save(lectureSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LectureInfoResponseDto> findByLectureId(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(lectureService.findByLectureId(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LectureInfoResponseDto> updateByLectureId(@PathVariable(name="id") Long id,
                                                                    @RequestBody LectureSaveRequestDto lectureSaveRequestDto){
        return new ResponseEntity<>(lectureService.updateByLectureId(id, lectureSaveRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LectureInfoResponseDto> deleteByLectureId(@PathVariable(name="id") Long id){
        lectureService.deleteByLectureId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<LectureListResponseDto> findAllLectureId(){
        return new ResponseEntity<>(lectureService.findAllLectureId(), HttpStatus.OK);
    }
}
