package lt.viko.eif.imazolevska.marshalling.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;



@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlElement(name = "id")
    private int id;

    @XmlElement(name = "first-name")
    private String firstName;

    @XmlElement(name = "last-name")
    private String lastName;

    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
    private List<Course> courses;


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


}
