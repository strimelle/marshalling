package lt.viko.eif.imazolevska.marshalling.runner;

import lt.viko.eif.imazolevska.marshalling.net.XmlServer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class XmlServerRunnerTest {

    @Mock
    XmlServer server;

    @InjectMocks
    XmlServerRunner runner;


    @Test
    void runLoadsStudentsAndSendsThemToServer() throws Exception {
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream("\n".getBytes()));

        runner.run();

        System.setIn(originalIn);

        verify(server).send(any());

    }
}