package EndToEndScript;

import Selenium.Invoices.CreateInvoice;
import Selenium.Invoices.CreatePaymentVoucher;
import Selenium.Invoices.ViewInvoice;
import Selenium.Request.createRequests;
import Selenium.Request.viewAllRequest;
import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;

public class Request_EndToEnd
{

    static ExtentTest test;
    static WebDriver driver;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Request_EndToEnd");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void suitSetUp()
    {
        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test(description = "Creating Request",priority = 1)
    public void createRequests() throws IOException, InterruptedException
    {
        test.log(LogStatus.PASS, "Creating Request");
        createRequests.createRequest(test, driver);
    }

    @Test(description = "Searching Created Requests",priority = 2)
    public void viewAllRequest() throws IOException, InterruptedException
    {
        test.log(LogStatus.PASS, "Searching Created Invoices");
        viewAllRequest.viewAllReq(test, driver);
    }

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
