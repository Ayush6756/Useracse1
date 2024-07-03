package com.Erail.pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarPage extends BasePage {

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public void selectDate(int daysFromNow) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@id='tdDateFromTo']/input[@type='button']")));
       // WebElement dateField = driver.findElement(By.xpath("//td[@id='tdDateFromTo']/input[@type='button']"));
        dateField.click();
        
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement selectToStation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@id='tdDateFromTo']/input[@type='button']")));
        LocalDate date = LocalDate.now().plusDays(daysFromNow);
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        dateSelector(driver, dateField, formattedDate);
    }

    private void dateSelector(WebDriver driver, WebElement element, String dateVal) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', arguments[1]);", element, dateVal);
    }
}
