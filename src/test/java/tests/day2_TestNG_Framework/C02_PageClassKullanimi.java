package tests.day2_TestNG_Framework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonPage;
import utilities.Driver;

import java.util.List;

public class C02_PageClassKullanimi {

    @Test
    public void searchTest(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://testotomasyonu.com");

        // phone icin arama yapin
        // arama yapabilmek icin once arama kutusunu locate etmeliyiz
        // Locate edip atama islemleri artik Page Class'larinda olacak
        // ve page class'indaki WebElement'lere obje olusturarak ulasacagiz

        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();

        testotomasyonPage.searchBox.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        Assert.assertTrue(testotomasyonPage.productsFoundElementsList.size() > 0);

        Driver.quitDriver();
    }
}
