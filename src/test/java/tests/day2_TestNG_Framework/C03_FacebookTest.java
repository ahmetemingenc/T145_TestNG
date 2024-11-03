package tests.day2_TestNG_Framework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_FacebookTest {

    @Test
    public void facebookTest(){

        // 1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        // 2- Cookies cikiyorsa kabul edin
        // 3- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        // 4- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker = new Faker();

        FacebookPage facebookPage = new FacebookPage();

        facebookPage.emailBox.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordBox.sendKeys(faker.internet().password());
        facebookPage.loginButton.click();

        // 5- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.emailBox.isDisplayed());

        Driver.quitDriver();
    }
}
