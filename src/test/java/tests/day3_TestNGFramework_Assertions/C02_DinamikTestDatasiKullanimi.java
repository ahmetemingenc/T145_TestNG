package tests.day3_TestNGFramework_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C02_DinamikTestDatasiKullanimi {

    @Test(groups = "smoke")
    public void searchTest(){

        // testotomasyonu sayfasina dinamik url kullanarak gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        // arama kutusuna belirlenen aranacakKelime'yi yazip aratin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.searchBox.sendKeys(ConfigurationReader.getProperty("toSearchedWord") + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        Assert.assertTrue(testotomasyonuPage.productsFoundElementsList.size() > 0);

        // ilk urunu tiklayin
        testotomasyonuPage.productsFoundElementsList.get(0).click();

        // acilan sayfadaki urun isminde case sensitive olmadan belirlenmis aranacakKelime gectigini test edin
        String searchWord = ConfigurationReader.getProperty("toSearchWord");
        String actualProductName = testotomasyonuPage.firstProductName.getText().toLowerCase();

        Assert.assertTrue(actualProductName.contains(searchWord));

        Driver.quitDriver();
    }
}
