package lt.viko.eif.imazolevska.marshalling.runner;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.marshalling.model.Students;
import lt.viko.eif.imazolevska.marshalling.net.XmlServer;
import lt.viko.eif.imazolevska.marshalling.transform.JaxbXmlTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class XmlServerRunner implements CommandLineRunner {

    @Autowired
    private XmlServer xmlServer;

    @Override
    public void run(String... args) throws Exception {

        Students studentList = loadStudentsFromFile();
        xmlServer.send(studentList);
        System.in.read();
    }

    private Students loadStudentsFromFile() throws JAXBException {
        JaxbXmlTransformer transformer = new JaxbXmlTransformer();
        return transformer.transformToPOJO("/home/ieva/IdeaProjects/marshalling/src/main/resources/XML/students.xml");
    }
}
