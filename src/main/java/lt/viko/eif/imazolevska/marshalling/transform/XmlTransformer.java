package lt.viko.eif.imazolevska.marshalling.transform;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.marshalling.model.Students;

public interface XmlTransformer {

    String transformToXML(Students studentList) throws JAXBException;

    Students transformToPOJO(String xml) throws JAXBException;
}
