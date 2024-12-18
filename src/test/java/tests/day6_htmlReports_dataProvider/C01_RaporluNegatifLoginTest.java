package tests.day6_htmlReports_dataProvider;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C01_RaporluNegatifLoginTest extends TestBaseReport {

    @Test
    public void invalidPasswordTest() {

        extentTest = extentReports.createTest("Geçersiz Şifre Testi", "Geçersiz şifre ve geçerli kullanıc adı ile giriş yapılamaz");

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));
        extentTest.info("Kullanıcı testotomasyonu ana sayfasına gider");

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLink.click();

        extentTest.info("Account linkine basar");

        // 3- gecerli email, gecersiz password girin
        testotomasyonuPage.emailBox.sendKeys(ConfigurationReader.getProperty("toValidEmail"));
        testotomasyonuPage.passwordBox.sendKeys(ConfigurationReader.getProperty("toInvalidPassword"));

        extentTest.info("Gecerli email, gecersiz password girer");

        // 4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.signInButton.click();

        extentTest.info("Login butonuna basarak login olmayi dener");

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailBox.isDisplayed());

        extentTest.pass("Basarili olarak giris yapilamadigini test eder");


        Driver.quitDriver();
    }
}
