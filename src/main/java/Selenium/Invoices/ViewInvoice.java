package Selenium.Invoices;

import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class ViewInvoice extends DriverUtil{
    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("ViewInvoice");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void setUp() {

        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void viewInvoice() throws IOException, InterruptedException {
        viewInvoice(this.test, this.driver);
    }

    @Test
    public static void viewInvoice(ExtentTest test, WebDriver driver) throws InterruptedException, IOException {try {

        test.log(LogStatus.PASS, "Clicking on  Invoice Drop Down");
        WebElement invoiceDropDown = driver.findElement(By.xpath("//a[@title='Invoice']"));
        invoiceDropDown.click();

        test.log(LogStatus.PASS, "Clicking on  View All Invoice Link");
        WebElement invoiceviewAll = driver.findElement(By.xpath("(//a[@href='/POListing/city/perfect'])[1]"));
        invoiceviewAll.click();

        test.log(LogStatus.PASS, "Entering Buyer's Number");
        WebElement buyerNumber = driver.findElement(By.xpath("(//input[@id='binvoicenum'])[1]"));
        buyerNumber.sendKeys("IPCX2401783");

        test.log(LogStatus.PASS, "Clicking on Apply Button");
        Thread.sleep(2000);
        WebElement applyFilter = driver.findElement(By.xpath("(//button[normalize-space()='Apply Filter'])[1]"));
        applyFilter.click();

        test.log(LogStatus.PASS, "Clicking on Organization Drop Down");
        WebElement orgDropDown = driver.findElement(By.xpath("(//img[@id='arrow_1431'])[1]"));
        orgDropDown.click();

        test.log(LogStatus.PASS, "Scrolling Page using Java Script");
        Thread.sleep(2000);
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,500)", "");

        if (driver.findElement(By.xpath("(//table[@id='itemtable_1431'])[1]")).isDisplayed()){
            test.log(LogStatus.PASS, "Invoice Viewed");
            test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Passed");
            System.out.println(",,,,,,,,,,Test is Passed,,,,,,,,,,");
        }
        else {
            System.out.println(",,,,,,,,,,Test is Failed,,,,,,,,,,");
            test.log(LogStatus.FAIL, "Invoice Not Viewed");
            test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
        }} catch (InterruptedException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }finally {
        test.log(LogStatus.INFO, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");
    }}

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}