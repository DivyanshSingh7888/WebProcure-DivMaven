package Selenium.Contracts;

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
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class SearchContract
{
    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Search Contract");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException
    {

        driver = DriverUtil.getDriver();
    }

    @Test
    public void searchContract() throws IOException, InterruptedException
    {
        searchContract(test, this.driver);
    }

    public static void searchContract(ExtentTest test, WebDriver driver) throws IOException {try {

        test.log(LogStatus.PASS, "Clicking on Contract Drop Down");
        WebElement contractDropDown = driver.findElement(By.xpath("//a[@title='Contracts']"));
        contractDropDown.click();

        test.log(LogStatus.PASS, "Clicking on Contract search");
        WebElement contractSearch = driver.findElement(By.xpath("(//a[@href='/contract/search.do'])[1]"));
        contractSearch.click();

//        test.log(LogStatus.PASS, "Entering values to the Contract Search Box");
//        WebElement searchBox = driver.findElement(By.id("input-search-box"));
//        Thread.sleep(3000);
//        DriverUtil.ExplicitWait(searchBox);
//        searchBox.sendKeys("Test Div");


//        test.log(LogStatus.PASS, "Clicking on Contract Search Button");
//        WebElement searchButton = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
//        searchButton.click();

        test.log(LogStatus.PASS, "Clicking on Contract Search Results");
        Thread.sleep(3000);
        WebElement testDiv = driver.findElement(By.xpath("(//span[@class='text-primary'])[1]"));
        testDiv.click();

        test.log(LogStatus.PASS, "Asserting through URL");
        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = ("https://webprocure-stage.proactiscloud.com/ContractManagement/city/" +
                "perfect?contractID=1859&action=view&type=search");

        if (Objects.equals(ActualUrl, ExpectedUrl))
        {
            System.out.println(",,,,,,,,,,,,,,,,,,Test is Passed,,,,,,,,,,,,,,,,,");
            test.log(LogStatus.PASS, "Search Result Passed");

        } else {
            System.out.println(",,,,,,,,,,,Test is Failed,,,,,,,,,,,,,,,,,,,");
            test.log(LogStatus.PASS, "Search Result Failed");
        }
        test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");

    } catch (InterruptedException | IOException e) {
        throw new RuntimeException(e);
    } finally {
        test.log(LogStatus.INFO, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");
    }
    }

    @AfterMethod
    public void tearDown()
    {
        //driver.quit();
    }

    @AfterClass
    public static void endTest() {
        report.endTest(test);
        report.flush();
    }
}
