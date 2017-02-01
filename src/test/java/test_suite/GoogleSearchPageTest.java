package test_suite;

import com.automation.ui.model.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Micro on 2/1/2017.
 */
public class GoogleSearchPageTest {
    private GoogleSearchPage page;

    @BeforeTest
    public void openTheBrowser() {
        String webDriverPropertyTypeOfDriver = "webdriver.gecko.driver";
        String webDriverPropertyPath = "C:/projects/Selenium/geckodriver.exe";
        String googlePageURL = "http://www.google.com";
        WebDriver driver;
        System.setProperty(webDriverPropertyTypeOfDriver, webDriverPropertyPath);
        driver = new FirefoxDriver();
        page = new GoogleSearchPage(driver);
        page.open(googlePageURL);
    }

    @AfterTest
    public void closeTheBrowser() {
        page.close();
    }

    @Test
    public void checkNumberOfResults() throws Exception {
        Assert.assertEquals(calculatingResultsQuantity("Orange", 1), 10);
        Assert.assertEquals(calculatingResultsQuantity("Orange", 2), 10);
        Assert.assertEquals(calculatingResultsQuantity("Orange", 10), 10);
    }
    @Test
    public void testGetTitle() throws Exception {
        System.out.println(page.getTitle());
    }

    private int calculatingResultsQuantity(String searchQuery, int pageNumber) {
        page.searchFor(searchQuery);
        page.goToPageNumber(pageNumber);
        return page.allSearchResults().size();
    }


}