package lt.viko.eif.imazolevska.marshalling;

import lt.viko.eif.imazolevska.marshalling.runner.XmlServerRunner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class MarshallingApplicationTest {

    @MockitoBean
    XmlServerRunner runner;

    @Test
    void contextLoads() {

    }
}