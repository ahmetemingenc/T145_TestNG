package tests.day2_TestNG_Framework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C02_PageClassKullanimi {

    @Test
    public void searchTest(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://testotomasyonu.com");

        // phone icin arama yapin
        // arama yapabilmek icin once arama kutusunu locate etmeliyiz
        // Locate edip atama islemleri artik Page Class'larinda olacak
        // ve page class'indaki WebElement'lere obje olusturarak ulasacagiz

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.searchBox.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        Assert.assertTrue(testotomasyonuPage.productsFoundElementsList.size() > 0);

        Driver.quitDriver();
    }
}
