package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
}