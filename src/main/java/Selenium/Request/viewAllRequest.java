package Selenium.Request;

import UtilMethods.DriverUtil;
import UtilMethods.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class viewAllRequest {

    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("viewAllRequest");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException {

        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void viewAllReq() throws IOException, InterruptedException {
        viewAllReq(this.test, this.driver);
    }

    @Test
    public static void viewAllReq(ExtentTest test, WebDriver driver) throws InterruptedException, IOException {
        try {

            test.log(LogStatus.PASS, "Clicked on Request Drop Down");
            WebElement requestDropDown = driver.findElement(By.xpath("//a[@title='Request']"));
            requestDropDown.click();

            test.log(LogStatus.PASS, "Clicked on View All Request");
            WebElement viewAll = driver.findElement(By.linkText("View All"));
            viewAll.click();

            test.log(LogStatus.PASS, "Asserting through Title");
            String actualTitle = driver.getTitle();
            String expectedTitle = ("WebProcure: Request And Workflow");

            if (Objects.equals(actualTitle, expectedTitle)) {
                System.out.println("Test is passed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
                test.log(LogStatus.PASS, "Request Viewed");
                test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Passed");
            } else {
                System.out.println("Test is Not passed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
                test.log(LogStatus.FAIL, "Request Not Viewed");
                test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
            }
            try {
            } catch (WebDriverException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            test.log(LogStatus.INFO, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");
        }}

    @AfterMethod
    public void tearDown() {
//        driver.close();
    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}