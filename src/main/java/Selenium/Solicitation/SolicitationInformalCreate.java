package Selenium.Solicitation;

import UtilMethods.CurrentDateTimeAndRandomNumber;
import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class SolicitationInformalCreate {
    static WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Solicitation Informal Create");
        test.log(LogStatus.PASS, ">>>Start>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException
    {

        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void solicitaionInFormalCreate() throws IOException, InterruptedException
    {
        solicitaionInFormalCreate(test, driver);
    }

    public static void solicitaionInFormalCreate(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
    {
        try
        {

        test.log(LogStatus.PASS, "Clicking on Solicitation Drop Down");
        WebElement solicitaionDropDown = driver.findElement(By.xpath("//a[@title='Solicitations']"));
        solicitaionDropDown.click();

        test.log(LogStatus.PASS, "Clicking on create link");
        WebElement create = driver.findElement(By.xpath("//a[@title='Create Informal Solicitation']"));
        create.click();

        test.log(LogStatus.PASS, "Giving title name");
        WebElement title = driver.findElement(By.name("bid_title"));
        title.clear();
        title.sendKeys("Automation");

        test.log(LogStatus.PASS, "Adding Solicitation Type- ITBOption");
        WebElement solicitationType = driver.findElement(By.xpath("(//select[@id='solType'])[1]"));
        solicitationType.click();
        WebElement ITBOption = driver.findElement(By.xpath("(//option[@value='29'])[1]"));
        ITBOption.click();

        test.log(LogStatus.PASS, "Clicking on whoCanSeeBid-EveryOne");
        WebElement whoCanSeeBid = driver.findElement(By.xpath("(//select[@id='bidInvitationType'])[1]"));
        whoCanSeeBid.click();
        WebElement whoCanSeeBidEveryOne = driver.findElement(By.xpath("(//option[normalize-space()='Everyone'])[1]"));
        whoCanSeeBidEveryOne.click();

        test.log(LogStatus.PASS, "Clicking on whoCanRespondBid-EveryOne");
        WebElement whoCanRespondBid = driver.findElement(By.xpath("//select[@id='bidRespondAccessType']"));
        whoCanRespondBid.click();
        WebElement whoCanRespondBidEveryOne = driver.findElement(By.xpath("//option[normalize-space()='All Vendors']"));
        whoCanRespondBidEveryOne.click();

        test.log(LogStatus.PASS, "Clicking on solicitation-Contact-Sukreet Sinha");
        WebElement solicitationContact  = driver.findElement(By.name("bid_contact"));
        solicitationContact.sendKeys("Sukreet Sinha");
        solicitationContact.findElement(By.xpath("//*[@id=\"ui-id-2\"]")).click();

        test.log(LogStatus.PASS, "Adding Date and Time(ETD)");
        WebElement startDate = driver.findElement(By.xpath("(//input[@id='solstartdatetime'])[1]"));
        startDate.clear();
        startDate.sendKeys(CurrentDateTimeAndRandomNumber.getCurrentTime());

        test.log(LogStatus.PASS, "Clicking on Header-NextButton");
        Thread.sleep(1000);
        WebElement nextStepButton1 = driver.findElement(By.xpath("//*[text()='Next Step']"));
        nextStepButton1.click();

        test.log(LogStatus.PASS, "Scrolling page using JavaScript");
        Thread.sleep(2000);
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,400)", "");

        test.log(LogStatus.PASS, "Clicking on Requirements-NextButton");
        WebElement nextStepButton2 = driver.findElement(By.xpath("//*[text()='Next Step']"));
        nextStepButton2.click();

        test.log(LogStatus.PASS, "Clicking on Questionnaire-NextButton");
        WebElement nextStepButton3 = driver.findElement(By.xpath("//*[text()='Next Step']"));
        nextStepButton3.click();

        test.log(LogStatus.PASS, "Clicking on Attachments-NextButton");
        WebElement nextStepButton4 = driver.findElement(By.xpath("//*[text()='Next Step']"));
        nextStepButton4.click();

        Thread.sleep(4000);
        WebElement button  = driver.findElement(By.xpath("//*[text()='00500']/../a"));
        new Actions(driver).moveToElement(button).click().build().perform();

        test.log(LogStatus.PASS, "Clicking on Quantity");
        Thread.sleep(1000);
        WebElement Quantity = driver.findElement(By.xpath("(//input[@name='addqty_580651'])[1]"));
        Quantity.sendKeys("20");

        test.log(LogStatus.PASS, "Scrolling Page");
        Thread.sleep(2000);
        JavascriptExecutor js6 = (JavascriptExecutor) driver;
        js6.executeScript("window.scrollBy(0,400)", "");

        test.log(LogStatus.PASS, "Adding Items");
        Thread.sleep(2000);
        WebElement addItems = driver.findElement(By.xpath("//button[normalize-space()='Add Items']"));
        addItems.click();

        test.log(LogStatus.PASS, "Clicking on Item Specs-NextButton");
        Thread.sleep(2000);
        WebElement nextStepButton5 = driver.findElement(By.xpath("//*[text()='Next Step']"));
        nextStepButton5.click();

        test.log(LogStatus.PASS, "Clicking on Check-All-Items");
        Thread.sleep(3000);
        WebElement checkAll = driver.findElement(By.xpath("//b[normalize-space()='[Check All]']"));
        checkAll.click();

        WebElement printSolNum = driver.findElement(By.xpath("//*[@id=\"page-title\"]/h3"));
        System.out.println(printSolNum.getText());
        test.log(LogStatus.PASS, "Printing Created Solicitation Number" + printSolNum.getText());

        test.log(LogStatus.PASS, "Clicking on Save-Selection");
        Thread.sleep(1000);
        WebElement saveSelecton = driver.findElement(By.xpath("//button[normalize-space()='Save Selections']"));
        saveSelecton.click();

        test.log(LogStatus.PASS, "Accepting Alert");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();

        test.log(LogStatus.PASS, "Scrolling Page");
        Thread.sleep(2000);
        JavascriptExecutor js7 = (JavascriptExecutor) driver;
        js7.executeScript("window.scrollBy(0,400)", "");

        test.log(LogStatus.PASS, "Clicking on Suppliers-NextButton");
        WebElement nextStepButton6 = driver.findElement(By.xpath("//*[text()='Next Step']"));
        nextStepButton6.click();

        test.log(LogStatus.PASS, "Scrolling Page");
        Thread.sleep(2000);
        JavascriptExecutor js8 = (JavascriptExecutor) driver;
        js8.executeScript("window.scrollBy(0,400)", "");

        test.log(LogStatus.PASS, "Clicking on Submit-Button");
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        submitButton.click();

        test.log(LogStatus.PASS, "Accepting Alert");
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();

        test.log(LogStatus.PASS, "Verifying By URL(Using if else condition)");
        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = ("https://webprocure-stage.proactiscloud.com/BidList/city/perfect?bt=2");

        if (!Objects.equals(ActualUrl, ExpectedUrl)){
            System.out.println("In-Formal Solicitaion Created,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
            test.log(LogStatus.PASS, "In-Formal Solicitaion Created");
        }
        else {
            System.out.println("In-Formal Solicitaion Not Created,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
        }

        Thread.sleep(1000);
        test.log(LogStatus.PASS, "Clicking on Close-Button");
        WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"sol-requirement-content\"]/div/div/div[2]/button"));
        closeButton.click();

        test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Passed- Please refer to the ScreenShot...!!");

        } catch (InterruptedException e) {
            e.printStackTrace();
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

