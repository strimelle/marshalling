package lt.viko.eif.imazolevska.marshalling.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void newStudentHasNoId() {
        Student student = new Student();
        assertEquals(0, student.getId());
    }

    @Test
    void setIdStoresId() {
        Student student = new Student();
        student.setId(112);
        assertEquals(112, student.getId());
    }

    @Test
    void setIdReplacesPreviousId() {
        Student student = new Student();
        student.setId(112);
        student.setId(111);
        assertEquals(111, student.getId());
    }

    @Test
    void newStudentHasNoFirstName() {
        Student student = new Student();
        assertNull(student.getFirstName());
    }

    @Test
    void setFirstNameStoresFirstName() {
        Student student = new Student();
        student.setFirstName("ieva");

        assertEquals("ieva", student.getFirstName());
    }

    @Test
    void setFirstNameReplacesPreviousFirstName() {
        Student student = new Student();
        student.setFirstName("ieva");
        student.setFirstName("pieva");
        assertEquals("pieva", student.getFirstName());
    }

    @Test
    void newStudentHasNoLastName() {
        Student student = new Student();
        assertNull(student.getLastName());
    }

    @Test
    void setLastNameStoresLastName() {
        Student student = new Student();
        student.setLastName("mazolevska");
        assertEquals("mazolevska", student.getLastName());
    }

    @Test
    void setLastNameReplacesPreviousLastName() {
        Student student = new Student();
        student.setLastName("mazolevska");
        student.setLastName("neMazolevska");
        assertEquals("neMazolevska", student.getLastName());
    }

    @Test
    void newStudentHasNoCourses() {
        Student student = new Student();
        assertNull(student.getCourses());
    }

    @Test
    void setCoursesStoresCourses() {
        Student student = new Student();
        Course math = new Course();
        math.setName("Math");
        Course physics = new Course();
        physics.setName("Physics");

        List<Course> courses = new ArrayList<>();
        courses.add(math);
        courses.add(physics);

        student.setCourses(courses);


        assertEquals(2, student.getCourses().size());
        assertEquals("Math", student.getCourses().get(0).getName());
        assertEquals("Physics", student.getCourses().get(1).getName());
    }

    @Test
    void newStudentHasNoStatus() {
        Student student = new Student();
        assertFalse(student.getStatus());
    }

    @Test
    void setStatusStoresStatus() {
        Student student = new Student();
        student.setStatus(true);
        assertTrue(student.getStatus());
    }

    @Test
    void newStudentHasNoGpa() {
        Student student = new Student();
        assertEquals(0.0f, student.getGpa());
    }

    @Test
    void setGpaStoresGpa() {
        Student student = new Student();
        student.setGpa(8.7f);
        assertEquals(8.7f, student.getGpa());
    }
}