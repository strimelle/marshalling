package lt.viko.eif.imazolevska.marshalling.model;


import jakarta.xml.bind.annotation.*;



@XmlAccessorType(XmlAccessType.FIELD)
public class Course{

    @XmlElement(name = "name")
    private String name;

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
