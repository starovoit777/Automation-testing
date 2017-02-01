package test_suite;

import com.automation.ui.model.GoogleSearchPage;
import com.automation.ui.model.GoogleTranslatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

/**
 * Created by Micro on 2/1/2017.
 */
public class GoogleTranslatePageTest {

    private GoogleTranslatePage page;
    String queryForTranslation = "Apple";
    String translationResult = "Apfel";

    @BeforeTest
    public void openTheBrowser() {
        String webDriverPropertyTypeOfDriver = "webdriver.gecko.driver";
        String webDriverPropertyPath = "C:/projects/Selenium/geckodriver.exe";
        String googlePageURL = "http://www.google.com";
        String searchQuery = "translate google com";
        WebDriver driver;
        System.setProperty(webDriverPropertyTypeOfDriver, webDriverPropertyPath);
        driver = new FirefoxDriver();

        driver.get(googlePageURL);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(searchQuery);
        driver.findElement(By.xpath("//button[@name='btnG']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//h3[@class='r']/a)[3]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        page = new GoogleTranslatePage(driver);

    }

    @AfterTest
    public void closeTheBrowser() {
        page.close();
    }

    @Test
    public void checkNumberOfResults() throws Exception {
        page.enterWord(queryForTranslation);
        page.chooseGermanLanguage();
        page.translate();
        page.getTranslateWord();
        Assert.assertEquals(page.getTranslateWord(), translationResult);
    }

    @Test
    public void testOpenPage() throws Exception {
        page.openPage();
        Assert.assertEquals(page.getURL(), "http://www.google.com");
    }

    @Test
    public void testGetTitle() throws Exception {

    }

}