package com.selenium.ui.google.zadanie1;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SharedDriver extends EventFiringWebDriver {
    private static final WebDriver REAL_DRIVER = WebDriverFactory.getDriver();
    private static final Thread CLOSE_THREAD = new Thread() {
        public void run() {
            SharedDriver.REAL_DRIVER.close();
        }
    };

    public SharedDriver() {
        super(REAL_DRIVER);
    }

    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        } else {
            super.close();
        }
    }

    @Before
    public void deleteAllCookies() {
        this.manage().deleteAllCookies();
    }

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }
}

