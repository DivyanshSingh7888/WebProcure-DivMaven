package Selenium.BidBoardSearch;

import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class SolicitationBidBoard
{
    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Solicitation Bid Board Search");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException
    {
        driver = DriverUtil.getBidBoardSolicitaionDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void contractBodBoard() throws IOException
    {
        try {

            test.log(LogStatus.PASS, "Entering Solicitation Number");
            WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/app-root/app-bid-board/app-bid-board-header/nav/div/div[1]/input"));
            searchBox.sendKeys("2460");

            Thread.sleep(2000);
            test.log(LogStatus.PASS, "Clicking on searched Solicitation");
            WebElement searchedContract = driver.findElement(By.xpath("/html/body/div[1]/app-root/app-bid-board/app-bid-board-result/div[2]/div/div[3]/ul/li/span/a"));
            searchedContract.click();

            Thread.sleep(1000);
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            test.log(LogStatus.INFO, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");
        }}

    @AfterMethod
    public void tearDown()
    {
        //driver.quit();
    }
    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
