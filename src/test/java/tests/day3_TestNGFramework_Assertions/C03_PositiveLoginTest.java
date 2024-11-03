package tests.day3_TestNGFramework_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C03_PositiveLoginTest {

    @Test
    public void positiveLoginTest(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLink.click();

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailBox.sendKeys(ConfigurationReader.getProperty("toValidEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordBox.sendKeys(ConfigurationReader.getProperty("toValidPassword"));

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.signInButton.click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButton.isDisplayed());


        Driver.quitDriver();
    }
}
