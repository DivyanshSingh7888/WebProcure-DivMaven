package Selenium.BidBoardSearch;

import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class ContractBidBoard
{
    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Contract Bid Board Search");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException
    {
        driver = DriverUtil.getContractBidBoardDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void contractBodBoard() throws IOException
    {
        try {

            test.log(LogStatus.PASS, "Entering Contract Number");
            WebElement searchBox = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/app-root[1]/contract-board[1]/contract-board-header[1]/nav[1]/div[1]/div[1]/div[1]/input[1]"));
            searchBox.sendKeys("901010");

            Thread.sleep(2000);
            test.log(LogStatus.PASS, "Clicking on searched Contract");
            WebElement searchedContract = driver.findElement(By.xpath("/html/body/div[1]/app-root/contract-board/contract-board-results/div/div/div[3]/div[5]/ul/li/span/a"));
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
