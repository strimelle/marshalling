package lt.viko.eif.imazolevska.marshalling.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    @Test
    void newCourseHasNoName(){
        Course course = new Course();
        assertNull(course.getName());

    }
    @Test
    void setNameStoresName(){
        Course course = new Course();
        course.setName("Math");
        assertEquals("Math", course.getName());
    }
    @Test
    void setNameReplacePreviousName(){
        Course course = new Course();
        course.setName("Math");
        course.setName("Physics");
        assertEquals("Physics", course.getName());
    }



}