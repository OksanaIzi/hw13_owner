package config;

import org.aeonbits.owner.Config;

public interface WebDriverConfig extends Config {

    @Key("web.driver.url")
    String getWebDriverUrl();

    @Key("browser")
    String getWebDriverBrowser();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("remote")
    Boolean isRemote();
}