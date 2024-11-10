package tests.day5_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C01_RaporluTestOlusturma extends TestBaseReport {

    @Test
    public void positiveLoginTestWithReport(){

        extentTest = extentReports.createTest("PositiveLogingTest", "User should be able to login with valid informations");

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));
        extentTest.info("kullanıcı testotomasyonu ana sayfasına gider");

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLink.click();
        extentTest.info("account linkine basar");

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailBox.sendKeys(ConfigurationReader.getProperty("toValidEmail"));
        extentTest.info("geçerli email adresini girer");

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordBox.sendKeys(ConfigurationReader.getProperty("toValidPassword"));
        extentTest.info("geçerli şifre girer");

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.signInButton.click();
        extentTest.info("sign in butonuna basar");

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButton.isDisplayed());
        extentTest.pass("başarılı olarak giriş yapılabildiğini test eder");

    }
}
