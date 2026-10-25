package lt.viko.eif.imazolevska.marshalling.runner;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.marshalling.model.Students;
import lt.viko.eif.imazolevska.marshalling.net.XmlServer;
import lt.viko.eif.imazolevska.marshalling.transform.JaxbXmlTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Loads the students from the XML file on startup and sends them through {@link XmlServer}.
 */

@Component
public class XmlServerRunner implements CommandLineRunner {

    @Autowired
    private XmlServer xmlServer;

    /**
     * Loads the students and starts the server.
     *
     * @param args command line arguments, not used
     * @throws Exception if loading or sending fails
     */

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
