package bankoveUcty;

import banka.BankovyUcet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BankovyUcetTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,100,1100", "500,50,550", "2000,123,2123"})
    public void testVlozeniaProstriedkov(double pociatocnyZostatok, double ciastka, double ocakavanyVysledok) {
        BankovyUcet ucet1 = new BankovyUcet(pociatocnyZostatok);
        ucet1.vloz(ciastka);
        double aktualnyZostatok = ucet1.getAktualnyZostatok();

        Assertions.assertEquals(ocakavanyVysledok, aktualnyZostatok, 0.001, "Ocakavany zostatok by mal byt: " + ocakavanyVysledok);
    }

}
