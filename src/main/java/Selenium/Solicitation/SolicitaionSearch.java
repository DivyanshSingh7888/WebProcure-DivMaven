package Selenium.Solicitation;

import UtilMethods.DriverUtil;
import UtilMethods.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class SolicitaionSearch {

    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("SolicitaionSearch");
        test.log(LogStatus.PASS, ">>>Start>>>>");
    }


    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException {
        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void solicitationSearch() throws IOException, InterruptedException
    {
        solicitationSearch(test, this.driver);
    }

    public static void solicitationSearch(ExtentTest test, WebDriver driver) throws InterruptedException, IOException {
        try {

            test.log(LogStatus.PASS, "Clicking on Solicitation Drop Down");
            WebElement solicitaionDropDown = driver.findElement(By.xpath("//a[@title='Solicitations']"));
            solicitaionDropDown.click();

            test.log(LogStatus.PASS, "Clicking on Search Button");
            WebElement searchButton = driver.findElement(By.xpath("//a[@title='Solicitation Search']"));
            searchButton.click();

//            WebElement searchBox = driver.findElement(By.id("input-search-box"));
//            searchBox.sendKeys("1-2");

            test.log(LogStatus.PASS, "Searching Specific Solicitation");
            WebElement docResult = driver.findElement(By.xpath("(//span[@class='text-primary'])[1]"));
            docResult.click();

            test.log(LogStatus.PASS, "Checking Search Results against URL");
            Thread.sleep(2000);
            String ActualTitle = driver.getCurrentUrl();
            String ExpectedTitle = "https://webprocure-stage.proactiscloud.com/" +
                    "BidReport/city/perfect?dc=1&nexturl=BidList&bid=117526&editSol=false";

            if (Objects.equals(ActualTitle, ExpectedTitle)) {
                System.out.println(",,,,,,,,,,,,,,,,,Formal Solicitaion search is passed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
                test.log(LogStatus.PASS, "Search Result >>>> Done");
            } else {
                System.out.println(",,,,,,,,,,,,,,,,,,Formal Solicitaion search is Not passed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
            }
            test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Passed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            test.log(LogStatus.INFO, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");
        }}

    @AfterMethod
    public void tearDown() {

//        driver.quit();
    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}