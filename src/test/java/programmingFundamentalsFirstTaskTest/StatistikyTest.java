package programmingFundamentalsFirstTaskTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import programingFundamentalsFirstTask.Statistiky;

public class StatistikyTest {

    @ParameterizedTest
    @CsvSource(value = {"5.0,5.0", "10000000,10000000", "-8,500"})
    public void vypocitajStatistikyTest(double cislo1, double cislo2) {

        String secondExpectedResult = "Sucet: " + (cislo1 + cislo2) + "\n" + "Sucin: " + (cislo1 * cislo2) + "\n" + "Rozdiel: " + (cislo1 - cislo2) + "\n" + "Podiel: " + (cislo1 / cislo2) + "\n" + "Zvysok: " + (cislo1 % cislo2);
        String actualResult = Statistiky.vypocitajStatistiky(cislo1, cislo2);

        Assertions.assertEquals(secondExpectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
    public void vypocitajStatistikyTest(double cislo1, double cislo2, String expectedResult) {
        String actualResult = Statistiky.vypocitajStatistiky(cislo1, cislo2);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
