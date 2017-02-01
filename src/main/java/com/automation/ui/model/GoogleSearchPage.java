package com.automation.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Micro on 2/1/2017.
 */
public class GoogleSearchPage {
    protected WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }
    public void openPage() {
        driver.get("http://www.google.com");
    }
    public void close() {
        driver.close();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void goToPageNumber(int pageNumber) {
        String strUrl = driver.getCurrentUrl();
        if (pageNumber > 1) {
            pageNumber = (pageNumber - 1) * 10;
            strUrl = strUrl + "&start=" + pageNumber;
        }
        driver.navigate().to(strUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void searchFor(String searchQuery) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(searchQuery);
        driver.findElement(By.xpath("//button[@name='btnG']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public List<WebElement> allSearchResults() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> allSearchResults = driver.findElements(By.xpath("//h3[@class='r' or @class='_DM']"));
        return allSearchResults;
    }

}