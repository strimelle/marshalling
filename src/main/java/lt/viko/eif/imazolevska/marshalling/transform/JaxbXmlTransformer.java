package lt.viko.eif.imazolevska.marshalling.transform;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.imazolevska.marshalling.model.Students;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;

/**
 * {@link XmlTransformer} implementation based on JAXB.
 */

@Service
public class JaxbXmlTransformer implements XmlTransformer {

    @Override
    public String transformToXML(Students studentList) throws JAXBException {
        JAXBContext jaxbcontext = JAXBContext.newInstance(Students.class);
        Marshaller jaxbMarshaller = jaxbcontext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        jaxbMarshaller.marshal(studentList, writer);
        return writer.toString();

    }

    /**
     * Reads an XML file, validates it against the XSD schema
     * and transforms it to a students object.
     *
     * @param xml path to the XML file
     * @return students object
     * @throws JAXBException if the file does not match the XSD schema or the transformation fails
     */

    @Override
    public Students transformToPOJO(String xml) throws JAXBException {

        FileReader reader = null;
        try {
            reader = new FileReader(xml);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        jaxbUnmarshaller.setSchema(loadSchema());
        return (Students) jaxbUnmarshaller.unmarshal(reader);
    }

    /**
     * Loads the XSD schema used to validate XML documents before unmarshalling.
     *
     * @return XSD schema from the resources folder
     * @throws JAXBException if the schema cannot be loaded
     */
    private Schema loadSchema() throws JAXBException {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            return schemaFactory.newSchema(getClass().getResource("/XML/xsd-schema.xsd"));
        } catch (SAXException e) {
            throw new JAXBException("Cannot load XSD schema", e);
        }

    }
}
