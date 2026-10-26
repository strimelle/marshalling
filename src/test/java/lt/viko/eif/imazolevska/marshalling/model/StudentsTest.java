package lt.viko.eif.imazolevska.marshalling.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {
    @Test
    void newStudentsHasEmptyList() {
        Students students = new Students();
        assertTrue(students.getStudents().isEmpty());
    }

    @Test
    void setStudentsStoresStudents() {
        Student lina = new Student();
        Student migle = new Student();
        lina.setId(222);
        lina.setFirstName("Lina");
        migle.setId(333);
        migle.setFirstName("Migle");

        List<Student> studentList = new ArrayList<>();

        studentList.add(lina);
        studentList.add(migle);

        Students group = new Students();
        group.setStudents(studentList);

        assertEquals(2, group.getStudents().size());
        assertEquals("Lina", group.getStudents().get(0).getFirstName());
        assertEquals("Migle", group.getStudents().get(1).getFirstName());
    }

}