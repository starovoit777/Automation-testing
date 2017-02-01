package com.automation.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Micro on 2/1/2017.
 */
public class GoogleTranslatePage {
    protected WebDriver driver;

    public GoogleTranslatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void openPage() {
        driver.get("https://translate.google.com");
    }

    public void close() {
        driver.close();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void chooseGermanLanguage() {
        driver.findElement(By.id(":4n")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void chooseChineseSimplifiedLanguage() {
        driver.findElement(By.id(":42")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void chooseChineseTraditionalLanguage() {
        driver.findElement(By.id(":43")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void chooseKoreanLanguage() {
        driver.findElement(By.id(":44")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void chooseNetherlandsLanguage() {
        driver.findElement(By.id(":4m")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void translate() {
        driver.findElement(By.cssSelector("#gt-submit")).click();
    }

    public void enterWord(String word) {
        driver.findElement(By.cssSelector("#source")).clear();
        driver.findElement(By.cssSelector("#source")).sendKeys(word);
        driver.findElement(By.cssSelector("#gt-tl-gms")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public String getTranslateWord() {
        String translationResultString = driver.findElement(By.cssSelector("#result_box")).getText();
        translationResultString = translationResultString.replaceAll("/[^A-Za-z0-9]/", "");
        return translationResultString;
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }
}
