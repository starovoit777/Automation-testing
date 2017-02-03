package com.automation.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii Starovoit on 2/1/2017.
 */

/**
 * Page Object for google translate page
 */
public class GoogleTranslatePage extends AbstractPage {


    public static final String GOOGLE_TRANSLATE_PAGE_SELECT_ITEM_GERMAN = ":4n"; //
    public static final String GOOGLE_TRANSLATE_PAGE_SELECTOR_SUBMIT = "#gt-submit";
    public static final String GOOGLE_TRANSLATE_PAGE_SELECTOR_LANGUAGE_SELECTION = "#gt-tl-gms";
    public static final String GOOGLE_TRANSLATE_PAGE_SELECTOR_INPUT_FIELD = "#source";
    public static final String GOOGLE_TRANSLATE_PAGE_SELECTOR_OUTPUT_FIELD = "#result_box";
    public static final String RAPLECE_PATTERN = "/[^A-Za-z0-9]/";

    /**
     * Constructor gets an argument of type driver. To be able at one driver created to work with multiple pages.
     */
    public GoogleTranslatePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Changes target language at German.
     */
    public void chooseGermanLanguage() {
        driver.findElement(By.id(GOOGLE_TRANSLATE_PAGE_SELECT_ITEM_GERMAN)).click();
        driver.manage().timeouts().implicitlyWait(WAITING_TIME_10_SECONDS, TimeUnit.SECONDS);
    }

    /**
     * Runs translation.
     */
    public void translate() {
        driver.findElement(By.cssSelector(GOOGLE_TRANSLATE_PAGE_SELECTOR_SUBMIT)).click();
    }

    /**
     * Enters word for translation
     */
    public void enterWord(String word) {
        driver.findElement(By.cssSelector(GOOGLE_TRANSLATE_PAGE_SELECTOR_INPUT_FIELD)).clear();
        driver.findElement(By.cssSelector(GOOGLE_TRANSLATE_PAGE_SELECTOR_INPUT_FIELD)).sendKeys(word);
        driver.findElement(By.cssSelector(GOOGLE_TRANSLATE_PAGE_SELECTOR_LANGUAGE_SELECTION)).click();
        driver.manage().timeouts().implicitlyWait(WAITING_TIME_10_SECONDS, TimeUnit.SECONDS);
    }

    /**
     * @return the result of translation
     */
    public String getTranslateWord() {
        return driver.findElement(By.cssSelector(GOOGLE_TRANSLATE_PAGE_SELECTOR_OUTPUT_FIELD)).getText().replaceAll(RAPLECE_PATTERN, "");
    }
}
