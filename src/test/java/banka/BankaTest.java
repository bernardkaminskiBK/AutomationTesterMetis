package banka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.InvocationTargetException;

public class BankaTest {

    Banka banka = new Banka();

    @Test
    public void testGetPocetUctov() {
        Assertions.assertEquals(0, banka.getPocetUctov());
    }

    // Classic test
    @Test
    public void zalozenieUctu_Test() {
        banka.zalozUcet(new BankovyUcet(1, 1000.0));
        banka.zalozUcet(new BankovyUcet(2, 500.0));
        banka.zalozUcet(new BankovyUcet(3, 700.0));

        Assertions.assertEquals(3, banka.getPocetUctov());
    }

    // Parametrized test example
    @ParameterizedTest
    @CsvFileSource(resources = "bankove_ucty.csv", numLinesToSkip = 1)
    public void zalozenieUctuParametrized_Test(int cisloUctu, double aktualnyZostatok) {
        banka.zalozUcet(new BankovyUcet(cisloUctu, aktualnyZostatok));
        banka.zalozUcet(new BankovyUcet(cisloUctu, aktualnyZostatok));
        banka.zalozUcet(new BankovyUcet(cisloUctu, aktualnyZostatok));

        Assertions.assertEquals(3, banka.getPocetUctov());
    }

    @Test
    public void zmazanieUctu_Test() {
        banka.zalozUcet(new BankovyUcet(1, 1000.0));
        banka.zalozUcet(new BankovyUcet(2, 500.0));
        banka.zalozUcet(new BankovyUcet(3, 700.0));

        banka.zmazUcet(1);

        Assertions.assertEquals(2, banka.getPocetUctov());
    }

    @Test
    public void pocetUctovZostatkomVyssimAko_500_Test() {
        banka.zalozUcet(new BankovyUcet(1, 1000.0));
        banka.zalozUcet(new BankovyUcet(2, 1350.0));
        banka.zalozUcet(new BankovyUcet(3, 500.0));
        banka.zalozUcet(new BankovyUcet(4, 700.0));

        int actual = banka.getPocetUctovSoZostatkomVyssimAko(500);

        Assertions.assertEquals(3, actual);
    }

    @Test
    public void celkovyZostatokNaVsetkychUctoch_Test() {
        banka.zalozUcet(new BankovyUcet(1, 1000.0));
        banka.zalozUcet(new BankovyUcet(3, 500.0));
        banka.zalozUcet(new BankovyUcet(4, 700.0));

        Assertions.assertEquals(2200, banka.getCelkovyZostatok());
    }

    @Test
    public void zmazanieNeexistujucehoUctu_Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        banka.zmazUcet(1);
        Assertions.assertEquals(0, banka.getPocetUctov());
    }

}
