package Selenium.Invoices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class InvoiceImport {

    public static void main (String[] args) throws FileNotFoundException, InterruptedException, AWTException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.setProperty("webdriver.chrome.driver", "D:\\Div.files\\D.files\\chromedriver_win32\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://webprocure-stage.proactiscloud.com/Login");

        WebElement username = driver.findElement(By.id("visibleUname"));
        username.sendKeys("sukreetperfect");

        WebElement pass = driver.findElement(By.id("visiblePass"));
        pass.sendKeys("Password@23");

        WebElement login = driver.findElement(By.xpath("//button[@id='login-submit']"));
        login.click();

        try {
            Thread.sleep(3000);
            WebElement sessionDetailsPopUp = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
            sessionDetailsPopUp.click();
        } catch (Exception e) {
            System.out.println("PopUp is not present");
        }

        WebElement invoiceDropDown = driver.findElement(By.xpath("//a[@title='Invoice']"));
        invoiceDropDown.click();

        WebElement invoiceImport = driver.findElement(By.xpath("(//a[normalize-space()='Invoice Import'])[1]"));
        invoiceImport.click();

        // Find the file upload button
        WebElement fileUploadButton = driver.findElement(By.xpath("(//input[@value='Browse...'])[1]"));

        // Click on the file upload button using Actions class
        Actions actions = new Actions(driver);
        actions.moveToElement(fileUploadButton).click().perform();

        // Create a Robot instance
        Robot robot = new Robot();

        // Provide the file path to upload
        String filePath = "C:/Users/DivyanshSingh/Downloads/Invoice_Import_Template.xlsx";

        // Copy the file path to the clipboard
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // Simulate paste shortcut (Ctrl+V)
        robot.keyPress(KeyEvent.VK_CONTROL);

        // Simulate Enter key press
        robot.keyPress(KeyEvent.VK_ENTER);

        // Submit the form or perform other actions on the webpage...
        WebElement uploadFile = driver.findElement(By.xpath("(//button[normalize-space()='UPLOAD'])[1]"));
        uploadFile.click();
        // Close the browser
//        driver.quit();
    }
}
