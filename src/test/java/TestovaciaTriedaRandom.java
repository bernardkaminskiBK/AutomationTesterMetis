import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
public class TestovaciaTriedaRandom {

    @Test
    @DisplayName("01 - prihlasenie")
    public void metodaC() {
        System.out.println("Prihlasenie prebehlo uspesne.");
    }

    @Test
    @DisplayName("02 - platba")
    public void metodaA() {
        System.out.println("Platba prebehla uspesne.");
    }

    @Test
    @DisplayName("03 - odhlasenie")
    public void metodaB() {
        System.out.println("Odhlasenie prebehlo uspesne.");
    }
}
