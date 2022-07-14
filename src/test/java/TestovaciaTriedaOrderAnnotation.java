import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestovaciaTriedaOrderAnnotation {

    @Test
    @Order(3)
    public void metodaA() {
        System.out.println("Spustila sa metoda A");
    }

    @Test
    @Order(2)
    public void metodaB() {
        System.out.println("Spustila sa metoda B");
    }

    @Test
    @Order(1)
    public void metodaC() {
        System.out.println("Spustila sa metoda C");
    }
}
