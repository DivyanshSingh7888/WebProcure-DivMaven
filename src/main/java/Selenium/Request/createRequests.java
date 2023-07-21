package Selenium.Request;

import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class createRequests {
    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("createRequests");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException {

        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void createRequest() throws IOException, InterruptedException {
        createRequest(this.test, this.driver);
    }

    @Test
    public static void createRequest(ExtentTest test, WebDriver driver) throws InterruptedException, IOException {try {

        test.log(LogStatus.PASS, "Clicking on Request Drop Down");
        WebElement requestDropDown = driver.findElement(By.xpath("//a[normalize-space()='Request']"));
        requestDropDown.click();

        test.log(LogStatus.PASS, "Clicking on Create New Link");
        WebElement createNew = driver.findElement(By.xpath("//a[contains(@title,'Create new')]"));
        createNew.click();

        test.log(LogStatus.PASS, "Switching Frame");
        driver.switchTo().frame("C1ReqMain");
        test.log(LogStatus.PASS, "Clicking on Off Catalog Request");
        WebElement offCatalogRequest = driver.findElement(By.xpath("//a[@id='idOff-Catalog Request']"));
        offCatalogRequest.click();

        test.log(LogStatus.PASS, "Switching Frame");
        driver.switchTo().frame("C1ReqMain");
        test.log(LogStatus.PASS, "Entering Quantity");
        WebElement quantity = driver.findElement(By.xpath("//input[@id='OrderQty']"));
        quantity.sendKeys("20000");

        test.log(LogStatus.PASS, "Entering Unit Price");
        WebElement unitPrice = driver.findElement(By.xpath("//input[@id='UnitPrice']"));
        unitPrice.sendKeys("2000");

        test.log(LogStatus.PASS, "Entering Supplier Part Number");
        WebElement supplierPartNumber = driver.findElement(By.xpath("//input[@id='SupplierPartNum']"));
        supplierPartNumber.sendKeys("Random Integers: " + ThreadLocalRandom.current().nextInt());

        test.log(LogStatus.PASS, "Clicking on Contract Number");
        WebElement contractNumber = driver.findElement(By.xpath("//label[@class='btn btn-success btn-xs toggle-on']"));
        contractNumber.click();

        test.log(LogStatus.PASS, "Searching Suggested Vendor");
        WebElement suggestedVendor = driver.findElement(By.xpath("//input[@id='input_SupplierName']"));
        suggestedVendor.sendKeys("**");

        test.log(LogStatus.PASS, "Selecting Suggested Vendor");
        WebElement suggestedVendorSelect = driver.findElement(By.cssSelector("#ui-id-2"));
        suggestedVendorSelect.click();

        test.log(LogStatus.PASS, "Entering Service Or Commodity Code");
        WebElement serviceOrCommodityCode = driver.findElement(By.xpath(" //input[@id='input_catcode']"));
        serviceOrCommodityCode.sendKeys("**");

        test.log(LogStatus.PASS, "Clicking on Service Or Commodity Code Select");
        WebElement serviceOrCommodityCodeSelect = driver.findElement(By.xpath("//div[contains(text(),'82006  (A.S.M.E. Code Tanks)')]"));
        serviceOrCommodityCodeSelect.click();

        test.log(LogStatus.PASS, "Clicking on Add Button");
        WebElement add = driver.findElement(By.xpath("//button[@id='btn-add-top']"));
        add.click();

        try {
            test.log(LogStatus.PASS, "Enabling Retain Key Info");
            WebElement retainKeyInfo = driver.findElement(By.xpath("//input[@id='chk-retain-top']"));
            retainKeyInfo.isEnabled();
        } catch (Exception e) {
            System.out.println("Alraedy disabled");
            throw new RuntimeException(e);
        }

        test.log(LogStatus.PASS, "Coming back to the Parent Frame");
        driver.switchTo().defaultContent();

        test.log(LogStatus.PASS, "Switching Frame");
        driver.switchTo().frame("C1ReqMain");

        test.log(LogStatus.PASS, "Clicking on View Request");
        Thread.sleep(5000);
        WebElement viewRequest = driver.findElement(By.xpath("//a[@id='idView Request']"));
        viewRequest.click();

        test.log(LogStatus.PASS, "Switching Frame");
        driver.switchTo().frame("C1ReqMain");
        test.log(LogStatus.PASS, "Clicking on Assign Account");
        WebElement assignAccount = driver.findElement(By.xpath("//img[@title='Assign Account Distribution']"));
        assignAccount.click();

        Thread.sleep(3000);
        test.log(LogStatus.PASS, "Coming back to the Parent Frame");
        driver.switchTo().defaultContent();

        test.log(LogStatus.PASS, "Switching Frame");
        driver.switchTo().frame("C1ReqMain");
        test.log(LogStatus.PASS, "Clicking on Distribute Evenly");
        WebElement distributeEvenly = driver.findElement(By.name("DistributeEvenly"));
        distributeEvenly.click();

        test.log(LogStatus.PASS, "Clicking on Save Button");
        WebElement saveButton = driver.findElement(By.xpath("//button[@name='btnSubmit']"));
        saveButton.click();

        test.log(LogStatus.PASS, "Coming back to the Parent Frame");
        driver.switchTo().defaultContent();

        test.log(LogStatus.PASS, "Switching Frame");
        driver.switchTo().frame("C1ReqMain");
        test.log(LogStatus.PASS, "Clicking on Submit Button");
        WebElement submitRequest = driver.findElement(By.xpath("//button[@title='Submit Request']"));
        submitRequest.click();

        if (driver.findElement(By.xpath("//div[text()='Request successfully submitted.']")).isDisplayed()) {
            System.out.println(",,,,,,,,,,,,,,,,,,Test is Passed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
            test.log(LogStatus.PASS, "Request Created");
            Thread.sleep(1000);
            test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Passed");
        } else {
            System.out.println(",,,,,,,,,,,,,,,,,Test is Failed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
            test.log(LogStatus.FAIL, "Request Not Created");
            test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
        }
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
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
