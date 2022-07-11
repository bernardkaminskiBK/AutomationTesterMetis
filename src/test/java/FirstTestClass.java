import org.junit.jupiter.api.*;

public class FirstTestClass {

    @BeforeAll
    public static void setUp() {
        System.out.println("Before all set up...");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("... before each ...");
    }

    public FirstTestClass() {
        System.out.println("This is the constructor of the FirstTestClass...");
    }

    @Test
    @DisplayName("My custom test method name")
    public void firstTest() {
        System.out.println("je to test");
    }

    @Test
    @DisplayName("My second custom test method name")
    public void secondTest() {
        System.out.println("je to druhy test");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("After all tear down...");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("... after each ...");
    }
}
