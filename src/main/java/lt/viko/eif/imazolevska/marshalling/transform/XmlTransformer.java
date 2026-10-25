package lt.viko.eif.imazolevska.marshalling.transform;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.marshalling.model.Students;
/**
 * Transforms {@link Students} objects to XML and back.
 */
public interface XmlTransformer {
    /**
     * Transforms the students object to an XML document.
     *
     * @param studentList object to transform
     * @return XML document as a string
     * @throws JAXBException if the transformation fails
     */
    String transformToXML(Students studentList) throws JAXBException;
    /**
     * Reads an XML file and transforms it to a students object.
     *
     * @param xml path to the XML file
     * @return students object
     * @throws JAXBException if the transformation fails
     */
    Students transformToPOJO(String xml) throws JAXBException;
}
