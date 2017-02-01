package com.automation.ui.model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleTranslate {

	public String translate(String queryForTranslation) {

		String webDriverPropertyTypeOfDriver = "webdriver.gecko.driver";
		String webDriverPropertyPath = "C:/projects/Selenium/geckodriver.exe";
		String googlePsgeURL = "http://www.google.com";
		String searchQuery = "translate google com";

		WebDriver driver;
		System.setProperty(webDriverPropertyTypeOfDriver, webDriverPropertyPath);
		driver = new FirefoxDriver();

		driver.get(googlePsgeURL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(searchQuery);
		driver.findElement(By.xpath("//button[@name='btnG']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//h3[@class='r']/a)[3]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("#source")).clear();
		driver.findElement(By.cssSelector("#source")).sendKeys(queryForTranslation);
		driver.findElement(By.cssSelector("#gt-tl-gms")).click();
		driver.findElement(By.id(":4n")).click();

		driver.findElement(By.cssSelector("#gt-submit")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String translationResultString = driver.findElement(By.cssSelector("#result_box")).getText();
		translationResultString = translationResultString.replaceAll("/[^A-Za-z0-9]/", "");
		return translationResultString;

	}

}
