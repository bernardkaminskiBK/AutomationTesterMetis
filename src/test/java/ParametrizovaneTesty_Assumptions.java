import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParametrizovaneTesty_Assumptions {

    @ParameterizedTest
    @CsvSource(value = {"Peter,30,true", "Karolina,17,false", "Mirec,25,false"})
    public void prikladNaAssumingThat_Test(String meno, int vek, boolean zenaty) {
        Assumptions.assumeTrue(vek > 25);
        System.out.println(meno + ", " + vek + ", " + zenaty);
    }

    @ParameterizedTest
    @CsvSource(value = {"Peter,30,true", "Karolina,17,false", "Mirec,25,false"})
    public void prikladNaAssumingThat2_Test(String meno, int vek, boolean zenaty) {
        Assumptions.assumingThat(vek > 25, () -> System.out.println(meno));
        System.out.println(meno + ", " + vek + ", " + zenaty);
    }

}
