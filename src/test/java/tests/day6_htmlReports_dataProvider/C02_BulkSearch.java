package tests.day6_htmlReports_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_BulkSearch {

    @Test
    public void searchTest(){

        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.searchBox.sendKeys("phone" + Keys.ENTER);

        String actualResult = testotomasyonuPage.resultWebElement.getText();

        Assert.assertNotEquals(ConfigurationReader.getProperty("toUnexpectedResult"), actualResult);

        Driver.quitDriver();
    }

    @Test
    public void bulkSearchTest(){

        // yukarıdaki arama testindeki adımları verilen liste için gerçekleştirin
        // phone, java, samsung, Nutella, dress, şahin, baby

        List<String> searchedWords = new ArrayList<>(Arrays.asList("phone", "java", "samsung", "Nutella", "dress", "şahin", "baby"));

        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        SoftAssert softAssert = new SoftAssert();

        for (String each : searchedWords){

            testotomasyonuPage.searchBox.sendKeys(each + Keys.ENTER);

            String actualResult = testotomasyonuPage.resultWebElement.getText();

            softAssert.assertNotEquals(ConfigurationReader.getProperty("toUnexpectedResult"), actualResult);
        }

        Driver.quitDriver();

        softAssert.assertAll();
    }
}
