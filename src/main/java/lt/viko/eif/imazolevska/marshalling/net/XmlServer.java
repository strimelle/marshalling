package lt.viko.eif.imazolevska.marshalling.net;


import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.marshalling.model.Students;
import lt.viko.eif.imazolevska.marshalling.transform.XmlTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Component
public class XmlServer {

    @Autowired
    private XmlTransformer transformer;

    public void send(Students studentList) throws IOException, JAXBException {

        try (
                ServerSocket server = new ServerSocket(8383);
                Socket clientSocket = server.accept();
                OutputStream out = clientSocket.getOutputStream()) {

            String xml = transformer.transformToXML(studentList);
            System.out.println(xml);

            out.write(xml.getBytes(StandardCharsets.UTF_8));
            out.flush();
        }
    }
}
