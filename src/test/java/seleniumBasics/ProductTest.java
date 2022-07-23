package seleniumBasics;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class ProductTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/");
//        driver.get("https://the-internet.herokuapp.com/");  // webovka fajn na automation testing
        // https://www.toolsqa.com/selenium-webdriver/selenium-tutorial/ use full link
    }

    @Test
    public void test_openThenCloseWindow() throws InterruptedException {
        System.out.println("ok");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test_openProductsListSearchForSpecificProduct() throws InterruptedException {
        WebElement menuBtn = driver.findElement(By.className("menu-btn"));
        menuBtn.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By
                                .xpath("//app-side-nav/div/ul/li[4]/a"))));

        WebElement productBtn = driver.findElement(By.linkText("Products"));
        productBtn.click();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("AAA auto");

        Thread.sleep(1000);

        String expectedResultProductTitle = driver.findElement(By.xpath("//span[text()='AAA auto']")).getText();

        Assertions.assertEquals(expectedResultProductTitle, "AAA auto");

//        Thread.sleep(3000);
        driver.quit();
    }


}
