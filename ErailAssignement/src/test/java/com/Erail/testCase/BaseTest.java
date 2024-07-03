package com.Erail.testCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	 protected WebDriver driver;
	 
	 public String getScreenshots(String testCaseName, WebDriver driver) throws IOException {
			// Step 1> grab screenshot to driver mode 		
				TakesScreenshot ts = (TakesScreenshot)driver;
				
				//Step 2> now call screenshot method and assigne the output type and store it in File 
				File source = ts.getScreenshotAs(OutputType.FILE);
				
				// Step 3> now after taking ss copy the ss image to a file for that we will use FileUtility package 
				File file = new File(System.getProperty("user.dir") + "//reports//" +testCaseName+ ".png");
				FileUtils.copyFile(source, source);
				
				// Step 4> return the same path 
				return System.getProperty("user.dir") + "//reports//" +testCaseName+ ".png";
			}

	    @BeforeMethod
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.get("https://erail.in/");
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
