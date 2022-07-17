import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestovaciaTriedaMethodName {

    @Test
    public void metodaA() {
        System.out.println("Spustila sa metoda A");
    }

    @Test
    public void metodaB() {
        System.out.println("Spustila sa metoda B");
    }

    @Test
    public void metodaC() {
        System.out.println("Spustila sa metoda C");
    }
}
