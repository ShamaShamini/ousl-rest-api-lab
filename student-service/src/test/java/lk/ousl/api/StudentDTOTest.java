package lk.ousl.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDTOTest {

    @Test
    void testDefaultConstructor() {
        StudentDTO dto = new StudentDTO();

        assertNull(dto.getId());
        assertNull(dto.getName());
        assertNull(dto.getCourse());
    }

    @Test
    void testParameterizedConstructor() {
        StudentDTO dto = new StudentDTO(
                1L,
                "Shamini",
                "Software Engineering"
        );

        assertEquals(1L, dto.getId());
        assertEquals("Shamini", dto.getName());
        assertEquals("Software Engineering", dto.getCourse());
    }

    @Test
    void testSettersAndGetters() {
        StudentDTO dto = new StudentDTO();

        dto.setId(2L);
        dto.setName("Kamal");
        dto.setCourse("Computer Science");

        assertEquals(2L, dto.getId());
        assertEquals("Kamal", dto.getName());
        assertEquals("Computer Science", dto.getCourse());
    }
}
