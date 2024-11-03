package tests.day1_testNGFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priority {

        /*
        TestNG test method'larini alfabetik siraya gore calistirir

        Eger biz istenen bir sira ile calismalarini istiyorsak
        hepsine bir priority degeri atayabiliriz
        priority degeri kucuk olan daha once calisir

        eger bir test method'una priority atanmazsa
        default olarak priority degeri 0 kabul edilir
        ve 0'a gore siralamaya dahil olur

        eger priority degeri ayni olan method'lar varsa
        kendi iclerinde alfabetik siraya uygun olarak calisirlar

     */


    // 3 farkli test methodu olusturarak asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidin Title'in "Test Otomasyonu" icerdigini test edin
    // 2- wisequarter anasayfaya gidin Url'in "wisequarter" icerdigini test edin
    // 3- youtube anasayfaya gidin Title'in "vimeo" icermedigini test edin

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

    @Test (priority = 2)
    public void testotomasyonuTest(){

        // 1- testotomasyonu anasayfaya gidin Title'in "Test Otomasyonu" icerdigini test edin

        driver.get("https://testotomasyonu.com");

        String expectedTitleContent = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleContent));
    }

    @Test (priority = 1)
    public void wisequarterTest(){

        // 2- wisequarter anasayfaya gidin Url'in "wisequarter" icerdigini test edin
        driver.get("https://wisequarter.com");

        String expectedUrlContent = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlContent));
    }

    @Test (priority = 3)
    public void youtubeTest(){

        // 3- youtube anasayfaya gidin Title'in "vimeo" icermedigini test edin
        driver.get("https://youtube.com");

        String unexpectedTitleContent = "vimeo";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unexpectedTitleContent));
    }
}
