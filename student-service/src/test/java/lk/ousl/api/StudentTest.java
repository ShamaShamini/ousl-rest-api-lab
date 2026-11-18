
package lk.ousl.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testStudentConstructor() {
        Student student = new Student("Shamini", "Software Engineering");

        assertEquals("Shamini", student.getName());
        assertEquals("Software Engineering", student.getCourse());
    }

    @Test
    void testStudentSettersAndGetters() {
        Student student = new Student();

        student.setName("Kamal");
        student.setCourse("Computer Science");

        assertEquals("Kamal", student.getName());
        assertEquals("Computer Science", student.getCourse());
    }

    @Test
    void testDefaultConstructor() {
        Student student = new Student();

        assertNull(student.getId());
        assertNull(student.getName());
        assertNull(student.getCourse());
    }
}
