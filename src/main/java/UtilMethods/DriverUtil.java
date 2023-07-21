package UtilMethods;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.security.Provider;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverUtil {

    public static WebDriver driver;

    @BeforeMethod
    public static synchronized <ChromeOptions> WebDriver getDriver(){

        if(driver != null) return driver;
        driver = new ChromeDriver();

        //Configurations for Headless Execution
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

    @BeforeMethod(description = "Pop-ups are different That is why creating a another getDriver method")
    public static synchronized <ChromeOptions> WebDriver getVenderDriver() {

        if (driver != null) return driver;
        driver = new ChromeDriver();

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

    public static void ExplicitWait()
    {
        Duration timeoutInSeconds = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod(description = "To Handle Ng-Based web elements, Configuring NG-WebDriver")
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


}
