package Selenium.Contracts;

import UtilMethods.CurrentDateTimeAndRandomNumber;
import UtilMethods.DriverUtil;
import UtilMethods.SwitchingWindows;
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
import java.util.Set;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

//import static Selenium.Solicitation.SolicitaionFormalCreate.wait;

public class CreateContract {

    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("CreateContract");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException
    {
        driver = DriverUtil.getDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void createContract() throws IOException, InterruptedException
    {
        createContract(test, this.driver);
    }

    public static void createContract(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
    {try
    {

        test.log(LogStatus.PASS, "Clicking on Contract Create Drop Down");
        WebElement contractDropDown = driver.findElement(By.xpath("//a[@title='Contracts']"));
        contractDropDown.click();

        test.log(LogStatus.PASS, "Clicking on Contract Create Link");
        WebElement contractCreateLink = driver.findElement(By.xpath("//a[@title='Create new Contract']"));
        contractCreateLink.click();

        test.log(LogStatus.PASS, "Clicking on Contract Type");
        WebElement contractType = driver.findElement(By.xpath("//select[@id='contractType']"));
        contractType.click();

        test.log(LogStatus.PASS, "Clicking on Contract Type- Option Test");
        WebElement contractTypeOptionTest = driver.findElement(By.xpath("//option[@value='14']"));
        contractTypeOptionTest.click();

        test.log(LogStatus.PASS, "Clicking on Contract Visibility");
        WebElement contractVisibility = driver.findElement(By.xpath("//option[@value='Public']"));
        contractVisibility.click();

        test.log(LogStatus.PASS, "Clicking on Pop-Up");
        Thread.sleep(2000);
        WebElement popUp = driver.findElement(By.xpath("//span[@title='Close']"));
        popUp.click();

        test.log(LogStatus.PASS, "Entering Title of Contract");
        WebElement title = driver.findElement(By.xpath("//input[@id='title']"));
        title.sendKeys("Automation");

        test.log(LogStatus.PASS, "Selecting Commodities");
        WebElement commodities = driver.findElement(By.xpath("//button[@id='selectCatButton']"));
        commodities.click();

        test.log(LogStatus.PASS, "Selecting Commodities- ABRASIVES");
        Thread.sleep(1000);
        WebElement search1 = driver.findElement(By.id("searchTxt"));
        search1.sendKeys("ABRASIVES");

        test.log(LogStatus.PASS, "Clicking on Search Link");
        Thread.sleep(2000);
        WebElement searchClick = driver.findElement(By.xpath("//button[@id='searchCats']"));
        searchClick.click();

        test.log(LogStatus.PASS, "Clicking on ABRASIVES Check Box");
        Thread.sleep(3000);
        WebElement ABRASIVESCheckBox = driver.findElement(By.xpath("(//span[@class='fancytree-checkbox fa fa-square-o'])[1]"));
        ABRASIVESCheckBox.click();

        test.log(LogStatus.PASS, "Clicking on Close Button");
        WebElement close = driver.findElement(By.xpath("//button[@class='btn btn-wp'][normalize-space()='Close']"));
        close.click();

        test.log(LogStatus.PASS, "Clicking on Search Contractor");
        WebElement searchContractor = driver.findElement(By.xpath("//button[@id='contractbtnslt']"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", searchContractor);

        test.log(LogStatus.PASS, "Switching Window to select supplier");
        driver.switchTo().window("supplier");
        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"sname_action\"]"));
        searchBox.sendKeys("**");

        test.log(LogStatus.PASS, "Clicking on Search Button");
        WebElement searchButton = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
        searchButton.click();

        test.log(LogStatus.PASS, "Selecting Action Check Box");
        WebElement actionCheckBox = driver.findElement(By.xpath("(//img[@title='Check Mark Selected'])[2]"));
        actionCheckBox.click();
        test.log(LogStatus.PASS, "Coming to the Parent Window");
        driver.switchTo().window("");

        test.log(LogStatus.PASS, "Scrolling Page using Java Executor");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        test.log(LogStatus.PASS, "Selecting Pricing Drop Down");
        WebElement pricingTypeDropDown = driver.findElement(By.xpath("//select[@id='contractPricingType']"));
        pricingTypeDropDown.click();

        test.log(LogStatus.PASS, "Selecting Pricing Drop Down- No Limit");
        Thread.sleep(2000);
        WebElement pricingTypeDropDownNoLimit = driver.findElement(By.xpath("(//option[@value='No Limit']" +
                "[normalize-space()='No Limit'])[1]"));
        pricingTypeDropDownNoLimit.click();

        test.log(LogStatus.PASS, "Selecting Total Value Condition");
        WebElement totalValueCondition = driver.findElement(By.xpath("//select[@id='tempcontractTotalValueCondition']"));
        totalValueCondition.click();

        test.log(LogStatus.PASS, "Selecting Total Value Condition- Estimate");
        WebElement totalValueConditionEstimate = driver.findElement(By.xpath("//option[@value='Estimate']"));
        totalValueConditionEstimate.click();

        test.log(LogStatus.PASS, "Entering Issue Date");
        WebElement issueDate = driver.findElement(By.xpath("//input[@id='issue_date']"));
        issueDate.clear();
        issueDate.sendKeys(CurrentDateTimeAndRandomNumber.getCurruentDate());

        test.log(LogStatus.PASS, "Entering Award Date");
        WebElement awardDate = driver.findElement(By.xpath("//input[@id='award_date']"));
        awardDate.clear();
        awardDate.sendKeys(CurrentDateTimeAndRandomNumber.getCurruentDate());

        test.log(LogStatus.PASS, "Entering Effective Date");
        WebElement effectiveDate= driver.findElement(By.xpath("//input[@id='effective_date']"));
        effectiveDate.clear();
        effectiveDate.sendKeys(CurrentDateTimeAndRandomNumber.getCurruentDate());

        test.log(LogStatus.PASS, "Entering Expiry Date");
        WebElement expDate= driver.findElement(By.xpath("//input[@id='expiry_date']"));
        expDate.clear();
        expDate.sendKeys(CurrentDateTimeAndRandomNumber.addedMonths());

        test.log(LogStatus.PASS, "Clicking on Next Step- Header");
        WebElement nextStep1 = driver.findElement(By.xpath("//button[normalize-space()='Next Step']"));
        nextStep1.click();

        test.log(LogStatus.PASS, "Scrolling page");
        Thread.sleep(1000);
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,400)", "");

        test.log(LogStatus.PASS, "Clicking on Next Step- Notifications");
        WebElement nextStep2 = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
        nextStep2.click();

        test.log(LogStatus.PASS, "Clicking on Next Step- Contract Clauses");
        WebElement nextStep3 = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
        nextStep3.click();

        test.log(LogStatus.PASS, "Clicking on Next Step- Catalog Items");
        WebElement nextStep4 = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
        nextStep4.click();

        test.log(LogStatus.PASS, "Clicking on Add Document Library");
        WebElement addDocumentFromLibrary = driver.findElement(By.xpath("(//button[normalize-space()='Add Documents From Library'])[1]"));
        addDocumentFromLibrary.click();

        SwitchingWindows.switchCurrentwindow(driver);

        test.log(LogStatus.PASS, "Selecting Document");
        WebElement docCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        docCheckBox.click();

        test.log(LogStatus.PASS, "Scrolling page");
        Thread.sleep(1000);
        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,400)", "");

        test.log(LogStatus.PASS, "Selecting Document");
        WebElement saveButton = driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]"));
        saveButton.click();

        Thread.sleep(1000);
        test.log(LogStatus.PASS, "Clicking on Next Step- Attachments");
        WebElement nextStep5 = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
        nextStep5.click();

        test.log(LogStatus.PASS, "Clicking on Authorized To Use Contract");
        WebElement authorizedToUseContract = driver.findElement(By.xpath("//input[@id='2']"));
        authorizedToUseContract.click();

        test.log(LogStatus.PASS, "Scrolling Page");
        Thread.sleep(2000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,500)", "");

        test.log(LogStatus.PASS, "Clicking on Finished Button");
        WebElement finished = driver.findElement(By.xpath("//button[normalize-space()='Finished']"));
        finished.click();

        test.log(LogStatus.PASS, "Scrolling Page");
        Thread.sleep(2000);
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,500)", "");

        test.log(LogStatus.PASS, "Clicking on Submit Button");
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        submitButton.click();

        test.log(LogStatus.PASS, "Asserting through URL");
        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = ("https://webprocure-stage.proactiscloud.com/ContractManagement/city/perfect?action=main");

        if (Objects.equals(ActualUrl, ExpectedUrl))
        {
            System.out.println(",,,,,,,,,,,,,,,,,,Test is Passed,,,,,,,,,,,,,,,,,");
            test.log(LogStatus.PASS, "Contract Created>>>");
            test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Passed");
        } else {
            System.out.println(",,,,,,,,,,,Test is Failed,,,,,,,,,,,,,,,,,,,");
            test.log(LogStatus.FAIL, "Contract Not Created>>>");
            test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
        }
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
        }finally {
        test.log(LogStatus.INFO, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");
    }}

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
