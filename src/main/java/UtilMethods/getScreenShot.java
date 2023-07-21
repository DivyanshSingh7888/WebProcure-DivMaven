package UtilMethods;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.openqa.selenium.remote.http.Route.get;

public class getScreenShot {

    public static String capture(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("ScreenShots\\" + System.currentTimeMillis()
                + ".png");
        String errflpath = destFile.getAbsolutePath();
        FileUtils.copyFile(scrFile, destFile);
        return destFile.getPath();
    }

//    public static void main(String[] args) {
//        String localPath1 = "http://localhost63342/DivMaven/ScreenShots.png";
//        String globalPath = "DivMaven/ScreenShots.png";
//
//        Object destFile = null;
//        String localPath = get((String) destFile).toString();
//
//        try {
//            // Convert local path to global path
//            convertToLocalPath(localPath, globalPath);
//
//            // Perform operations with the global path
//            // ...
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void convertToLocalPath(String localPath, String globalPath) throws IOException {
//        // Create a Path object from the local path
//        Path localFilePath = Path.of(localPath);
//
//        // Create a File object from the global path
//        File globalFile = new File(globalPath);
//
//        // Copy the file from local path to global path
//        Files.copy(localFilePath, globalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//
//        // Optionally, you can delete the local file if needed
//        Files.delete(localFilePath);
//
//        System.out.println("Local path converted to global path successfully.");
//    }
    }
