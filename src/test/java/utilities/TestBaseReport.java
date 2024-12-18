package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestBaseReport {

    public static ExtentReports extentReports; // initializes extent report
    protected static ExtentTest extentTest; // logs test results as pass or fail; also used for adding screenshots
    protected static ExtentHtmlReporter extentHtmlReporter; // organizes the HTML report

    // Runs immediately before test execution begins (before all tests, not individual test methods)
    @BeforeTest(alwaysRun = true) // alwaysRun: executes always
    public void setUpTest() {
        extentReports = new ExtentReports(); // Starts reporting
        // specifies the location for saving the report once created
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/Report" + date + ".html";
        // starts generating the report in HTML format at the file path
        // adds a date tag to the report using the date class
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        // Adds additional information to the report
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser")); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Ahmet Emin Genc");
        extentHtmlReporter.config().setDocumentTitle("TestNG Test");
        extentHtmlReporter.config().setReportName("TestNG Reports");
    }

    // After each test method, if there’s an error, it takes a screenshot and adds it to the report
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) { // if the test fails
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // if the test is skipped
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignored tests
        }
        Driver.quitDriver();
    }

    // Ends reporting
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush();
    }
}
