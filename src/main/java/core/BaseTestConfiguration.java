package core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static Pages.MainPage.fullVersionOfSiteButton;
import static Pages.MainPage.siteLogo;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static core.TestData.baseUrl;

public class BaseTestConfiguration {

    public static String platform = "platform2";

    private ChromeDriver driver;

    @BeforeClass
    public void initialEnvironmentSetup() {
        switch (platform) {
            case "platform1":
                driver = new ChromeDriverWeb().getDriver();
                break;
            case "platform2":
                driver = new MobileDriver().getDriver();
                break;
        }

        Configuration.timeout = 20000;

        setWebDriver(driver);

        if (platform == "platform1") {
            open(baseUrl);
            siteLogo.waitUntil(Condition.visible, 7000);
        } else {
            open(baseUrl);
            fullVersionOfSiteButton.waitUntil(Condition.visible, 5000);
            fullVersionOfSiteButton.click();
            siteLogo.waitUntil(Condition.visible, 7000);
        }
    }

    @AfterClass
    public void closeDriver() throws IOException {
        allurePosOnChromeScreenshot();
        getWebDriver().quit();
    }

    @Attachment(type = "image/png")
    public byte[] allurePosOnChromeScreenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }

}

