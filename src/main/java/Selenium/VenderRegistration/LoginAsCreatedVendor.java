package Selenium.VenderRegistration;

import UtilMethods.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class LoginAsCreatedVendor
{
    WebDriver driver;
    static ExtentTest test;
    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Logged In as Created Vendor Registration");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException
    {
        driver = DriverUtil.logInAsCreatedVendor();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void createdAsVendorRegistration() throws IOException, InterruptedException
    {
        createdAsVendorRegistration(this.test, this.driver);
    }

    public static void createdAsVendorRegistration(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
    {try
    {

//        test.log(LogStatus.PASS, "Accepting T$C for first time user...!");
//        WebElement acceptingT$C = driver.findElement(By.xpath("(//img[@title='Accept'])[1]"));
//        acceptingT$C.click();

        test.log(LogStatus.PASS, "Clicking on User Profile drop down");
        WebElement userProfileDropDown = driver.findElement(By.xpath("(//i[@class='fa fa-caret-down'])[2]"));
        userProfileDropDown.click();

        test.log(LogStatus.PASS, "Clicking on My Account link");
        WebElement myAccountlink = driver.findElement(By.xpath("//a[normalize-space()='My Account']"));
        myAccountlink.click();

        test.log(LogStatus.PASS, "Switching Iframe");
        String iframeName = "treeFrame";
        driver.switchTo().frame(iframeName);

        test.log(LogStatus.PASS, "Clicking on Main Org Info");
        WebElement mainOrgInfo = driver.findElement(By.xpath("//a[contains(.,'Edit Main Org Info')]"));
        mainOrgInfo.click();

        Thread.sleep(2000);
        test.log(LogStatus.PASS, "Clicking on Edit User");
        WebElement editUsers = driver.findElement(By.xpath("/html/body/table[8]/tbody/tr/td[1]/a/img"));
        editUsers.click();

        Thread.sleep(1000);
        WebElement singhRamesh  = driver.findElement(By.xpath("/html/body/table[10]/tbody/tr/td[2]/a/font"));
        singhRamesh.click();

        test.log(LogStatus.PASS, "Scrolling Page Using Java Script");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 300);");

        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 300).perform();

        WebElement verifyName = driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[4]/td[2]/table/tbody/tr[25]/td[3]/b"));
        String verifiedName = verifyName.getText();
        String actualName= "Bob Ram";
        Assert.assertEquals(actualName,verifiedName);
        test.log(LogStatus.PASS,"Actual name :- " + actualName + "Verified Name :-" + verifiedName);

        test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");

        driver.switchTo().defaultContent();
        test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");

    }
    finally {
        test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "For clarifications - Please refer to the ScreenShot...!!");
    }}

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
