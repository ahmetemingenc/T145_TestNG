package tests.day6_htmlReports_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C03_DataProvider {

     /*
        Data provider,
        toplu testlerde, her bir eleman icin tum testin calismasini
        ve her bir element icin method sonucunun raporlanmasini saglar

        "phone", "java", "samsung", "apple", "Nutella", "dress", "sahin", "baby"
        bu 8 kelime icin arama yaptigimizda
        herbiri icin arama testini calistirir ve
        biri failed olsa da digerleri ile yoluna devam eder

        DataProvider iki katli MultiDimensional Object Array'i donduren
        ozel bir method'dur.
     */

    @DataProvider
    public static Object[][] searchedProductsProvider() {

        String[][] searchedProductsArr = {{"phone"}, {"java"}, {"samsung"}, {"Nutella"}, {"dress"}, {"şahin"}, {"baby"}};

        return searchedProductsArr;
    }

    @Test(dataProvider = "searchedProductsProvider")
    public void searchTest(String searchedWord){

        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.searchBox.sendKeys(searchedWord + Keys.ENTER);

        String actualResult = testotomasyonuPage.resultWebElement.getText();

        Assert.assertNotEquals(ConfigurationReader.getProperty("toUnexpectedResult"), actualResult);

        Driver.quitDriver();
    }
}
