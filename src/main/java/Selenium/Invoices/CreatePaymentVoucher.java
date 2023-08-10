package Selenium.Invoices;

import UtilMethods.CurrentDateTimeAndRandomNumber;
import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class CreatePaymentVoucher {

    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("CreatePaymentVoucher");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException {

        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, ">>Logged In>>");
    }

    @Test
    public void createPaymentVoucher() throws IOException, InterruptedException {
        createPaymentVoucher(test, this.driver);
    }

    public static void createPaymentVoucher(@NotNull ExtentTest test, @NotNull WebDriver driver) throws IOException {try {

        test.log(LogStatus.PASS, "Clicking on Invoice Drop Down");
        WebElement invoiceDropDown = driver.findElement(By.xpath("//a[@title='Invoice']"));
        invoiceDropDown.click();

        test.log(LogStatus.PASS, "Clicking on Create Payment Voucher");
        WebElement createPaymentVoucher = driver.findElement(By.xpath("//a[@title='Create Payment Voucher']"));
        Actions actions = new Actions(driver);
        actions.click(createPaymentVoucher).perform();

        WebElement selectFrame = driver.findElement(By.xpath("(//div)[56]"));
        selectFrame.click();

        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)", "");

        test.log(LogStatus.PASS, "Selecting Supplier");
        WebElement supplier = driver.findElement(By.xpath("(//input[@placeholder='No supplier selected'])[1]"));
        supplier.sendKeys("**");

        test.log(LogStatus.PASS, "Clicking on Supplier Select Link");
        Thread.sleep(2000);
        WebElement supplierSelect = driver.findElement(By.xpath("(//span[normalize-space()='Shea notification-3-22-13'])[1]"));
        actions.click(supplierSelect).perform();

        test.log(LogStatus.PASS, "Clicking on EFT- Indicator");
        WebElement EFTIndicator = driver.findElement(By.xpath("/html/body/b-root/div/wp-payment-voucher/div/wp-create/div" +
                "/div[2]/div[3]/div[2]/ngx-select-dropdown/div/button/span[2]"));
        EFTIndicator.click();

        test.log(LogStatus.PASS, "Clicking on EFT- Indicator- Yes");
        WebElement EFTIndicatorYesOrNo = driver.findElement(By.xpath("(//li[normalize-space()='Yes'])[1]"));
        EFTIndicatorYesOrNo.click();

        test.log(LogStatus.PASS, "Entering Received Date");
        WebElement enterReceiveDate = driver.findElement(By.xpath("//input[@placeholder='Enter Receive Date']"));
        enterReceiveDate.sendKeys(CurrentDateTimeAndRandomNumber.getCurruentDate());

        test.log(LogStatus.PASS, "Entering Post Date");
        WebElement enterPostDate = driver.findElement(By.xpath("//input[@placeholder='Enter Post Date']"));
        enterPostDate.sendKeys(CurrentDateTimeAndRandomNumber.getCurruentDate());

        test.log(LogStatus.PASS, "Entering Issue Date");
        WebElement enterIssueDate = driver.findElement(By.xpath("//input[@placeholder='Enter Issue Date']"));
        enterIssueDate.sendKeys(CurrentDateTimeAndRandomNumber.getCurruentDate());

        test.log(LogStatus.PASS, "Entering Due Date");
        WebElement enterDueDate = driver.findElement(By.xpath("//input[@placeholder='Enter Due Date']"));
        enterDueDate.sendKeys(CurrentDateTimeAndRandomNumber.addedMonths());

        test.log(LogStatus.PASS, "Clicking on Add Line Items");
        WebElement addLineItems = driver.findElement(By.xpath("(//button[normalize-space()='Add Items'])[1]"));
        addLineItems.click();

        test.log(LogStatus.PASS, "Clicking on Contract- Yes/No");
        WebElement contractYesOrNo = driver.findElement(By.xpath("(//label[normalize-space()='No/Yes'])[1]"));
        contractYesOrNo.click();

        test.log(LogStatus.PASS, "Entering Commodity Code");
        WebElement enterCommodityCode = driver.findElement(By.xpath("(//input[@placeholder='Enter Commodity Code or Key'])[1]"));
        enterCommodityCode.sendKeys("00500");

        test.log(LogStatus.PASS, "Entering Commodity Code- Selected");
        Thread.sleep(2000);
        WebElement enterCommodityCodeSelect = driver.findElement(By.xpath("//tr[@class='ng-star-inserted']//input[@type='checkbox']"));
        enterCommodityCodeSelect.click();

        test.log(LogStatus.PASS, "Clicking on Done Button");
        WebElement doneButton = driver.findElement(By.xpath("(//button[normalize-space()='Done'])[1]"));
        doneButton.click();

        test.log(LogStatus.PASS, "Scrolling Page using Java Script");
        Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,250)", "");

        test.log(LogStatus.PASS, "Clicking on Supplier Invoice Link");
        WebElement supplierInvoiceNoFrame = driver.findElement(By.xpath("(//div)[106]"));
        supplierInvoiceNoFrame.click();

        test.log(LogStatus.PASS, "Entering Supplier Invoice Number");
        Thread.sleep(2000);
        WebElement supplierInvoiceNo = driver.findElement(By.xpath("//*[text()=' Supplier Invoice No.']/../div/input"));
        supplierInvoiceNo.sendKeys("Invoice" + ThreadLocalRandom.current().nextInt(1000));

        test.log(LogStatus.PASS, "Selecting Quantity");
        WebElement quantity = driver.findElement(By.xpath("//input[@placeholder='Enter Quantity']"));
        quantity.sendKeys("" + ThreadLocalRandom.current().nextInt(10));

        test.log(LogStatus.PASS, "Selecting Unit Price USD");
        WebElement unitPriceUSD = driver.findElement(By.xpath("//input[@placeholder='Enter Unit Price']"));
        unitPriceUSD.sendKeys("" + ThreadLocalRandom.current().nextInt(10));

        test.log(LogStatus.PASS, "Clicking on Unit Drop Down");
        WebElement unitDropDown  = driver.findElement(By.xpath("(//span[@class='nsdicon-angle-down'])[4]"));
        unitDropDown.click();

        test.log(LogStatus.PASS, "Clicking on Unit Drop Down Select Link");
        WebElement unitDropDownSelect  = driver.findElement(By.xpath("//li[normalize-space()='11-outfit']"));
        unitDropDownSelect.click();

        test.log(LogStatus.PASS, "Clicking on Add Distribution");
        WebElement addDistribution = driver.findElement(By.xpath("//button[normalize-space()='Add Account Distribution']"));
        addDistribution.click();

        test.log(LogStatus.PASS, "Selecting Enter Cost Center- H602211");
        Thread.sleep(1000);
        WebElement enterCostCenter = driver.findElement(By.xpath("//input[@placeholder='Enter Cost Center']"));
        enterCostCenter.sendKeys("H602211");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='supplier-text']")).click();

        test.log(LogStatus.PASS, "Clicking on Distribute Evenly Link");
        WebElement distributeEvenly = driver.findElement(By.xpath("//button[normalize-space()='Distribute Evenly']"));
        distributeEvenly.click();

        test.log(LogStatus.PASS, "Clicking on Save Button");
        WebElement saveButton = driver.findElement(By.xpath("(//button[@class='btn btn-wp'][normalize-space()='Save'])[2]"));
        saveButton.click();

        test.log(LogStatus.PASS, "Scrolling Page using Java Script");
        Thread.sleep(1000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,400)", "");

        test.log(LogStatus.PASS, "Clicking on Submit Button");
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", submitButton);

        test.log(LogStatus.PASS, "Asserting through URL");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = ("https://webprocure-stage.proactiscloud.com/POListing//city/perfect");

        if (!Objects.equals(actualUrl, expectedUrl))
        {
            System.out.println(",,,,,,,,,,,,,,,,,,Test is Passed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
            test.log(LogStatus.PASS, "Payment Voucher Craeted");
            test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Passed");
        } else {
            System.out.println(",,,,,,,,,,,,,,,,,,Test is Failed,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
            test.log(LogStatus.FAIL, "Payment Voucher Not Craeted");
            test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
        }
    } catch (InterruptedException | IOException e) {
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
