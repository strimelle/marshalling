package lt.viko.eif.imazolevska.marshalling.runner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    // ---- Pagalbinės klasės pratimui ----

    static class EmailSender {
        void send() {
            System.out.println("Sending real email...");
        }
    }

    static class OrderService {
        private EmailSender emailSender;

        String placeOrder() {
            emailSender.send();
            return "Order placed.";
        }
    }

    // ---- Jūsų dalis ----

    // 1. Laukas: netikras EmailSender (su @Mock)
    @Mock
    EmailSender email;

    // 2. Laukas: tikras OrderService, į kurį įdėtas mock'as (su @InjectMocks)
    @InjectMocks
    OrderService order;

    @Test
    void placeOrderSendsEmailAndReturnsConfirmation() {
        // 3. Iškvieskite placeOrder() ir išsaugokite rezultatą į kintamąjį

        String uzsakymas = order.placeOrder();

        // 4. Patikrinkite, kad grąžinta "Order placed."

        assertEquals("Order placed.", uzsakymas);

        // 5. Patikrinkite, kad send() buvo iškviestas

        verify(email).send();


    }
}