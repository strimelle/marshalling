package lt.viko.eif.imazolevska.marshalling.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


/**
 * Represents a course assigned to a student.
 * <p>
 * Mapped to the {@code <course>} element in the XML document.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {
    /**
     * Name of the course, mapped to the {@code <name>} element.
     */
    @XmlElement(name = "name")
    private String name;

    /**
     * Creates an empty course.
     * <p>
     * Required by JAXB, which creates the object first
     * and fills its fields afterwards.
     */
    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
