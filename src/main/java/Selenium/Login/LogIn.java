package Selenium.Login;

import UtilMethods.DriverUtil;
//import Utilities.*;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class LogIn {
    WebDriver driver;

    @Test
    public void setUp() {
        driver = DriverUtil.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        driver.close();
    }
}
