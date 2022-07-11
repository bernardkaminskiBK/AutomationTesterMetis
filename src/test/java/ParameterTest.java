import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

public class ParameterTest {

    @ParameterizedTest
    @ValueSource(ints = 10)
    public void integerParameter_Test(int num) {
        System.out.println("number: " + num);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    public void integerAnotherParameter_Test(int num) {
        System.out.println("number: " + num);
    }

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 2, 3, 4})
    public void integerThirdParameter_Test(int num) {
        System.out.println("number: " + num);
    }

    @ParameterizedTest
    @EmptySource
    @NullSource
    @ValueSource(strings = {"Karol", "Juro", "Ivetka", "", "Blazenka"})
    public void string_Test(String name) {
        System.out.println("Name: '" + name + "'");
    }

    @ParameterizedTest
    @CsvSource(value = "Jozef,Novak")
    public void dataFromCsv_Test(String firstName, String lastname) {
        System.out.println(firstName + " " + lastname);
    }

    @ParameterizedTest
    @CsvSource(value = {"Jozef,Novak", "Emil,Dlhy", "Katka,Horvathova"})
    public void multipleDataFromCsv_Test(String firstName, String lastname) {
        System.out.println(firstName + " " + lastname);
    }

    @ParameterizedTest
    @CsvSource(value = {"Jozef,Novak,30,true", "Emil,Dlhy,42,false", "Katka,Horvathova,18,true"})
    public void multipleDifferentValuesTypeDataFromCsv_Test(String firstName, String lastname, int age, boolean isActive) {
        System.out.println(firstName + ", " + lastname + ", " + age + ", " + isActive);
    }

    @ParameterizedTest
    @CsvSource(value = {"Jozef,'hladny,Novak'", "Emil,Dlhy", "Katka,Horvathova"})
    public void multipleDifferentValuesTypeDataSeparatedByCommaFromCsv_Test(String firstName, String lastname) {
        System.out.println(firstName + " " + lastname);
    }

    @ParameterizedTest
    @CsvSource(value = {"Jozef#hladny,Novak", "Emil#Dlhy", "Katka#Horvathova"}, delimiter = '#')
    public void delimiterSymbolFromCsv_Test(String firstName, String lastname) {
        System.out.println(firstName + " " + lastname);
    }

    @ParameterizedTest
    @CsvSource(value = {"Jozef#%$hladny,Novak", "Emil#%$Dlhy", "Katka#%$Horvathova"}, delimiterString = "#%$")
    public void delimiterStringSymbolFromCsv_Test(String firstName, String lastname) {
        System.out.println(firstName + " " + lastname);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "info_o_tovaroch.csv", numLinesToSkip = 1)
    // ignoracia v tomto pripade hlavicky v csv file
    public void dataFromCsvFile_Test(String nazov, double cena, int mnozstvo, String jednotkaMiery, String dodavatel) {
        System.out.println(nazov + ", " + cena + ", " + mnozstvo + ", " + jednotkaMiery + ", " + dodavatel);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"info_o_tovaroch.csv", "info_o_tovaroch2.csv", "info_o_tovaroch3.csv"}, numLinesToSkip = 1)
    public void dataFromMultipleCsvFilesResources_Test(String nazov, double cena, int mnozstvo, String jednotkaMiery, String dodavatel) {
        System.out.println(nazov + ", " + cena + ", " + mnozstvo + ", " + jednotkaMiery + ", " + dodavatel);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/info_o_tovaroch.csv", "src/test/resources/info_o_tovaroch2.csv", "src/test/resources/info_o_tovaroch3.csv"}, numLinesToSkip = 1)
    public void dataFromMultipleCsvFiles_Test(String nazov, double cena, int mnozstvo, String jednotkaMiery, String dodavatel) {
        System.out.println(nazov + ", " + cena + ", " + mnozstvo + ", " + jednotkaMiery + ", " + dodavatel);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "info_o_tovaroch4.csv", numLinesToSkip = 1)
    public void nullOrEmptyDataFromCsvFile_Test(String nazov, double cena, int mnozstvo, String jednotkaMiery, String dodavatel) {
        System.out.println(nazov + ", " + cena + ", " + mnozstvo + ", " + jednotkaMiery + ", " + dodavatel);
    }

    @ParameterizedTest
    @MethodSource(value = "getFruits")
    public void methodSource_Test(String fruit) {
        System.out.println("fruit: " + fruit);
    }

    public static List<String> getFruits() {
        return Arrays.asList("jahody", "melony", "hrusky");
    }

    @ParameterizedTest
    @MethodSource(value = "data_provider.DataProvider#getCars")
    public void methodSourceCarsFromClass_Test(String car) {
        System.out.println("car: " + car);
    }

    //TODO: tu pokracujem 1:25:00 Webinar 19

}
