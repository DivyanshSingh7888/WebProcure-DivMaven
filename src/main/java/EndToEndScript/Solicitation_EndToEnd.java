package EndToEndScript;

import Selenium.Solicitation.SolicitaionSearch;
import Selenium.Solicitation.SolicitationFormalCreate;
import Selenium.Solicitation.SolicitationInformalCreate;
import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class Solicitation_EndToEnd
{
    static ExtentTest test;
    static WebDriver driver;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Solicitation_EndToEnd");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void suitSetUp()
    {
        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test(description = "Creating Formal Solicitation",priority = 1)
    public void formalSolicitation() throws IOException
    {
        test.log(LogStatus.PASS, "Creating Formal Solicitation");
        new SolicitationFormalCreate().solicitationFormalCreate(test, driver);
    }

    @Test(description = "Creating In-Formal Solicitation",priority = 2)
    public void informalSolicitation() throws IOException, InterruptedException
    {
        test.log(LogStatus.PASS, "Creating Formal Solicitation");
        SolicitationInformalCreate.solicitaionInFormalCreate(test, driver);
    }

    @Test(description = "Searching Created Solicitation",priority = 3)
    public void searchSolicitation() throws IOException, InterruptedException
    {
        test.log(LogStatus.PASS, "Creating Formal Solicitation");
        SolicitaionSearch.solicitationSearch(test, driver);
    }

    @AfterMethod
    public void tearDown()
    {
//        driver.quit();
    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
