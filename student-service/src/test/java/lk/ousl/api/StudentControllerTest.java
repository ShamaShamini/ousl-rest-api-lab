
package lk.ousl.api;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentController controller;

    @Test
    void testGetStudents() {

        Student student1 = new Student(
                "Shamini", "Software Engineering");

        Student student2 = new Student(
                "Kamal", "Computer Science");

        when(repository.findAll())
                .thenReturn(List.of(student1, student2));

        List<StudentDTO> result = controller.getStudents();

        assertEquals(2, result.size());

        assertEquals("Shamini", result.get(0).getName());
        assertEquals("Software Engineering",
                result.get(0).getCourse());

        assertEquals("Kamal", result.get(1).getName());
        assertEquals("Computer Science",
                result.get(1).getCourse());

        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetStudentsWhenEmpty() {

        when(repository.findAll()).thenReturn(List.of());

        List<StudentDTO> result = controller.getStudents();

        assertTrue(result.isEmpty());

        verify(repository, times(1)).findAll();
    }

    @Test
    void testAddStudent() {

        StudentDTO dto = new StudentDTO(
                null, "Shamini", "Software Engineering");

        when(repository.save(any(Student.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        StudentDTO result = controller.addStudent(dto);

        assertEquals("Shamini", result.getName());
        assertEquals("Software Engineering", result.getCourse());

        verify(repository, times(1)).save(any(Student.class));
    }
}
