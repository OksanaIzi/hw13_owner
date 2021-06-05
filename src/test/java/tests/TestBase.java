package tests;

import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.*;

public class TestBase {

    static WebDriverConfig driverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    public static void setup() {
        Configuration.browser = driverConfig.getWebDriverBrowser();
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.startMaximized = true;


        if (driverConfig.getWebDriverUrl() != null) {
            Configuration.remote = driverConfig.getWebDriverUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }


    @AfterEach
    void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (System.getProperty("video.storage") != null)
            attachVideo();
        closeWebDriver();
    }
}