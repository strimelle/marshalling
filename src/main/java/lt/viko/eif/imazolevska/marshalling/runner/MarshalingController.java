package lt.viko.eif.imazolevska.marshalling.runner;

import lt.viko.eif.imazolevska.marshalling.net.XmlClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/api")
public class MarshalingController {

    @Autowired
    private XmlClient xmlClient;

    @PostMapping("/client/receive")
    public String receive() throws Exception{
        xmlClient.receive();
        return "Received.";
    }
}
