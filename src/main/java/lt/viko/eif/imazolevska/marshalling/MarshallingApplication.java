package lt.viko.eif.imazolevska.marshalling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point of the marshalling application.
 * <p>
 * Starts the Spring Boot context, which creates all components,
 * launches the embedded web server and runs the XML server
 * through {@link lt.viko.eif.imazolevska.marshalling.runner.XmlServerRunner}.
 */
@SpringBootApplication
public class MarshallingApplication {

    /**
     * Starts the Spring Boot application.
     *
     * @param args command line arguments passed to Spring Boot
     */

    public static void main(String[] args) {
        SpringApplication.run(MarshallingApplication.class, args);
    }
}



