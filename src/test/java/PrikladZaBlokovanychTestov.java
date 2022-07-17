import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class PrikladZaBlokovanychTestov {

    @Test
    @Disabled("Test zablokovany z dovodu na ukazku @Disabled anotacie")
    public void testAnotacieDisabled() {
        System.out.println("test anotacie disabled");
    }

    @Test
    @DisabledOnOs(value = {OS.WINDOWS, OS.LINUX}, disabledReason = "Lebo preco nie...")
    public void testAnotacieDisabled2() {
        System.out.println("test anotacie disabled");
    }

}
