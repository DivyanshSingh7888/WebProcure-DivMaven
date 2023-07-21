package EndToEndScript;

import Selenium.Contracts.CreateContract;
import Selenium.Contracts.SearchContract;
import Selenium.GiveResponse.GiveResponseToSolicitation;
import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.jetbrains.annotations.Contract;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;

public class Contract_EndToEnd {

    static ExtentTest test;
    static WebDriver driver;

    @BeforeClass
    public static void startTest() {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Contract_EndToEnd");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void suitSetUp() {
        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test(description = "Creating Contract",priority = 1)
    public void CreateContract() throws IOException, InterruptedException {
        test.log(LogStatus.PASS, "Creating Contract");
        CreateContract.createContract(test, driver);
    }

    @Test(description = "Searching created Contract",priority = 2)
    public void SearchContract() throws IOException, InterruptedException {
        test.log(LogStatus.PASS, "Searching Contract");
        SearchContract.searchContract(test, driver);
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
