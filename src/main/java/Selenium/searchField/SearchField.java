package Selenium.searchField;

import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SearchField {

    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("SearchField");
        test.log(LogStatus.PASS, ">>>Start>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException {

        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void searchField() throws IOException, InterruptedException {
        searchField(test, this.driver);
    }

    public void searchField(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
    {
        try {

            test.log(LogStatus.PASS, "Clicking and Searching result");
            WebElement SearchField = driver.findElement(By.xpath("//input[@id='crcSearchBox']"));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String keysToSend = "1-2";
            jsExecutor.executeScript("arguments[0].value = arguments[1];", SearchField, keysToSend);

            test.log(LogStatus.PASS, "Clicking on Search Button");
            WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
            searchButton.click();

            Thread.sleep(1000);
            test.log(LogStatus.PASS, "Clicking on Search Result");
            WebElement searchResult = driver.findElement(By.xpath("(//span[contains(text(),'REQUEST')])[1]"));
            searchResult.click();
            Thread.sleep(1000);

//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            WebElement OpenDoc = driver.findElement(By.xpath("//span[@class='highlight']"));
//            OpenDoc.click();

            test.log(LogStatus.PASS, "Asserting through URL");
            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "https://webprocure-stage.proactiscloud.com/ui/b/en/search/" +
                    "cross/result/details?link=https:%2F%2Fwebprocure-stage.proactiscloud.com%2Fwp-full-text" +
                    "-search%2Fsecure%2Fapi%2FdocCrossReferenceView%2Fdetails%2Frequest%2F1464&type=Request&id=1464&docNum=16" +
                    "-29%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20";

            if (actualUrl!=expectedUrl) {
                System.out.println("Test is Passed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
                test.log(LogStatus.PASS, "Search Result Viewed");
                Thread.sleep(1000);
                test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Passed");

            } else {
                System.out.println("Test is Failed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
                test.log(LogStatus.FAIL, "Search Result Not Viewed");
                test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
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