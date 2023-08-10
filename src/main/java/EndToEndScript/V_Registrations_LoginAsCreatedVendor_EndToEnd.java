package EndToEndScript;

import UtilMethods.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static ExtentRepoetListners.ExtentReportListener.report;
import static UtilMethods.getScreenShot.capture;

public class V_Registrations_LoginAsCreatedVendor_EndToEnd
{
    public CharSequence username;
    WebDriver driver;
    static ExtentTest test;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Vendor_Registrations_LoginAsCreatedVendor_EndToEnd");
        test.log(LogStatus.PASS, ">>>Started>>>>");
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException, InterruptedException
    {
        driver = DriverUtil.getVendorDriver();
        test.log(LogStatus.PASS, "Logged In");
    }

    @Test
    public void vendorRegistrationLoginAsCreatedVendor() throws IOException, InterruptedException
    {
        vendorRegistrationLoginAsCreatedVendor(test, this.driver);
    }

    public static void vendorRegistrationLoginAsCreatedVendor(ExtentTest test, WebDriver driver) throws IOException {
        try {
            test.log(LogStatus.PASS, "Clicking on 'Open Level-2 Administration'");
            WebElement openL2 = driver.findElement(By.xpath("//a[normalize-space()='Open Level-2 Administration']"));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", openL2);

            test.log(LogStatus.PASS, "Clicking on Continue to 'Open Level-2 Administration'");
            WebElement continueToL2 = driver.findElement(By.xpath("//button[normalize-space()='Continue to L2 Administration']"));
            continueToL2.click();

            test.log(LogStatus.PASS, "Clicking on Form Builder");
            WebElement formBuilder = driver.findElement(By.cssSelector(".dropdown-toggle"));
            jsExecutor.executeScript("arguments[0].click();", formBuilder);

            test.log(LogStatus.PASS, "Clicking on Start Form Builder");
            WebElement startFormBuilder = driver.findElement(By.xpath("//button[normalize-space()='Start Form Builder']"));
            startFormBuilder.click();

            test.log(LogStatus.PASS, "Selecting Automation");
            WebElement unionPublicSchools = driver.findElement(By.xpath("//a[normalize-space()='Automation']"));
            unionPublicSchools.click();

            test.log(LogStatus.PASS, "Clicking on View");
            WebElement viewUnionPublicSchools = driver.findElement(By.xpath("/html/body/div/app-root/app-projects/app-base-layout/div/div/app-project-home/div/div/div/div/div[2]/div/app-project-list/div[2]/div[1]/div/a[1]"));
            viewUnionPublicSchools.click();

            SwitchingWindows.switchCurrentwindow(driver);

            test.log(LogStatus.PASS, "Scrolling page using Java Script");
            jsExecutor.executeScript("window.scrollBy(0,400)", "");

//            test.log(LogStatus.PASS, "Enabling 'Yes' in Instructions page");
//            WebElement enableYes = driver.findElement(ByAngular.model("(//select[@id='fbeba68a-87c8-9d22-1907-fa289a52c1ec'])[1]"));
//            enableYes.click();

//            test.log(LogStatus.PASS, "Clicking on Next Button-Instructions page");
//            WebElement nextButton = driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
//            nextButton.click();

            test.log(LogStatus.PASS, "Clicking on Country Drop-Down");
            WebElement countryDropDown = driver.findElement(By.xpath("(//select[@id='fbeba68a-87c8-9d22-1907-fa289a52c1ec'])[1]"));
            countryDropDown.click();

            test.log(LogStatus.PASS, "Selecting Country - India");
            WebElement countryIndia = driver.findElement(By.xpath("//option[@value='India']"));
            countryIndia.click();

            test.log(LogStatus.PASS, "Entering Legal Name of Entity/Individual");
            WebElement legalNameEntity = driver.findElement(By.xpath("(//input[@id='supname'])[1]"));
            legalNameEntity.sendKeys("Divyansh Singh");

            test.log(LogStatus.PASS, "Selecting Type of Business");
            WebElement typeOfBussiness = driver.findElement(By.xpath("(//select[@class='form-control ng-untouched ng-pristine ng-invalid'])[1]"));
            typeOfBussiness.click();

            test.log(LogStatus.PASS, "Selecting Type of Business - LLCP");
            WebElement typeOfBussinessLLCP = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[1]/div/app-form-page-designer/div/div/div/div[4]/div/div/app-div-layout/div/div/div/div/div[1]/div/app-div-layout/div/div/div[2]/div/div/div/app-component-resolver/app-business-type/base-element/div/element-structure/div/select/option[6]"));
            typeOfBussinessLLCP.click();

            test.log(LogStatus.PASS, "Scrolling page using Java Script");
            jsExecutor.executeScript("window.scrollBy(0,300)", "");

            test.log(LogStatus.PASS, "Entering Federal Employer Identification Number");
            WebElement federalEmpIDNum = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[1]/div/app-form-page-designer/div/div/div/div[7]/div/div/app-div-layout/div/div/div/div/div[1]/div/app-div-layout/div/div/div[1]/div/div/div/app-component-resolver/app-fein/base-element/div/element-structure/div/div[1]/input[1]"));
            federalEmpIDNum.sendKeys("22");
            WebElement federalEmpIDNum2 = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[1]/div/app-form-page-designer/div/div/div/div[7]/div/div/app-div-layout/div/div/div/div/div[1]/div/app-div-layout/div/div/div[1]/div/div/div/app-component-resolver/app-fein/base-element/div/element-structure/div/div[1]/input[2]"));
            federalEmpIDNum2.sendKeys(CurrentDateTimeAndRandomNumber.getRandomNumber10Digit());

            test.log(LogStatus.PASS, "Entering Confirm Federal Employer Identification Number");
            WebElement confirmFederalEmpIDNum = driver.findElement(By.xpath("(//input[@type='text'])[7]"));
            confirmFederalEmpIDNum.sendKeys("22");
            WebElement confirmFederalEmpIDNum2 = driver.findElement(By.xpath("(//input[@type='text'])[8]"));
            confirmFederalEmpIDNum2.sendKeys(CurrentDateTimeAndRandomNumber.copygetRandomNumber10Digit());

            test.log(LogStatus.PASS, "Entering Address Line");
            WebElement addressLine = driver.findElement(By.xpath("(//input[@type='text'])[15]"));
            addressLine.sendKeys("Dreame House, Sector 73");

            test.log(LogStatus.PASS, "Entering City");
            WebElement city = driver.findElement(By.xpath("(//input[@type='text'])[17]"));
            city.sendKeys("Lucknow");

            test.log(LogStatus.PASS, "Selecting State/Province");
            WebElement stateProvince = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[1]/div/app-form-page-designer/div/div/div/div[8]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-vendor-address/base-element/div/element-structure/div/div[2]/div[2]/select"));
            stateProvince.click();

            test.log(LogStatus.PASS, "Selecting State/Province - Uttar Pradesh");
            WebElement stateProvinceUttarPradesh = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[1]/div/app-form-page-designer/div/div/div/div[8]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-vendor-address/base-element/div/element-structure/div/div[2]/div[2]/select/option[36]"));
            stateProvinceUttarPradesh.click();

            test.log(LogStatus.PASS, "Entering Postal / Zip Code");
            WebElement postalZipCode = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[1]/div/app-form-page-designer/div/div/div/div[8]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-vendor-address/base-element/div/element-structure/div/div[3]/div/div/input"));
            postalZipCode.sendKeys("226012");

            test.log(LogStatus.PASS, "Clicking on Next Button Company Info");
            WebElement nextButtonCompanyInfo = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[4]/button[2]"));
            nextButtonCompanyInfo.click();

            test.log(LogStatus.PASS, "Selecting salutation");
            WebElement salutation = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[2]/div/app-form-page-designer/div/div/div/div[2]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-main-contact/base-element/div/element-structure/div/div[1]/div/select"));
            salutation.click();

            test.log(LogStatus.PASS, "Selecting salutation - Mr.");
            WebElement salutationMr = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[2]/div/app-form-page-designer/div/div/div/div[2]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-main-contact/base-element/div/element-structure/div/div[1]/div/select/option[2]"));
            salutationMr.click();

            test.log(LogStatus.PASS, "Entering First Name");
            WebElement firstName = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[2]/div/app-form-page-designer/div/div/div/div[2]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-main-contact/base-element/div/element-structure/div/div[2]/div[1]/input"));
            firstName.sendKeys("Ramesh");

            test.log(LogStatus.PASS, "Entering Last Name");
            WebElement lastName = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[2]/div/app-form-page-designer/div/div/div/div[2]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-main-contact/base-element/div/element-structure/div/div[2]/div[2]/input"));
            lastName.sendKeys("Singh");

            test.log(LogStatus.PASS, "Entering Main Phone Number");
            WebElement mainPhoneNumber = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[2]/div/app-form-page-designer/div/div/div/div[2]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-main-contact/base-element/div/element-structure/div/div[4]/div[1]/div/div/input"));
            mainPhoneNumber.sendKeys("8288765450");

            test.log(LogStatus.PASS, "Entering Email Address");
            WebElement emailAddress = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[2]/div/app-form-page-designer/div/div/div/div[3]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-username-password/base-element/div/element-structure/div/div[1]/div[1]/div/input"));
            emailAddress.sendKeys("sukreet.sinha@proactis.com");

            test.log(LogStatus.PASS, "Entering Email Password");
            WebElement emailPassword = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[2]/div/app-form-page-designer/div/div/div/div[3]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-username-password/base-element/div/element-structure/div/div[2]/div[1]/div/input"));
            emailPassword.sendKeys("Ramesh@123");

            test.log(LogStatus.PASS, "Entering Email Password");
            WebElement emailConfirmPassword = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[2]/div/app-form-page-designer/div/div/div/div[3]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-username-password/base-element/div/element-structure/div/div[2]/div[2]/div/input"));
            emailConfirmPassword.sendKeys("Ramesh@123");

            test.log(LogStatus.PASS, "Entering UserName");
            WebElement userName = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[2]/div/app-form-page-designer/div/div/div/div[3]/div/div/app-div-layout/div/div/div/div/div/div/app-component-resolver/app-username-password/base-element/div/element-structure/div/div[1]/div[2]/div/input"));
            userName.sendKeys(RandomNameGenerator.generateRandomName());
            String copiedUserName = userName.getAttribute("value");

            test.log(LogStatus.PASS, "Clicking on Next button - User Information");
            WebElement nextButtonUserInfo = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[4]/button[3]"));
            nextButtonUserInfo.click();

            test.log(LogStatus.PASS, "Switching Iframe");
            WebElement iframeElement = driver.findElement(By.xpath("//iframe"));
            driver.switchTo().frame(iframeElement);

            test.log(LogStatus.PASS, "Clicking on Abrasive Check Box");
            WebElement abrasiveCheckBox = driver.findElement(By.xpath("//*[@id=\"catTreeDiv\"]/ul/li[1]/span/span[2]"));
            abrasiveCheckBox.click();

            test.log(LogStatus.PASS, "Switching to the default iframe");
            driver.switchTo().defaultContent();

            Thread.sleep(1000);
            test.log(LogStatus.PASS, "Clicking on Submit Button");
            WebElement submitButton = driver.findElement(By.xpath("/html/body/div/app-root/app-form-processor/div/div/app-multi-page-processor/div[2]/div/form/div[4]/button[3]"));
            submitButton.click();

            Thread.sleep(1000);
            test.log(LogStatus.PASS, "clicking on Created Vendor URL");
            driver.get("https://webprocure-stage.proactiscloud.com/Login");

            test.log(LogStatus.PASS, "Entering User Name");
            WebElement username1 = driver.findElement(By.xpath("/html/body/div/section/div/div[1]/form/div[1]/input"));
            username1.sendKeys(copiedUserName);

            test.log(LogStatus.PASS, "Entering Password");
            WebElement pass = driver.findElement(By.xpath("/html/body/div/section/div/div[1]/form/div[2]/input[2]"));
            pass.sendKeys("Ramesh@123");

            test.log(LogStatus.PASS, "Clicking on Login Button");
            WebElement login = driver.findElement(By.xpath("//button[@id='login-submit']"));
            login.click();

            test.log(LogStatus.PASS, "Accepting T$C for first time user...!");
            WebElement acceptingT$C = driver.findElement(By.xpath("(//img[@title='Accept'])[1]"));
            acceptingT$C.click();

            try {
                test.log(LogStatus.PASS, "Accepting Vendor Profile Verification");
                WebElement vendorProfileVerification = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/form/div/div[15]/div/button[2]"));
                vendorProfileVerification.click();
            } catch (Exception e)
            {
                System.out.println("Pop-up is not there..!");
                throw new RuntimeException(e);
            }

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

            WebElement singhRamesh  = driver.findElement(By.xpath("/html/body/table[10]/tbody/tr/td[2]/a/font"));
            singhRamesh.click();

            test.log(LogStatus.PASS, "Scrolling Page Using Java Script");
            jsExecutor.executeScript("window.scrollBy(0, 300);");

            WebElement verifyName = driver.findElement(By.xpath("//b[normalize-space()='Bob Ram']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", verifyName);

            String verifiedName = verifyName.getText();
            String actualName= "Bob Ram";
            Assert.assertEquals(actualName,verifiedName);
            test.log(LogStatus.PASS,"Actual name :- " + actualName + "Verified Name :-" + verifiedName);

            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "Test is 'Passed'");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
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
    }}