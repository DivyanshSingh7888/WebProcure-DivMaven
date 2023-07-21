package EndToEndScript;

import Selenium.GiveResponse.GiveResponseToSolicitation;
import Selenium.Solicitation.SolicitationInformalCreate;
import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;

public class CreateSolToResponse_EndToEnd
{

    static ExtentTest test;
    static WebDriver driver;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("CreateSolToResponse_EndToEnd");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod(description = "Opening Browser")
    public void suitSetUp()
    {
        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test(description = "Creating In-Formal Solicitation")
    public void informalSolicitation() throws IOException, InterruptedException
    {
        test.log(LogStatus.PASS, "Creating Formal Solicitation");
        SolicitationInformalCreate.solicitaionInFormalCreate(test, driver);
    }

    @Test(description = "Giving Response to the Created Solicitation",dependsOnMethods = "informalSolicitation")
    public void givingResponseToSolicitation() throws IOException, InterruptedException
    {
        Thread.sleep(5000);
        test.log(LogStatus.PASS, "Creating Formal Solicitation");
        GiveResponseToSolicitation.givingResponseToSolicitation(test, driver);
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
