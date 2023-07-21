//package Utilities;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.*;
//
//import java.awt.*;
//import java.awt.datatransfer.StringSelection;
//import java.awt.event.KeyEvent;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//import java.util.function.Function;
//
//public class BaseClass extends DriverUtil {
//    public static WebDriver driver;
//    static String ele = null;
//
//    public static WebDriver baseClass(){
//
//        public static WebDriver getDriver() {
//            return driver;
//        }
//
//        public static void acceptAlert() {
//            WebDriverWait wait = new WebDriverWait(driver, 20);
//            wait.until(ExpectedConditions.alertIsPresent());
//            driver.switchTo().alert().accept();
//        }
//
//        public static void dismissAlert() {
//            WebDriverWait wait = new WebDriverWait(driver, 20);
//            wait.until(ExpectedConditions.alertIsPresent());
//            driver.switchTo().alert().dismiss();
//        }
//
//        public static void waitForPageLoad() {
//            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//                }
//            };
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(pageLoadCondition);
//        }
//
//        public static void waitForElementToBeClickable(WebElement ele, Long... i) {
//
//            if (i.length >= 1) {
//                WebDriverWait wait = new WebDriverWait(driver, i[0]);
//                wait.until(ExpectedConditions.elementToBeClickable());
//            } else {
//                WebDriverWait wait = new WebDriverWait(driver, 30);
//                wait.until(ExpectedConditions.elementToBeClickable(ele));
//            }
//        }
//
//        public static void visibilityOfListLocated(List<WebElement> ele) {
//
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(ExpectedConditions.visibilityOfAllElements(ele));
//        }
//
//        public static void WaitTillElementIsPresent(final WebElement ele) {
//
//            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
//                    .pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
//
//            wait.until(new Function<WebDriver, WebElement>() {
//                public WebElement apply(WebDriver driver) {
//                    return ele;
//                }
//            });
//        }
//
//        public static void selectFromDropDownByIndex(WebElement ele, int index) {
//
//            new Select(ele).selectByIndex(index);
//        }
//
//        public static void selectFromDropDownByVisibleText(WebElement ele, String value) {
//            waitForElementToBeClickable(ele);
//            new Select(ele).selectByVisibleText(value);
//        }
//
//        public static void uploadFile(String str) throws AWTException {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            }
//            StringSelection selection = new StgSelecrintion(str);
//            java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//            clipboard.setContents(selection, null);
//
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            robot.keyPress(KeyEvent.VK_ENTER);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            robot.keyRelease(KeyEvent.VK_ENTER);
//        }
//
//        public static void waitForElementToDisappear(By by) {
//
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.invisibilityOfElementLocated(by));
//        }
//
//        public static void hoverOnElement(WebElement ele) {
//            Actions action = new Actions(driver);
//            action.moveToElement(ele);
//            action.build().perform();
//        }
//
//        public static void switchToDefaultContent() {
//            PCDriver.getDriver().switchTo().defaultContent();
//
//        }
//
//        public static void switchToFrame(WebElement frame) {
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
//        }
//
//        public static void switchToFrameBasedOnFrameName(String frameName) {
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
//        }
//
//        public static void waitForElementToBeEnable(By by) {
//
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(ExpectedConditions.presenceOfElementLocated(by));
//        }
//
//        public static void executeScript(WebElement ele) {
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            executor.executeScript("arguments[0].click();", ele);
//        }
//
//        public WebElement findElement(By arg0) {
//            return null;
//        }
//
//        public static void switchToWindow(String strWindowName) {
//
//            driver.switchTo().window(strWindowName);
//        }
//
//        public static void switchToDefaultWindow() {
//            driver.switchTo().defaultContent();
//        }
//
//        public java.util.List<WebElement> findElements(By arg0) {
//            // TODO Auto-generated method stub
//            return null;
//        }
//
//        public void get(String arg0) {
//            // TODO Auto-generated method stub
//
//        }
//
//        public String getCurrentUrl() {
//            return driver.getCurrentUrl();
//        }
//
//        public String getPageSource() {
//
//            return driver.getPageSource();
//        }
//
//        public String getTitle() {
//
//            return driver.getTitle();
//
//        }
//
//        public String getWindowHandle() {
//            // TODO Auto-generated method stub
//            return null;
//        }
//
//        public Set<String> getWindowHandles() {
//
//            return driver.getWindowHandles();
//        }
//
//        public WebDriver.Options manage() {
//            // TODO Auto-generated method stub
//            return null;
//        }
//
//        public WebDriver.Navigation navigate() {
//
//            return null;
//        }
//
//        public void quit() {
//            driver.quit();
//        }
//
//        public WebDriver.TargetLocator switchTo() {
//
//            return null;
//        }
//
//        public boolean isAlertPresent()
//        {
//            try
//            {
//                driver.switchTo().alert();
//                return true;
//            }   // try
//            catch (NoAlertPresentException Ex)
//            {
//                return false;
//            }   // catch
//        }
//
//    }
//}
