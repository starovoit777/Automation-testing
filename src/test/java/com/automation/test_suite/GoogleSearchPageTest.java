package com.automation.test_suite;

import com.automation.ui.model.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Serhii Starovoit on 2/1/2017.
 */

public class GoogleSearchPageTest {
    public static final String WEB_DRIVER_PROPERTY_TYPE_OF_DRIVER = "webdriver.gecko.driver";
    public static final String WEB_DRIVER_PROPERTY_PATH_TO_GECKODRIVER = "C:/projects/Selenium/geckodriver.exe";
    public static final String SEARCH_QUERY = "Orange";

    private GoogleSearchPage page;

    @BeforeTest
    public void openTheBrowser() {
        System.setProperty(WEB_DRIVER_PROPERTY_TYPE_OF_DRIVER, WEB_DRIVER_PROPERTY_PATH_TO_GECKODRIVER);
        WebDriver driver = new FirefoxDriver();
        page = new GoogleSearchPage(driver);
        page.openGooglePage();
    }

    @AfterTest
    public void closeTheBrowser() {
        page.close();
    }

    @Test(groups = { "pageTest" })
    public void checkNumberOfResults() throws Exception {
        Assert.assertEquals(page.calculatingResultsQuantity(SEARCH_QUERY, 1), page.calculatingResultsQuantity(SEARCH_QUERY, 2));
        Assert.assertEquals(page.calculatingResultsQuantity(SEARCH_QUERY, 1), page.calculatingResultsQuantity(SEARCH_QUERY, 10));
    }

}