package com.automation.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii Starovoit on 2/1/2017.
 */
public class GoogleSearchPage extends AbstractPage {

    public static final String GOOGLE_HOME_PAGE_URL = "http://www.google.com";
    public static final String STRING_FOR_NAVIGATE_PAGES_SEARCH = "&start=";
    public static final String GOOGLE_HOME_PAGE_XPATH_GOOGLE_SEARCH_FIELD = "//input[@type='text']";
    public static final String GOOGLE_HOME_PAGE_XPATH_BUTTON_SUBMIT = "//button[@name='btnG']";
    public static final String GOOGLE_RESULT_PAGE_XPATH_OF_SEARCH_RESULTS = "//h3[@class='r' or @class='_DM']";
    public static final String GOOGLE_RESULT_PAGE_XPATH_FOR_FIRST_RESULTS = "(//h3[@class='r']/a)[3]";

    /**
     * Constructor gets an argument of type driver. To be able at one driver created to work with multiple pages.
     */
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Goes to the Google search page link
     */
    public void openGooglePage() {
        open(GOOGLE_HOME_PAGE_URL);
    }

    /**
     * Go directly to the page number of search results
     */
    public void goToPageNumber(int pageNumber) {
        String strUrl = driver.getCurrentUrl();
        if (pageNumber > 1) {
            pageNumber = (pageNumber - 1) * 10;
            strUrl = strUrl + STRING_FOR_NAVIGATE_PAGES_SEARCH + pageNumber;
        }
        driver.navigate().to(strUrl);
        driver.manage().timeouts().implicitlyWait(WAITING_TIME_10_SECONDS, TimeUnit.SECONDS);
    }

    /**
     * Clears the search field, enters a specified desired value, the search begins.
     */
    public void searchFor(String searchQuery) {
        driver.manage().timeouts().implicitlyWait(WAITING_TIME_10_SECONDS, TimeUnit.SECONDS);
        driver.findElement(By.xpath(GOOGLE_HOME_PAGE_XPATH_GOOGLE_SEARCH_FIELD)).clear();
        driver.findElement(By.xpath(GOOGLE_HOME_PAGE_XPATH_GOOGLE_SEARCH_FIELD)).sendKeys(searchQuery);
        driver.findElement(By.xpath(GOOGLE_HOME_PAGE_XPATH_BUTTON_SUBMIT)).click();
        driver.manage().timeouts().implicitlyWait(WAITING_TIME_10_SECONDS, TimeUnit.SECONDS);
    }

    /**
     * @return a List<WebElement> of search results page
     */
    public List<WebElement> allSearchResults() {
        driver.manage().timeouts().implicitlyWait(WAITING_TIME_10_SECONDS, TimeUnit.SECONDS);
        return driver.findElements(By.xpath(GOOGLE_RESULT_PAGE_XPATH_OF_SEARCH_RESULTS));
    }

    /**
     * @return quantity of results from that page
     */
    public int calculatingResultsQuantity(String searchQuery, int pageNumber) {
        searchFor(searchQuery);
        goToPageNumber(pageNumber);
        return allSearchResults().size();
    }

    /**
     * Go to the first link on the search results page
     */
    public void navigateToFirstLink() {
        driver.findElement(By.xpath(GOOGLE_RESULT_PAGE_XPATH_FOR_FIRST_RESULTS)).click();
    }
}