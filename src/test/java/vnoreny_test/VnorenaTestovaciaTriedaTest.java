package vnoreny_test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

public class VnorenaTestovaciaTriedaTest {

    @Test
    public void testNiecoho() {
        System.out.println("Test niecoho");
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class VnorenaTrieda {

        @BeforeAll
        public void beforeAll() {

        }

        @Test
        public void vnorenyTest() {
            System.out.println("Toto je vnoreny test.");
        }
    }

}
