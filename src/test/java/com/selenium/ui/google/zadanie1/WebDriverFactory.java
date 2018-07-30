package com.selenium.ui.google.zadanie1;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
    private static String SELENIUM_HUB_URL = System.getProperty("hub");
    private static WebDriver driver;

    public WebDriverFactory() {
    }

    public static WebDriver getDriver() {
        String browser = System.getProperty("browser");
        return getDriver(browser);
    }

    public static String getTargetServer() {
        String targetServer = System.getProperty("server");
        if (targetServer == null || targetServer.trim().isEmpty()) {
            targetServer = "http://localhost:18080";
        }

        logger.info("Using target server: " + targetServer);
        return targetServer;
    }

    private static WebDriver getDriver(String browserType) {
        if (null != driver) {
            return driver;
        } else {
            if (SELENIUM_HUB_URL == null) {
                SELENIUM_HUB_URL = "http://localhost:4444/wd/hub";
            }

            if (browserType == null || browserType.trim().isEmpty()) {
                browserType = "node-chrome";
            }

            String var1 = browserType.toLowerCase();
            byte var2 = -1;
            switch(var1.hashCode()) {
                case -939120475:
                    if (var1.equals("node-chrome")) {
                        var2 = 0;
                    }
                    break;
                case -652094962:
                    if (var1.equals("node-firefox")) {
                        var2 = 1;
                    }
            }

            switch(var2) {
                case 0:
                    try {
                        driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), DesiredCapabilities.chrome());
                    } catch (MalformedURLException var5) {
                        logger.error("Selenium Grid URL is wrong, please check it and rerun tests");
                    }
                    break;
                case 1:
                    try {
                        driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), DesiredCapabilities.firefox());
                    } catch (MalformedURLException var4) {
                        logger.error("Selenium Grid URL is wrong, please check it and rerun tests");
                    }
                    break;
                default:
                    throw new RuntimeException("Your browser is not supported: " + browserType);
            }

            driver.manage().window().setSize(new Dimension(1280, 1024));
            return driver;
        }
    }
}

