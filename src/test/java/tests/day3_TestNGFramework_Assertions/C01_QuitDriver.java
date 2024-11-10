package tests.day3_TestNGFramework_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_QuitDriver {

    // 3 farkli test methodu olusturarak asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidin Title'in "Test Otomasyonu" icerdigini test edin
    // 2- wisequarter anasayfaya gidin Url'in "wisequarter" icerdigini test edin
    // 3- youtube anasayfaya gidin Title'in "vimeo" icermedigini test edin

    @Test(groups = "smoke")
    public void testotomasyonuTest(){

        // 1- testotomasyonu anasayfaya gidin Title'in "Test Otomasyonu" icerdigini test edin

        Driver.getDriver().get("https://testotomasyonu.com");

        String expectedTitleContent = "Test Otomasyonu";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleContent));

        Driver.quitDriver();
    }

    @Test
    public void wisequarterTest(){

        // 2- wisequarter anasayfaya gidin Url'in "wisequarter" icerdigini test edin
        Driver.getDriver().get("https://wisequarter.com");

        String expectedUrlContent = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlContent));

        Driver.quitDriver();
    }

    @Test
    public void youtubeTest(){

        // 3- youtube anasayfaya gidin Title'in "vimeo" icermedigini test edin
        Driver.getDriver().get("https://youtube.com");

        String unexpectedTitleContent = "vimeo";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertFalse(actualTitle.contains(unexpectedTitleContent));

        Driver.quitDriver();
    }

}