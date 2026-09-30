package lt.viko.eif.imazolevska.marshalling.net;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.marshalling.model.Student;
import lt.viko.eif.imazolevska.marshalling.model.Students;
import lt.viko.eif.imazolevska.marshalling.transform.XmlTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Component
public class XmlClient {

    @Autowired
    private XmlTransformer transformer;
    //receive
    public void receive() throws IOException, JAXBException {

        try (Socket clientSocket = new Socket("localhost", 8383)){
            InputStream clientOutput = clientSocket.getInputStream();

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] chunk = new byte[1024];
            int bytesRead;
            while ((bytesRead = clientOutput.read(chunk)) != -1){
                buffer.write(chunk, 0, bytesRead);
            }

            String xml = buffer.toString(StandardCharsets.UTF_8);

            Students studentList = transformer.transformToPOJO(xml);


            for(Student student : studentList.getStudents()){

                System.out.println("ID: " + student.getId()
                        + ", Name: " + student.getFirstName() + " " + student.getLastName()
                        + ", Courses: " + student.getCourses().size());
            }




        }

    }


}
