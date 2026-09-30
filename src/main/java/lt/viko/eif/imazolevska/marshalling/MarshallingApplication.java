package lt.viko.eif.imazolevska.marshalling;

import lt.viko.eif.imazolevska.marshalling.model.Student;
import lt.viko.eif.imazolevska.marshalling.transform.JaxbXmlTransformer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class MarshallingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarshallingApplication.class, args);
	}
}



