package tests.day2_TestNG_Framework;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_WebUniversity {

    @Test
    public void webDriverUniversityTest() {

        // 1."http://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");

        // 2."Login Portal" a kadar asagi inin
        WebUniversityPage webUniversityPage = new WebUniversityPage();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});", webUniversityPage.loginPortal);

        ReusableMethods.wait(1);

        // 3."Login Portal" a tiklayin
        webUniversityPage.loginPortal.click();

        // 4.Diger window'a gecin
        ReusableMethods.switchToWindowByTitle(Driver.getDriver(), "WebDriver | Login Portal");

        // 5."username" ve "password" kutularina deger yazdirin
        Faker faker = new Faker();

        webUniversityPage.usernameBox.sendKeys(faker.name().fullName());
        webUniversityPage.passwordBox.sendKeys(faker.internet().password());

        // 6."login" butonuna basin
        webUniversityPage.loginButton.click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedAlertText = "validation failed";
        String actualAlertText = Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualAlertText, expectedAlertText);

        // 8.Ok diyerek Popup'i kapatin
        Driver.getDriver().switchTo().alert().accept();

        // 9.Ilk sayfaya geri donun
        ReusableMethods.switchToWindowByTitle(Driver.getDriver(), "WebDriverUniversity.com");

        // 10.Ilk sayfaya donuldugunu test edin
        String expectedTitle = "WebDriverUniversity.com";
        String actualTitle = Driver.getDriver().getTitle();


        Driver.quitDriver();
    }
}