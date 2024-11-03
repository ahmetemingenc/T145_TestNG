package tests.day1_testNGFrameWork;

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

    /*
        JUnit'de yaptigimiz islemleri
        TestNG ile de yapabiliriz

        Ama TestNG daha fazla kontrol ve daha fazla promosyona sahiptir
        Ayrica Java OOP consept tabanli Page Object Model kullanarak

        Test method'larini dinamik hale getirir.

        amac testlerde kullanilan
        url, aranacak kelime, bulunmasi gereken sonuc sayisi ... gibi test datalarini
        hangi browser'in kullanilacagi
        ve webelementler icin locate'leri tek bir yerde tutup
        degisiklik yapmak gerektiginde

        yuzlerce testi gozden gecirmek yerine
        tek bir yerden degisiklik yapip
        tum testlerin yeni datalarla guncellenebilmesidir
     */


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
