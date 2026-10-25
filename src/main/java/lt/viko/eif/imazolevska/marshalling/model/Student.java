package lt.viko.eif.imazolevska.marshalling.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;


/**
 * Represents a student with personal data and a list of assigned courses.
 * Mapped to the {@code <student>} element.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlElement(name = "id")
    private int id;

    @XmlElement(name = "first-name")
    private String firstName;

    @XmlElement(name = "last-name")
    private String lastName;
    /** Whether the student is currently active. */
    @XmlElement(name = "status")
    private boolean status;
    /** Grade point average of the student. */
    @XmlElement(name = "gpa")
    private float gpa;

    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
    private List<Course> courses;

    /** Creates an empty student. Required by JAXB. */
    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}
