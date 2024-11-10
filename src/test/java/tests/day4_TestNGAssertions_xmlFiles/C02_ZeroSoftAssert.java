package tests.day4_TestNGAssertions_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroBankPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_ZeroSoftAssert {

    @Test
    public void test01(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = "http://zero.webappsecurity.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl, expectedUrl, "Ana sayfaya gidilemedi");

        // 3. Sign in butonuna basin
        ZeroBankPage zeroBankPage = new ZeroBankPage();

        zeroBankPage.signinButton.click();

        // 4. Login kutusuna “username” yazin
        zeroBankPage.loginBox.sendKeys(ConfigurationReader.getProperty("zeroValidUsername"));

        // 5. Password kutusuna “password” yazin
        zeroBankPage.passwordBox.sendKeys(ConfigurationReader.getProperty("zeroValidPassword"));

        // 6. Sign in tusuna basin
        zeroBankPage.submitButton.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroBankPage.iconUser.isDisplayed(), "Giriş yapılamadı");

        // 9. Online banking menusunu tiklayin
        zeroBankPage.onlineBankingButton.click();

        // 10. Pay Bills sayfasina gidin
        zeroBankPage.payBillsButton.click();

        // 11. “Purchase Foreign Currency” tusuna basin
        zeroBankPage.purchaseForeignCurrencyButton.click();

        // 12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroBankPage.dropDownCurrency.isDisplayed(), "Currency dropdown menüsü erişilebilir değil");

        // 13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(zeroBankPage.dropDownCurrency);

        select.selectByVisibleText("Eurozone (euro)");

        // 14. "Eurozone (euro)" secildigini dogrulayin
        String expectedSelection = "Eurozone (euro)";
        String actualSelection = select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSelection, expectedSelection, "Seçilen değer Eurozone (euro) değil");

        // 15. Dropdown menude 16 option bulundugunu dogrulayin.
        List<WebElement> currencyOptionsElementsList = select.getOptions();

        softAssert.assertTrue(currencyOptionsElementsList.size() == 16, "Currency dropdown menüsünün seçenek sayısı 16 değil");

        // 16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        String expectedOption = "Canada (dollar)";

        softAssert.assertTrue(ReusableMethods.convertStringList(currencyOptionsElementsList).contains(expectedOption));

        // 17. Sayfayi kapatin
        softAssert.assertAll();

        Driver.quitDriver();
    }
}
