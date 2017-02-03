package com.automation.ui.model;

import org.openqa.selenium.WebDriver;

/**
 * Created by Serhii Starovoit on 2/1/2017.
 */

/**
 * Abstract class AbstractPage. Contains constants and methods common to all pages.
 */
public abstract class AbstractPage {

    public static final int WAITING_TIME_10_SECONDS = 10;

    protected WebDriver driver;

    public void open(String url) {
        driver.get(url);
    }

    public void close() {
        driver.close();
    }
}
