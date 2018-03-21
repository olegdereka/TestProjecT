package core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;


public class ChromeDriverWeb {

    ChromeDriver driver;

    public ChromeDriver getDriver() {
        return driver;
    }

    public ChromeDriverWeb() {
        System.setProperty("webdriver.chrome.driver", ".\\helperfiles\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
    }

}
