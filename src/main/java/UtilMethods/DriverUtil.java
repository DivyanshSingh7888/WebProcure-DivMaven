package UtilMethods;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverUtil {

    public static WebDriver driver;

    @BeforeMethod
    public static synchronized <ChromeOptions> WebDriver getDriver() {

        if (driver != null) return driver;
        driver = new ChromeDriver();

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");

//        Configurations for Headless Execution
//        ChromeOptions options = new ChromeOptions();
//        options.("--headless"); // Enables headless mode
//        WebDriver driver = new ChromeDriver((ChromeDriverService) options);

        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver", "D:\\Div.files\\D.files\\chromedriver_win32\\chromedriver.exe");
        driver.manage().window().maximize();

        driver.get("https://webprocure-stage.proactiscloud.com/Login");
        WebElement username = driver.findElement(By.id("visibleUname"));
        username.sendKeys("sukreetperfect");

        WebElement pass = driver.findElement(By.id("visiblePass"));
        pass.sendKeys("Password@12");

        WebElement login = driver.findElement(By.xpath("//button[@id='login-submit']"));
        login.click();

        try {
            Thread.sleep(3000);
            WebElement sessionDetailsPopUp = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
            sessionDetailsPopUp.click();
        } catch (Exception e) {
            System.out.println("PopUp is not present");
        }
        return driver;
    }

    static ChromeOptions options = new ChromeOptions();

    @BeforeMethod(description = "Pop-ups are different That is why creating a another getDriver method")
    public static synchronized <ChromeOptions> WebDriver getVendorDriver() {

        options.addArguments("--disable-save-address?-bubble");
        if (driver != null) return driver;
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver", "D:\\Div.files\\D.files\\chromedriver_win32\\chromedriver.exe");

        driver.manage().window().maximize();
        driver.get("https://webprocure-stage.proactiscloud.com/Login");

        WebElement username = driver.findElement(By.id("visibleUname"));
        username.sendKeys("acomenzo");

        WebElement pass = driver.findElement(By.id("visiblePass"));
        pass.sendKeys("Welcome@1");

        WebElement login = driver.findElement(By.xpath("//button[@id='login-submit']"));
        login.click();
        return driver;
    }

    public static void ExplicitWait(WebElement searchBox) {
        Duration timeoutInSeconds = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod(description = "To Handle Angular-Based web elements, Configuring NG-WebDriver")
    public static synchronized <ChromeOptions> WebDriver getNGWebDriver() {

        if (driver != null) return driver;
        driver = new ChromeDriver();
        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);

        ngWebDriver.waitForAngularRequestsToFinish();

        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver", "D:\\Div.files\\D.files\\chromedriver_win32\\chromedriver.exe");

        driver.manage().window().maximize();
        driver.get("https://webprocure-stage.proactiscloud.com/Login");

        WebElement username = driver.findElement(ByAngular.model("visibleUname"));
        username.sendKeys("acomenzo");

        WebElement pass = driver.findElement(ByAngular.model("visiblePass"));
        pass.sendKeys("Welcome@1");

        WebElement login = driver.findElement(ByAngular.model("//button[@id='login-submit']"));
        login.click();
        return driver;
    }

    @NotNull
    @BeforeMethod(description = "Creating login for Vendor Registration")
    public static synchronized <ChromeOptions> WebDriver logInAsCreatedVendor() {

        if (driver != null) return driver;
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver", "D:\\Div.files\\D.files\\chromedriver_win32\\chromedriver.exe");

        driver.manage().window().maximize();
        driver.get("https://webprocure-stage.proactiscloud.com/Login");

        WebElement username1 = driver.findElement(By.id("visibleUname"));
        username1.sendKeys("Bob Ram");

        WebElement pass = driver.findElement(By.id("visiblePass"));
        pass.sendKeys("Ramesh@123");

        WebElement login = driver.findElement(By.xpath("//button[@id='login-submit']"));

        login.click();
        return driver;
    }

    @BeforeMethod
    public static synchronized <ChromeOptions> WebDriver getContractBidBoardDriver()
    {

        if (driver != null) return driver;
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver", "D:\\Div.files\\D.files\\chromedriver_win32\\chromedriver.exe");
        driver.manage().window().maximize();

        driver.get("https://webprocure-stage.proactiscloud.com/wp-web-public/en/#/contractboard/search?customerid=33");
        return driver;
    }

    @BeforeMethod
    public static synchronized <ChromeOptions> WebDriver getBidBoardSolicitaionDriver()
    {

        if (driver != null) return driver;
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver", "D:\\Div.files\\D.files\\chromedriver_win32\\chromedriver.exe");
        driver.manage().window().maximize();

        driver.get("https://webprocure-stage.proactiscloud.com/wp-web-public/en/#/bidboard/search?searchterm=Test%20New%20&pagenumber=1&customerid=33&oid=-1&shorBy=r");
        return driver;
    }
}