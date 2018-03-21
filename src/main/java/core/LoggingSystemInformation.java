package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

import static core.Tools.getCurrentDateAndTime;

public class LoggingSystemInformation {

    public static void getDesktopBrowserScreenshot(RemoteWebDriver driver, String app) throws IOException {
        String Screenshotpath = ".\\build\\reports\\device_screenshots\\";
        File screenShot = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(Screenshotpath + app + "_" + getCurrentDateAndTime() + "." + "jpg"));
        System.out.println("Screenshot is saved to:\n " + Screenshotpath + app + "_" + getCurrentDateAndTime() + "." + "jpg");
    }

}
