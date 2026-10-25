package lt.viko.eif.imazolevska.marshalling.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * Root object of the XML document that holds the list of students.
 * Mapped to the {@code <students>} element.
 */
@XmlRootElement (name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class Students {
    @XmlElement(name = "student")
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
