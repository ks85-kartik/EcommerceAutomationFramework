package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/" + fileName + ".png");
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}