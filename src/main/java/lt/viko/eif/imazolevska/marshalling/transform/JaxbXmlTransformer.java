package lt.viko.eif.imazolevska.marshalling.transform;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.imazolevska.marshalling.model.Students;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.StringWriter;

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

    @Override
    public Students transformToPOJO(String xml_file) throws JAXBException {
        File file = new File(xml_file);
        JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Students) jaxbUnmarshaller.unmarshal(file);
    }
}
