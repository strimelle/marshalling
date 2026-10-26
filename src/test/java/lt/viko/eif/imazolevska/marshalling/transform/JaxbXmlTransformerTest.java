package lt.viko.eif.imazolevska.marshalling.transform;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.marshalling.model.Course;
import lt.viko.eif.imazolevska.marshalling.model.Student;
import lt.viko.eif.imazolevska.marshalling.model.Students;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JaxbXmlTransformerTest {

    private final JaxbXmlTransformer transformer = new JaxbXmlTransformer();

    @Test
    void transformToXmlContainsStudentData() throws JAXBException {

        Student lina = new Student();
        lina.setId(222);
        lina.setFirstName("Lina");

        Course math = new Course();
        math.setName("Math");

        List<Course> courses = new ArrayList<>();
        courses.add(math);
        lina.setCourses(courses);

        List<Student> studentList = new ArrayList<>();
        studentList.add(lina);

        Students group = new Students();
        group.setStudents(studentList);

        String xml = transformer.transformToXML(group);

        assertTrue(xml.contains("<id>222</id>"));
        assertTrue(xml.contains("<first-name>Lina</first-name>"));
        assertTrue(xml.contains("<name>Math</name>"));


    }

    @Test
    void transformToPojoReadsStudentsFromFile() throws JAXBException {

        Students studentList = transformer.transformToPOJO("src/test/resources/XML/test-students.xml");

        assertEquals(10, studentList.getStudents().size());
        assertEquals("Emma", studentList.getStudents().get(0).getFirstName());
        assertEquals("Data Structures and Algorithms", studentList.getStudents().get(1).getCourses().get(0).getName());


    }

}