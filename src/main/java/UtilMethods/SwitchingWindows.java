package UtilMethods;

import org.openqa.selenium.WebDriver;
import java.util.Set;

public class SwitchingWindows
{
    public static void switchCurrentwindow(WebDriver driver)
    {
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new window (assuming it's the last one opened)
        String mainWindowHandle = driver.getWindowHandle();
        String targetWindowHandle = null;

        for (String handle : windowHandles)
        {
            if (!handle.equals(mainWindowHandle))
            {
                targetWindowHandle = handle;
                break;
            }
        }
        if (targetWindowHandle != null)
        {
            // Switch to the new window
            driver.switchTo().window(targetWindowHandle);
        }
    }}
