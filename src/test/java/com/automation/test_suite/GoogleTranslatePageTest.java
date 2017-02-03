package com.automation.test_suite;

import com.automation.ui.model.GoogleSearchPage;
import com.automation.ui.model.GoogleTranslatePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Serhii Starovoit on 2/1/2017.
 */
public class GoogleTranslatePageTest {

    public static final String WEB_DRIVER_PROPERTY_TYPE_OF_DRIVER = "webdriver.gecko.driver";
    public static final String WEB_DRIVER_PROPERTY_PATH_TO_GECKODRIVER = "C:/projects/Selenium/geckodriver.exe";
    public static final String SEARCH_QUERY_FOR_RANSLATOR_SEARCH = "translate google com";
    public static final String QUERY_FOR_TRANSLATION = "Apple";
    public static final String TRANSLATION_RESULT = "Apfel";

    public WebDriver driver;
    private GoogleTranslatePage googleTranslatePage;
    private GoogleSearchPage googleSearchPage;

    @BeforeTest
    public void openTheBrowser() {
        System.setProperty(WEB_DRIVER_PROPERTY_TYPE_OF_DRIVER, WEB_DRIVER_PROPERTY_PATH_TO_GECKODRIVER);
        driver = new FirefoxDriver();
        googleSearchPage = new GoogleSearchPage(driver);
        googleTranslatePage = new GoogleTranslatePage(driver);
        googleSearchPage.openGooglePage();
        googleSearchPage.searchFor(SEARCH_QUERY_FOR_RANSLATOR_SEARCH);
        googleSearchPage.navigateToFirstLink();
    }

    @AfterTest
    public void closeTheBrowser() {
        googleTranslatePage.close();
    }

    @Test(groups = { "pageTest" })
    public void checkNumberOfResults() throws Exception {
        googleTranslatePage.enterWord(QUERY_FOR_TRANSLATION);
        googleTranslatePage.chooseGermanLanguage();
        googleTranslatePage.translate();
        googleTranslatePage.getTranslateWord();
        Assert.assertEquals(googleTranslatePage.getTranslateWord(), TRANSLATION_RESULT);
    }
}