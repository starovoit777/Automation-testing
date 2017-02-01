package com.automation.ui.model;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigation {
    public int navigate(String searchQuery, int pageNumber) {

        String webDriverPropertyTypeOfDriver = "webdriver.gecko.driver";
        String webDriverPropertyPath = "C:/projects/Selenium/geckodriver.exe";
        String googlePsgeURL = "http://www.google.com";
        WebDriver driver;

        System.setProperty(webDriverPropertyTypeOfDriver, webDriverPropertyPath);
        driver = new FirefoxDriver();
        driver.get(googlePsgeURL);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(searchQuery);
        driver.findElement(By.xpath("//button[@name='btnG']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String strUrl = driver.getCurrentUrl();
        if (pageNumber > 1) {
            pageNumber = (pageNumber - 1) * 10;
            strUrl = strUrl + "&start=" + pageNumber;
        }
        driver.navigate().to(strUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> allSearchResults = driver.findElements(By.xpath("//h3[@class='r' or @class='_DM']"));
        driver.close();
        return allSearchResults.size();
    }
}
