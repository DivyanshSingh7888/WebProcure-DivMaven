package EndToEndScript;

import Selenium.Contracts.CreateContract;
import Selenium.Contracts.SearchContract;
import Selenium.Invoices.CreateInvoice;
import Selenium.Invoices.CreatePaymentVoucher;
import Selenium.Invoices.ViewInvoice;
import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;

public class Invoices_EndToEnd
{

    static ExtentTest test;
    static WebDriver driver;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Invoice_EndToEnd");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void suitSetUp()
    {
        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, ">>Logged In>>");
    }

    @Test(description = "Creating Invoice",priority = 1)
    public void CreateInvoice() throws IOException, InterruptedException
    {
        test.log(LogStatus.PASS, "Creating Invoice");
        CreateInvoice.createInvoice(test, driver);
    }

    @Test(description = "Creating Payment Voucher",dependsOnMethods = "CreateInvoice")
    public void CreatePaymentVoucher() throws IOException, InterruptedException
    {
        test.log(LogStatus.PASS, "Creating Payment Voucher");
        CreatePaymentVoucher.createPaymentVoucher(test, driver);
    }

    @Test(description = "Searching Created Invoices",dependsOnMethods = {"CreateInvoice","CreatePaymentVoucher"})
    public void ViewInvoice() throws IOException, InterruptedException
    {
        test.log(LogStatus.PASS, "Searching Created Invoices");
        ViewInvoice.viewInvoice(test, driver);
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