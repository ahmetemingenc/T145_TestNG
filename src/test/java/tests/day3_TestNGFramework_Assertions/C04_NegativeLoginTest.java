package tests.day3_TestNGFramework_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C04_NegativeLoginTest {

    // 1- https://www.testotomasyonu.com/ anasayfasina gidin
    // 2- account linkine basin
    // 3- 3 farkli test method’u olusturun.
    // - gecerli email, gecersiz password
    //         - gecersiz email, gecerli password
    //         - gecersiz email, gecersiz password.
    // 4- Login butonuna basarak login olmayi deneyin
    // 5- Basarili olarak giris yapilamadigini test edin

    @Test
    public void invalidPasswordTest(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLink.click();

        // 3- gecerli email, gecersiz password girin
        testotomasyonuPage.emailBox.sendKeys(ConfigurationReader.getProperty("toValidEmail"));
        testotomasyonuPage.passwordBox.sendKeys(ConfigurationReader.getProperty("toInvalidPassword"));

        // 4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.signInButton.click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailBox.isDisplayed());


        Driver.quitDriver();
    }

    @Test
    public void invalidEmailTest(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLink.click();

        // 3- gecersiz email, gecerli password girin
        testotomasyonuPage.emailBox.sendKeys(ConfigurationReader.getProperty("toInvalidEmail"));
        testotomasyonuPage.passwordBox.sendKeys(ConfigurationReader.getProperty("toValidPassword"));

        // 4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.signInButton.click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailBox.isDisplayed());


        Driver.quitDriver();
    }

    @Test
    public void invalidPasswordAndEmailTest(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLink.click();

        // 3- gecersiz email, gecersiz password girin
        testotomasyonuPage.emailBox.sendKeys(ConfigurationReader.getProperty("toInvalidEmail"));
        testotomasyonuPage.passwordBox.sendKeys(ConfigurationReader.getProperty("toInvalidPassword"));

        // 4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.signInButton.click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailBox.isDisplayed());


        Driver.quitDriver();
    }
}
