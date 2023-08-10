package UtilMethods;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class getScreenShot
{
    public static String capture(WebDriver driver) throws IOException
    {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("ScreenShots\\" + System.currentTimeMillis()
                + ".png");
        String errflpath = destFile.getAbsolutePath();
        FileUtils.copyFile(scrFile, destFile);
        return destFile.getPath();
    }
}
