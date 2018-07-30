package com.selenium.ui.google.zadanie1;

import cucumber.api.java.en.Given;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PageSteps {

    private static final int PAGE_LOAD_TIMEOUT = 20;

    private SharedDriver driver;
    private String loginUrl;
    private GoogleSearchPage page;

    public PageSteps(SharedDriver sharedDriver) {
        driver = sharedDriver;
        loginUrl = WebDriverFactory.getTargetServer();
        page = PageFactory.initElements(driver, GoogleSearchPage.class);

    }

    @Given("^I am on google search page$")
    public void iAmOnGooglePage() throws Throwable {

        if (loginUrl == null || loginUrl.isEmpty()) {
            throw new NoSuchElementException("Page URL is not set");
        }

        driver.get(loginUrl);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS)
                .setScriptTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS)
                .implicitlyWait(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        }

}

