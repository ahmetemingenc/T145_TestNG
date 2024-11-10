package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> convertStringList(List<WebElement> elementList) {

        List<String> stringElementList = new ArrayList<>();

        for (WebElement each : elementList) {

            stringElementList.add(each.getText());
        }

        return stringElementList;
    }

    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {}
    }

    public static void switchToWindowByTitle(WebDriver driver, String title){

        Set<String> allWindowsWhdSet = driver.getWindowHandles();

        for (String each : allWindowsWhdSet){

            driver.switchTo().window(each);

            if (driver.getTitle().equals(title)){
                break;
            };
        }
    }

    public static void switchToWindowByUrl(WebDriver driver, String url){

        Set<String> allWindowsWhdSet = driver.getWindowHandles();

        for (String each : allWindowsWhdSet){

            driver.switchTo().window(each);

            if (driver.getCurrentUrl().equals(url)){
                break;
            };
        }
    }

    public static void javascriptExecutor(WebElement hedefElement){

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});", hedefElement);
    }
}