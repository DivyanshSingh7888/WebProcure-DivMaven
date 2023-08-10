package ExtentRepoetListners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;


public class BaseClassForExtentReportLogger
{

    WebDriver driver;
    private ExtentReports extent;

    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
    }

    @Test
    public void extentReportsDemo() throws IOException
    {
        try
        {
//        System.setProperty("webdriver.chrome.driver", "D:\\Div.files\\D.files\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.co.in");
//        if(driver.getTitle().equals("Google"))
//        {
//            test.log(LogStatus.PASS, "Navigated to the specified URL");
//        }
//        else
//        {
            test.log(LogStatus.FAIL, "Test Failed");
//        }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
