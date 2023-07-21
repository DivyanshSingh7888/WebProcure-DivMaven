package UtilMethods;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static UtilMethods.DriverUtil.driver;

public class ScreenShot {

    public static void takingScreenShot() throws IOException {

        TakesScreenshot tsc = (TakesScreenshot) driver;
        File src = tsc.getScreenshotAs(OutputType.FILE);
        File trg = new File("D://Div.files//D.files//DivMaven//ScreenShots");
        FileUtils.copyFile(src,trg);
    }
}
