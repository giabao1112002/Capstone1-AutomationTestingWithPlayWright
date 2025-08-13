package com.qa.javaCompiler.helpers;

import com.microsoft.playwright.Page;

public class CalendarHelper {
    private final Page page;

    // 1. String Locators
    private final String calendarButton = "//label[text()='%s']/parent::div/following-sibling::div//i";
    private final String calendar = "//div[@class='oxd-date-input-calendar']";
    private final String dropDownButtonCalendar = "//div[@class='oxd-date-input-calendar']//li[contains(@class,'%s')]//i";
    private final String dropdownMenu = "//div[@class='oxd-date-input-calendar']//li[contains(@class,'%s')]//ul[@role='menu']";
    private final String dayCalendar = "//div[@class='oxd-date-input-calendar']//div[@class='oxd-calendar-dates-grid']/div[contains(@class,'date-wrapper')]/div[text()='%s']";

    // 2. Constructor
    public CalendarHelper(Page page) {
        this.page = page;
    }

    // 3.Actions/Method
    public void chooseDateOnCalendar(String calendarSelector, String day, String month, String year) {
        String caButton = String.format(calendarButton, calendarSelector);
        page.click(caButton);
        page.waitForSelector(this.calendar);

        // Select Year
        String dropDownButtonCalendarYear = String.format(dropDownButtonCalendar, "year");
        page.click(dropDownButtonCalendarYear);
        String dropdownMenuYear = String.format(dropdownMenu, "year");
        String dropdownOptionYear = dropdownMenuYear + "//li[text()='" + year + "']";
        page.click(dropdownOptionYear);

        // Select Month
        String dropDownButtonCalendarMonth = String.format(dropDownButtonCalendar, "month");
        page.click(dropDownButtonCalendarMonth);
        String dropdownMenuMonth = String.format(dropdownMenu, "month");
        String dropdownOptionMonth = dropdownMenuMonth + "//li[text()='" + month + "']";
        page.click(dropdownOptionMonth);

        // Select Day
        String dayOptionCalendar = String.format(dayCalendar, day);
        page.click(dayOptionCalendar);
        page.waitForTimeout(2000);
    }
}
