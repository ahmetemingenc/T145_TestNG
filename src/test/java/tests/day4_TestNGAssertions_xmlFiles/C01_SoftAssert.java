package tests.day4_TestNGAssertions_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_SoftAssert {

    @Test
    public void test01(){

        // testotomasyonu sayfasina dinamik url kullanarak gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        // url'in verilen url ile aynı olduğunu doğrulayın
        String expectedUrl =  ConfigurationReader.getProperty("toUrl") + "x";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualUrl, expectedUrl, "URL, verilen URL ile aynı değil");

        // arama kutusuna belirlenen aranacakKelime'yi yazip aratin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.searchBox.sendKeys(ConfigurationReader.getProperty("toSearchedWord") + Keys.ENTER);

        // arama sonucunda urun bulunabildigini doğrulayın
        softAssert.assertTrue(testotomasyonuPage.productsFoundElementsList.size() > 0);

        // ilk urunu tiklayin
        testotomasyonuPage.productsFoundElementsList.get(0).click();

        // acilan sayfadaki urun isminde case sensitive olmadan belirlenmis aranacakKelime gectigini doğrulayın
        String searchedWord = ConfigurationReader.getProperty("toSearchedWord") + "x";
        String actualProductName = testotomasyonuPage.firstProductName.getText().toLowerCase();

        softAssert.assertTrue(actualProductName.contains(searchedWord), "Ürün ismi, aranan kelimeyi içermiyor");


        Driver.quitDriver();

        softAssert.assertAll();
    }
}
