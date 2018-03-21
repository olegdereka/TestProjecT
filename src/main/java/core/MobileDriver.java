package core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;



public class MobileDriver {

    ChromeDriver driver;

    public ChromeDriver getDriver() {
        return driver;
    }

    DesiredCapabilities capabilities;
    String DeviceName;

    public MobileDriver() {

        DeviceName = "Galaxy S5";

        System.setProperty("webdriver.chrome.driver", ".\\helperfiles\\chromedriver.exe");

        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", DeviceName);

        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);

        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        driver = new ChromeDriver(capabilities);

    }

}
