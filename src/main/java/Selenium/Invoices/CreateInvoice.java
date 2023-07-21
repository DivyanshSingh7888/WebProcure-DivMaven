package Selenium.Invoices;

import UtilMethods.CurrentDateTimeAndRandomNumber;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class CreateInvoice {

    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Create-Invoice");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @Test
    public void createInvoice() throws IOException, InterruptedException {
        createInvoice(this.test, this.driver);
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException {
        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    public static void createInvoice(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
    {
        try {

            test.log(LogStatus.PASS, "Clicking on Invoice Drop Down");
            WebElement invoiceDropDown = driver.findElement(By.xpath("//a[@title='Invoice']"));
            invoiceDropDown.click();

            test.log(LogStatus.PASS, "Clicking on Invoice Create Link");
            WebElement invoiceCreateDropDown = driver.findElement(By.xpath("//a[@title='Create New']"));
            invoiceCreateDropDown.click();

            test.log(LogStatus.PASS, "Clicking on Supplier");
            WebElement supplier = driver.findElement(By.xpath("//input[@id='autocomplete_supplierSrch']"));
            supplier.sendKeys("**");

            test.log(LogStatus.PASS, "Supplier Selected- IBC");
            Thread.sleep(2000);
            WebElement supplierIBC = driver.findElement(By.xpath("//div[@id='ui-id-3']"));
            supplierIBC.click();

            test.log(LogStatus.PASS, "Entering Random Supplier Invoice Number");
            WebElement supplierInvoiceNo = driver.findElement(By.xpath("//input[@id='invoicenum']"));
            supplierInvoiceNo.sendKeys(CurrentDateTimeAndRandomNumber.getRandomNumber());

            test.log(LogStatus.PASS, "Entering Receive Date");
            WebElement receiveDate = driver.findElement(By.xpath("//input[@id='receive_date']"));
            receiveDate.sendKeys(CurrentDateTimeAndRandomNumber.getCurruentDate());

            test.log(LogStatus.PASS, "Entering Post Date");
            WebElement postDate = driver.findElement(By.xpath("//input[@id='post_date']"));
            postDate.sendKeys(CurrentDateTimeAndRandomNumber.getCurruentDate());

            test.log(LogStatus.PASS, "Entering Issue Date");
            WebElement issueDate = driver.findElement(By.xpath("//input[@id='issue_date']"));
            issueDate.sendKeys(CurrentDateTimeAndRandomNumber.getCurruentDate());

            test.log(LogStatus.PASS, "Selecting Indicator- EFT - Yes");
            WebElement IndicatorEFT = driver.findElement(By.xpath("//select[@id='eft']"));
            IndicatorEFT.click();

            WebElement IndicatorEFTYes = driver.findElement(By.xpath("//option[@value='Yes']"));
            IndicatorEFTYes.click();

            test.log(LogStatus.PASS, "Clicking on Next Step- Header");
            WebElement nextStep = driver.findElement(By.xpath("//button[normalize-space()='Next Step']"));
            nextStep.click();

            test.log(LogStatus.PASS, "Clicking on Find PO Items");
            WebElement findPOItems = driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Find PO Items'])[1]"));
            findPOItems.click();

            test.log(LogStatus.PASS, "Switching Frame to add PO Items ");
            WebElement iframe = driver.findElement(By.xpath("(//iframe)[1]"));
            driver.switchTo().frame(iframe);

            test.log(LogStatus.PASS, "Clicking on Find PO Link");
            Thread.sleep(1000);
            WebElement findPOItemsLink = driver.findElement(By.xpath("(//i[@class='fa fa-caret-right fa-fw hand-pointer'])[1]"));
            findPOItemsLink.click();

            test.log(LogStatus.PASS, "Clicking on Line Number");
            Thread.sleep(1000);
            WebElement lineNumber = driver.findElement(By.xpath("(//input[@name='polines'])[1]"));
            lineNumber.click();

            test.log(LogStatus.PASS, "Clicking on Add PO Items");
            Thread.sleep(1000);
            WebElement addPOItems = driver.findElement(By.xpath("(//button[normalize-space()='Add PO Items'])[1]"));
            addPOItems.click();
            test.log(LogStatus.PASS, "PO Selected - Back to the parent Frame");
            driver.switchTo().parentFrame();

            test.log(LogStatus.PASS, "Invoice Quantity Added");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("document.getElementById('invoiceQty_1199_1').setAttribute('value', '20')");
            jse.executeScript("document.getElementById('invoiceUnitPrice_1199_1').setAttribute('value', '33')");

            test.log(LogStatus.PASS, "Clicking on Line Details");
            WebElement lineDetails = driver.findElement(By.xpath("//*[text()='Line Details']"));
            lineDetails.click();

            test.log(LogStatus.PASS, "Clicking on Next Button- Invoice Items");
            Thread.sleep(2000);
            WebElement nextStep1 = driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Next'])[2]"));
            nextStep1.click();

            test.log(LogStatus.PASS, "Clicking on Next Button- Attachments");
            WebElement nextStep2 = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
            nextStep2.click();

            test.log(LogStatus.PASS, "Clicking on Next Button- Invoice Matching");
            WebElement nextStep3 = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
            nextStep3.click();

            test.log(LogStatus.PASS, "Clicking on Submit Button");
            WebElement submitButton = driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Submit'])[1]"));
            submitButton.click();

            try {
                test.log(LogStatus.PASS, "Clicking on Pop-Up");
                WebElement popUp = driver.findElement(By.xpath("//button[text()='Yes']"));
                popUp.click();
            } catch (Exception e) {
                System.out.println("PopUp is not there");
                throw new RuntimeException(e);
            }

            test.log(LogStatus.PASS, "Asserting through URL");
            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = ("https://webprocure-stage.proactiscloud.com/POListing?invoiceTab=inv");

            if (Objects.equals(actualUrl, expectedUrl))
            {
                System.out.println(",,,,,,,,,,,,,,,,,,Test is Passed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
                test.log(LogStatus.PASS, "Invoice Created");
                test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Passed");
            } else
            {
                System.out.println(",,,,,,,,,,,,,,,,,,Test is Failed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
                test.log(LogStatus.FAIL, "Invoice Not Created");
                test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
            }
        } catch (RuntimeException | IOException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            test.log(LogStatus.INFO, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");
        }
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