package ExtentRepoetListners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListener extends TestListenerAdapter {
    private ExtentReports extentReports;
    private ExtentTest extentTest;

    public static com.relevantcodes.extentreports.ExtentReports report;
    public static com.relevantcodes.extentreports.ExtentTest logger;

    public void ExtentReport()
    {
        report = new com.relevantcodes.extentreports.ExtentReports("test-output/ExtentReport.html");
        report.loadConfig(new File(System.getProperty("user.dir") + "testng.xml"));
    }

    @Override
    public void onStart(ITestContext testContext) {
        // Create an instance of ExtentReports and specify the output file location
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter((ExtentObserver) htmlReporter.html);
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("MMddhyyyyhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        //String destination = "tmp/FailedTestsScreenshots/" + screenshotName + dateName

        String destination =   "D:/Div.files/D.files/DivMaven/src/main/java/ScreenShots" + screenshotName + dateName
                + ".png";
        File finalDestination = new File(destination);
        Files.copy(source, finalDestination);
        return destination;
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new ExtentTest for each test method
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test success status
        extentTest.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test failure status and exception details
        extentTest.log(Status.FAIL, "Test failed");
        extentTest.log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        // Flush and close the ExtentReports instance
        extentReports.flush();
//        extentReports.close();
    }
}
