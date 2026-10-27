package lt.viko.eif.imazolevska.marshalling.net;

import lt.viko.eif.imazolevska.marshalling.model.Students;
import lt.viko.eif.imazolevska.marshalling.transform.XmlTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class XmlServerClientTest {

    @Mock
    XmlTransformer transformer;

    @InjectMocks
    XmlServer server;

    @InjectMocks
    XmlClient client;

    @Test
    void clientReceivesXmlSentByServer() throws Exception {

        Students studentList = new Students();
        Students newStudentList = new Students();

        when(transformer.transformToXML(studentList)).thenReturn("<students/>");
        when(transformer.transformToPOJO("received.xml")).thenReturn(newStudentList);

        Thread serverThread = new Thread(() -> {
            try {

                server.send(studentList);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        serverThread.start();
        Thread.sleep(500);
        client.receive();
        serverThread.join();

        assertTrue(Files.readString(Path.of("received.xml")).contains("<students/>"));
        verify(transformer).transformToPOJO("received.xml");
    }
}