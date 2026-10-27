package lt.viko.eif.imazolevska.marshalling.runner;

import lt.viko.eif.imazolevska.marshalling.net.XmlClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MarshalingControllerTest {

    @Mock
    XmlClient xmlClient;

    @InjectMocks
    MarshalingController controller;

    @Test
    void receiveCallsClientAndReturnsConfirmation() throws Exception {

        String response = controller.receive();
        assertEquals("Received.", response);
        verify(xmlClient).receive();
    }
}