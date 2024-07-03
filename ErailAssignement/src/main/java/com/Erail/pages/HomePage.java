package com.Erail.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterFromLocation(String location) {
        WebElement fromBox = driver.findElement(By.id("txtStationFrom"));
        fromBox.click();
        fromBox.sendKeys(Keys.BACK_SPACE);
        fromBox.sendKeys(location);
        
        // Wait until the autocomplete options appear
        
      //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectFromStation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autocomplete']/div[4]")));
        selectFromStation.click();
    }

    public void enterToLocation(String location) {
        WebElement toBox = driver.findElement(By.id("txtStationTo"));
        toBox.click();
        toBox.sendKeys(Keys.BACK_SPACE);
        toBox.sendKeys(location);
        WebElement toStation = driver.findElement(By.xpath("//div[@class='selected']"));
        toStation.click();
        
        // Wait until the autocomplete options appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectToStation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autocomplete']/div[4]")));
        selectToStation.click();
    }
}
