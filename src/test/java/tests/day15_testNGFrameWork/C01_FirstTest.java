package tests.day15_testNGFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_FirstTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup(); // eğer şirketin verdiği özel bir WebDriver varsa
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void searchTest(){

        // testotomasyonu ana sayfaya gidin
        driver.get("https://testotomasyonu.com");

        // phone için arama yapın
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // ürün bulunabildiğini test edin
        String unexpectedSearchResult = "0 Products Found";
        String actualSearchResult = driver.findElement(By.className("product-count-text")).getText();

        Assert.assertNotEquals(actualSearchResult, unexpectedSearchResult);
    }
}
