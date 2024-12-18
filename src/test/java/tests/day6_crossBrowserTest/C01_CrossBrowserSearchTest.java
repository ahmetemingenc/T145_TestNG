package tests.day6_crossBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_CrossBrowserSearchTest extends TestBaseCross {

    @Test
    public void searchTest(){

        driver.get(ConfigurationReader.getProperty("toUrl"));

        ReusableMethods.wait(1);

        WebElement searchBox = driver.findElement(By.id("global-search"));

        ReusableMethods.wait(1);

        searchBox.sendKeys(ConfigurationReader.getProperty("toSearchedWord") + Keys.ENTER);

        ReusableMethods.wait(1);

        String actualResultText = driver.findElement(By.className("product-count-text")).getText();
        String unExpectedResultTest = ConfigurationReader.getProperty("toUnexpectedResult");

        Assert.assertNotEquals(ConfigurationReader.getProperty("toUnexpectedResult"), actualResultText);
    }
}
