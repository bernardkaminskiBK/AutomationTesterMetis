package banka;

import listeners.Listener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

@ExtendWith(Listener.class)
public class BankaTest {
    /*
          spustanie tetov cez maven napriklad:
          mvn  test -Dtest=banka.BankaTest
          mvn  test -Dtest=banka.BankaTest,bankoveUcty.BankovyUcetTest
    */
    Banka banka = new Banka();

    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @ParameterizedTest
    @ValueSource(ints = {4500, 5000, 6000})
    public void testPodrzanieVlakna(int trvanieVMilisekundach) throws InterruptedException {
        Thread.sleep(trvanieVMilisekundach);
    }

    @VlastnaAnotacia
    public void vlastnaAnotaciaTest() {
        System.out.println("Spustena metoda vlastnou anotaciou test.");
    }

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

    @Tag("sanity")
    @Test
    public void zmazanieUctu_Test() {
        banka.zalozUcet(new BankovyUcet(1, 1000.0));
        banka.zalozUcet(new BankovyUcet(2, 500.0));
        banka.zalozUcet(new BankovyUcet(3, 700.0));

        banka.zmazUcet(1);

        Assertions.assertEquals(2, banka.getPocetUctov());
    }

    @Tag("api")
    @Test
    public void pocetUctovZostatkomVyssimAko_500_Test() {
        banka.zalozUcet(new BankovyUcet(1, 1000.0));
        banka.zalozUcet(new BankovyUcet(2, 1350.0));
        banka.zalozUcet(new BankovyUcet(3, 500.0));
        banka.zalozUcet(new BankovyUcet(4, 700.0));

        int actual = banka.getPocetUctovSoZostatkomVyssimAko(500);

        Assertions.assertEquals(3, actual);
    }

    @Tag("api")
    @Tag("sanity")
    @Test
    public void celkovyZostatokNaVsetkychUctoch_Test() {
        banka.zalozUcet(new BankovyUcet(1, 1000.0));
        banka.zalozUcet(new BankovyUcet(3, 500.0));
        banka.zalozUcet(new BankovyUcet(4, 700.0));

        Assertions.assertEquals(2200, banka.getCelkovyZostatok());
    }

    @Tag("api")
    @Tag("sanity")
    @Test
    public void zmazanieNeexistujucehoUctu_Test() {
        banka.zmazUcet(1);
        Assertions.assertEquals(0, banka.getPocetUctov());
    }

}
