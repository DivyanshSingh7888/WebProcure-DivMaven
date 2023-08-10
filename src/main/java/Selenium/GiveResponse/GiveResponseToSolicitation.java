package Selenium.GiveResponse;
import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.sql.SQLOutput;
import java.time.Duration;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class GiveResponseToSolicitation {

    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Response to Solicitation");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }


    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException {

        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void givingResponseToSolicitation() throws IOException, InterruptedException {
        givingResponseToSolicitation(test, this.driver);
    }

    public static <StaleElementException extends Throwable> void givingResponseToSolicitation(ExtentTest test, WebDriver driver) throws InterruptedException, IOException {try {

        test.log(LogStatus.PASS, "Clicking on Drop-Down");
        WebElement dropDown = driver.findElement(By.xpath("(//i[@class='fa fa-caret-down'])[1]"));
        dropDown.click();

        test.log(LogStatus.PASS, "Selecting IBC(Vendor)");
        WebElement selectIBC = driver.findElement(By.xpath("//a[normalize-space()='(IBC) Intelligent Business Concepts Inc.']"));
        selectIBC.click();

        try {
            Duration timeout = Duration.ofSeconds(5);
            new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Solicitations']")));
            driver.findElement(By.xpath("//a[normalize-space()='Solicitations']")).click();
        } catch (StaleElementReferenceException e) {
            driver.navigate().refresh();
            WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Solicitations']"));
            element.click();
        }

        test.log(LogStatus.PASS, "Clicking on View Current Solicitation");
        WebElement viewCurrentSolicitation = driver.findElement(By.xpath("(//a[@href='/Home/city/perfect']" +
                "[normalize-space()='View Current Solicitations'])[1]"));
        viewCurrentSolicitation.click();

        test.log(LogStatus.PASS, "Selecting Other Active Opportunities");
        WebElement otherActiveOpportunities = driver.findElement(By.xpath("(//a[normalize-space()" +
                "='Other Active Opportunities'])[1]"));
        otherActiveOpportunities.click();

//        test.log(LogStatus.PASS, "Searching Solicitation through Sol-Number");
//        WebElement filter_bidNumber = driver.findElement(By.name("filter_bidNumber"));
//        filter_bidNumber.sendKeys("10918");

//        test.log(LogStatus.PASS, "Clicking on Submit Button");
//        WebElement submit_Button = driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[1]"));
//        submit_Button.click();

        test.log(LogStatus.PASS, "Clicking on Add Response Link");
        WebElement addResponse = driver.findElement(By.xpath("(//b[contains(text(),'Add New Response')])[1]"));
        addResponse.click();

        test.log(LogStatus.PASS, "Clicking on Quate Name Pop-Up Button - Ok");
        WebElement quateNamePopUpOk = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        quateNamePopUpOk.click();

        test.log(LogStatus.PASS, "Clicking on Respond Link");
        WebElement respond = driver.findElement(By.xpath("(//a[normalize-space()='Respond'])[1]"));
        respond.click();

        test.log(LogStatus.PASS, "Scrolling page using JavaScript");
        Thread.sleep(1000);
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,400)", "");

        Thread.sleep(2000);
        test.log(LogStatus.PASS, "Sending Value to the USD");
        WebElement USD = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div[2]" +
                "/div/div/div/form/div[4]/div/div/div[2]/table/tbody/tr[1]/td[1]/div[1]/input"));
        USD.sendKeys("22");

        test.log(LogStatus.PASS, "Sending Value to the Supplier Part Number");
        WebElement supplierPartNumber = driver.findElement(By.xpath("/html/body/div[1]/section[2]" +
                "/div/div/div/div[2]/div/div/div/form/div[4]/div/div/div[2]/table/tbody/tr[1]/td[7]/input"));
        supplierPartNumber.sendKeys("87654324567");

        test.log(LogStatus.PASS, "Sending Value to the Supplier Part Number Ext");
        WebElement supplierPartNumExt = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div[2]" +
                "/div/div/div/form/div[4]/div/div/div[2]/table/tbody/tr[1]/td[8]/input"));
        supplierPartNumExt.sendKeys("234566454321");

        test.log(LogStatus.PASS, "Sending Value to the AF1");
        WebElement AF1 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div[2]/div/" +
                "div/div/form/div[4]/div/div/div[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/input[1]"));
        AF1.sendKeys("Enter Anything");

        test.log(LogStatus.PASS, "Sending Value to the AF2");
        WebElement AF2 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div[2]" +
                "/div/div/div/form/div[4]/div/div/div[2]/table/tbody/tr[4]/td/table/tbody/tr/td[4]/input[1]"));
        AF2.sendKeys("Enter Anything");

        test.log(LogStatus.PASS, "Clicking on Save Button");
        WebElement saveButton = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        saveButton.click();

        test.log(LogStatus.PASS, "Clicking on Review Respond");
        WebElement reviewRespond = driver.findElement(By.xpath("(//a[normalize-space()='Review Response'])[1]"));
        reviewRespond.click();

        test.log(LogStatus.PASS, "Clicking on Submit Button");
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        submitButton.click();

        if (driver.findElement(By.xpath("(//div[@class=' pull-left panel-title'])[1]")).isDisplayed()) {
            Thread.sleep(1000);
            System.out.println("Your bid has been submitted successfully. You will receive a confirmation email if you have notifications enabled");
            test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Your bid has been submitted successfully. " +
                    "You will receive a confirmation " +
                    "email if you have notifications enabled..!!");
        }else{
            test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed- Please refer to the ScreenShot...!!");
        }

        Thread.sleep(1000);
        test.log(LogStatus.PASS, "Clicking on Close Button");
        WebElement close_Button = driver.findElement(By.xpath("(//button[@onclick='javascript:Done();'])[1]"));
        close_Button.click();

    } catch (InterruptedException | IOException
            e) {
        throw new RuntimeException(e);
    } finally {
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