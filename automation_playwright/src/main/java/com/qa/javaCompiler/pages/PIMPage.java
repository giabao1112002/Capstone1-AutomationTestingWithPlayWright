package com.qa.javaCompiler.pages;

import java.util.List;

import com.microsoft.playwright.Page;
import com.qa.javaCompiler.constants.AppConstants;
import com.qa.javaCompiler.helpers.CalendarHelper;
import com.qa.javaCompiler.helpers.commonHelper;
import com.qa.javaCompiler.helpers.dropdownHelper;
import com.qa.javaCompiler.helpers.screenshotHelpers;
import com.qa.javaCompiler.helpers.tableHelper;

public class PIMPage {
    private Page page;
    private CalendarHelper calendarHelper;
    private commonHelper commonHelper;
    private dropdownHelper dropdownHelper;
    private tableHelper tableHelper;
    private screenshotHelpers screenshotHelpers;

    // 1. String Locators
    String txt = "//label[text()=\"%s\"]/parent::div/following-sibling::div//input";
    String reset_search_saveButton = "//div//button[contains(string(),'%s')]";
    String pimNavigation = "//nav[@role=\"navigation\"]/ul/li[contains(string(),'%s')]";
    String txtFullName = "//label[text()=\"Employee Full Name\"]/parent::div/following-sibling::div//input[@name='%s']";
    String btnCreateLoginDetails = "//p[contains(string(),'Create Login Details')]/following-sibling::div";
    String successMessage = "//p[contains(string(),'Successfully')]";

    // 2. Constructor
    public PIMPage(Page page) {
        this.page = page;
        this.calendarHelper = new CalendarHelper(page);
        this.commonHelper = new commonHelper(page);
        this.dropdownHelper = new dropdownHelper(page);
        this.tableHelper = new tableHelper(page);
        this.screenshotHelpers = new screenshotHelpers(page);
        AppConstants.MODULE = "PIM";
        AppConstants.TC_INDEX = "PIMPageTest";
    }

    // 3.Actions/Method
    public void fillTextField(String nameTextField, String value) {
        commonHelper.fillTextField(nameTextField, value);
    }

    public void fillFullName(String typeOfName, String value) {
        commonHelper.fillFullName(typeOfName, value);
    }

    public void clickSearchButton() {
        commonHelper.clickSearchButton();
    }

    public void clickSaveButton() {
        commonHelper.clickSaveButton();
    }

    public void clickSaveButtonOfSection(String nameSection) {
        commonHelper.clickSaveButtonOfSection(nameSection);
    }

    public void clickLoginDetails() {
        page.click(btnCreateLoginDetails);
    }

    public void clickRadioButton(String nameRadioButton) {
        commonHelper.clickRadioButton(nameRadioButton);
    }

    public void selectOptionFromDropdown(String dropdownName, String optionName) {
        dropdownHelper.selectOption(dropdownName, optionName);
    }

    public String getTextFieldContext(String nameTextField) {
        return commonHelper.getTextFieldContext(nameTextField);
    }

    public String getFullNameTextFieldValue(String nameTypes) {
        return commonHelper.getFullNameTextFieldValue(nameTypes);
    }

    public boolean isTextFieldVisible(String nameTextField) {
        return commonHelper.isTextFieldVisible(nameTextField);
    }

    public void verifySuccess() {
        commonHelper.verifySuccess();
    }

    public void chooseDateOnCalendar(String calendarSelector, String day, String month, String year) {
        calendarHelper.chooseDateOnCalendar(calendarSelector, day, month, year);
    }

    public boolean verifyRowWithValuesPresentInTable(List<String> values) {
        return tableHelper.verifyRowWithValuesPresentInTable(values);
    }

    public void pimNavigate(String name) {
        String navigation = String.format(pimNavigation, name);
        page.click(navigation);
    }

    public String takeScreenShot() {
        return screenshotHelpers.takeScreenshot(AppConstants.MODULE, AppConstants.URS_ID, AppConstants.TC_INDEX);
    }

    public void pageWait() {
        commonHelper.pageWait();
    }

    public void pageWait(int time) {
        commonHelper.pageWait(time * 1);
    }
}