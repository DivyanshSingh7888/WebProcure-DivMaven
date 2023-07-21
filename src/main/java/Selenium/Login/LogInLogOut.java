package Selenium.Login;

import UtilMethods.DriverUtil;
import UtilMethods.ScreenShot;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class LogInLogOut {

    static WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("LogInLogOut");
    }

    Logger logger = Logger.getLogger(LogInLogOut.class);
    @BeforeMethod
    public void setUp() {
        driver = DriverUtil.getDriver();
    }

    @Test
    public void logInOut() throws InterruptedException, IOException {try {

        test.log(LogStatus.PASS, "Logged In");
        test.log(LogStatus.PASS, "Clicking on dropdown");
        WebElement UserDropDown = driver.findElement(By.xpath("//a[@id='userMenu']"));
        UserDropDown.click();

        test.log(LogStatus.PASS, "Logging-Out");
        WebElement LogOut = driver.findElement(By.xpath("//a[@title='Logout']"));
        LogOut.click();

        System.out.println("Logout done");
        test.log(LogStatus.PASS, ">>>>>>>>.");
        Alert alert = driver.switchTo().alert();
        alert.accept();

        test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Passed");
        test.log(LogStatus.PASS, ">>>>>>>>.");
        Thread.sleep(1000);

    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }finally {
        test.log(LogStatus.INFO, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");
    }}

    @AfterMethod
    public void tearDown() throws IOException {
        test.log(LogStatus.PASS, ">>>>>>>>.");
//        driver.close();
    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
