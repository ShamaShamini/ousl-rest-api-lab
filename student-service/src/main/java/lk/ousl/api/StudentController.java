
package lk.ousl.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<StudentDTO> getStudents() {
        return repository.findAll()
                .stream()
                .map(student -> new StudentDTO(
                        student.getId(),
                        student.getName(),
                        student.getCourse()))
                .toList();
    }

    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setCourse(dto.getCourse());

        Student savedStudent = repository.save(student);

        return new StudentDTO(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getCourse());
    }
}
