package VenderRegistration;

import UtilMethods.DriverUtil;
import UtilMethods.SwitchingWindows;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class V_Registration
{
    WebDriver driver;
    static ExtentTest test;
    NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Vender-Registration");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException
    {
        driver = DriverUtil.getNGWebDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

//    @Test
//    public void venderRegistration() throws IOException, InterruptedException
//    {
//        venderRegistration(this.test, this.driver); ExtentTest test, WebDriver driver
//    }

    @Test
    public void venderRegistration() throws IOException
    {
        try {
            test.log(LogStatus.PASS, "Clicking on 'Open Level-2 Administration'");
            WebElement openL2 = driver.findElement(ByAngular.model("//a[normalize-space()='Open Level-2 Administration']"));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", openL2);

            test.log(LogStatus.PASS, "Clicking on Continue to 'Open Level-2 Administration'");
            WebElement continueToL2 = driver.findElement(ByAngular.model("//button[normalize-space()='Continue to L2 Administration']"));
            continueToL2.click();

            test.log(LogStatus.PASS, "Clicking on Form Builder");
            WebElement formBuilder = driver.findElement(ByAngular.model(".dropdown-toggle"));
            jsExecutor.executeScript("arguments[0].click();", formBuilder);

            test.log(LogStatus.PASS, "Clicking on Start Form Builder");
            WebElement startFormBuilder = driver.findElement(ByAngular.model("//button[normalize-space()='Start Form Builder']"));
            startFormBuilder.click();

            test.log(LogStatus.PASS, "Selecting Automation");
            WebElement unionPublicSchools = driver.findElement(ByAngular.model("//a[normalize-space()='Automation']"));
            unionPublicSchools.click();

            test.log(LogStatus.PASS, "Clicking on View");
            WebElement viewUnionPublicSchools = driver.findElement(ByAngular.model("(//a[@class='btn btn-link btn-sm'][normalize-space()='View'])[1]"));
            viewUnionPublicSchools.click();

            SwitchingWindows.switchCurrentwindow(driver);

            test.log(LogStatus.PASS, "Scrolling page using Java Script");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,400)", "");

            test.log(LogStatus.PASS, "Enabling 'Yes' in Instructions page");
            WebElement enableYes = driver.findElement(ByAngular.model("(//select[@id='fbeba68a-87c8-9d22-1907-fa289a52c1ec'])[1]"));
            enableYes.click();

            test.log(LogStatus.PASS, "Clicking on Next Button-Instructions page");
            WebElement nextButton = driver.findElement(ByAngular.model("(//button[normalize-space()='Next'])[1]"));
            nextButton.click();

            test.log(LogStatus.PASS, "Clicking on Country Drop-Down");
            WebElement countryDropDown = driver.findElement(ByAngular.model("(//select[@id='fbeba68a-87c8-9d22-1907-fa289a52c1ec'])[1]"));
            countryDropDown.click();

            test.log(LogStatus.PASS, "Selecting Country - India");
            WebElement countryIndia = driver.findElement(ByAngular.model("//option[@value='India']"));
            countryIndia.click();

            test.log(LogStatus.PASS, "Entering Legal Name of Entity/Individual");
            WebElement legalNameEntity = driver.findElement(ByAngular.model("//input[@id='supname']"));
            legalNameEntity.sendKeys("Divyansh Singh");

            test.log(LogStatus.PASS, "Selecting Type of Business");
            WebElement typeOfBussiness = driver.findElement(ByAngular.model("//select[@class='form-control ng-pristine ng-invalid ng-touched']"));
            typeOfBussiness.click();

            test.log(LogStatus.PASS, "Selecting Type of Business - LLCP");
            WebElement typeOfBussinessLLCP = driver.findElement(ByAngular.model("//option[@value='6']"));
            typeOfBussinessLLCP.click();

            test.log(LogStatus.PASS, "Entering Federal Employer Identification Number");
            WebElement federalEmpIDNum = driver.findElement(ByAngular.model("//input[@class='form-control ng-pristine ng-valid ng-touched']"));
            federalEmpIDNum.sendKeys("22");
            WebElement federalEmpIDNum2 = driver.findElement(ByAngular.model("//app-fein//input[1]"));
            federalEmpIDNum2.sendKeys("2234455");

            test.log(LogStatus.PASS, "Entering Confirm Federal Employer Identification Number");
            WebElement confirmFederalEmpIDNum = driver.findElement(ByAngular.model("(//input[@type='text'])[7]"));
            confirmFederalEmpIDNum.sendKeys("22");
            WebElement confirmFederalEmpIDNum2 = driver.findElement(ByAngular.model("(//input[@type='text'])[8]"));
            confirmFederalEmpIDNum2.sendKeys("2234455");

            test.log(LogStatus.PASS, "Entering Address Line");
            WebElement addressLine = driver.findElement(ByAngular.model("(//input[@type='text'])[15]"));
            addressLine.sendKeys("Dreame House, Sector 73");

            test.log(LogStatus.PASS, "Entering City");
            WebElement city = driver.findElement(ByAngular.model("(//input[@type='text'])[17]"));
            city.sendKeys("Lucknow");

            test.log(LogStatus.PASS, "Selecting State/Province");
            WebElement stateProvince = driver.findElement(ByAngular.model("///div[@class='col-xs-3']//select[@class='form-control" +
                    " ng-untouched ng-pristine ng-invalid']"));
            stateProvince.click();

            test.log(LogStatus.PASS, "Selecting State/Province - Uttar Pradesh");
            WebElement stateProvinceUttarPradesh = driver.findElement(ByAngular.model("//option[@value='Uttar Pradesh']"));
            stateProvinceUttarPradesh.click();

            test.log(LogStatus.PASS, "Entering Postal / Zip Code");
            WebElement postalZipCode = driver.findElement(ByAngular.model("(//input[@type='text'])[18]"));
            postalZipCode.sendKeys("226012");

            ngWebDriver.waitForAngularRequestsToFinish();

            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");
        } finally
        {
        test.log(LogStatus.INFO, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");
    }
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
