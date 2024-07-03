package com.Erail.testCase;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.Erail.pages.CalendarPage;
import com.Erail.pages.HomePage;
import com.Erail.utils.ExcelUtils;

public class CalenderTest extends BaseTest {

    @Test
    public void testSelectDate() throws IOException, InterruptedException {
        HomePage homePage = new HomePage(driver);
        CalendarPage calendarPage = new CalendarPage(driver);
        ExcelUtils excelUtils = new ExcelUtils();

        // Case 1: Enter the station name in 'From' and select the 4th option
        homePage.enterFromLocation("DEL");

        // Case 2: Enter the station name in 'To' by accessing data from Excel
        ArrayList<String> data = excelUtils.getData("Destination");
        homePage.enterToLocation(data.get(1));
  
        // Case 3: Dynamically select the date 30 days from today
        calendarPage.selectDate(30);
    } 

}
