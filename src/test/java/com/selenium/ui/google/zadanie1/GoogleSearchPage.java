package com.selenium.ui.google.zadanie1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {

    private static final int PAGE_LOAD_TIMEOUT = 20;

    protected WebDriverWait wait;
    protected WebDriver driver;


    public GoogleSearchPage(WebDriver driver) {
        wait = new WebDriverWait(driver, 20);
        this.driver = driver;
    }




}


