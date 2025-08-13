package com.qa.javaCompiler.helpers;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class commonHelper {
    private final Page page;

    // 1.String Locator
    String txt = "//label[text()=\"%s\"]/parent::div/following-sibling::div//input";
    String reset_search_saveButton = "//div//button[contains(string(),'%s')]";
    String txtFullName = "//label[text()=\"Employee Full Name\"]/parent::div/following-sibling::div//input[@name='%s']";
    String saveButtonOfSection = "//h6[contains(string(),'%s')]/following-sibling::form[@class=\"oxd-form\" ]//button[contains(string(),'Save')]";
    String successMessage = "//p[contains(string(),'Successfully')]";
    String btnRadio = "//label[contains(string(),'%s')]/input[@type='radio']/following-sibling::span";

    // 2.Constructor
    public commonHelper(Page page) {
        this.page = page;
    }

    // 3.Actions/Method
    public void fillTextField(String nameTextField, String value) {
        String txtDynamic = String.format(txt, nameTextField);
        page.click(txtDynamic);
        page.fill(txtDynamic, value);
    }

    public void fillFullName(String typeOfName, String value) {
        String txtNameDynamic = String.format(txtFullName, typeOfName);
        page.fill(txtNameDynamic, value);
    }

    public void clickSearchButton() {
        String searchButton = String.format(reset_search_saveButton, "Search");
        page.click(searchButton);
    }

    public void clickSaveButton() {
        String saveButton = String.format(reset_search_saveButton, "Save");
        page.click(saveButton);
    }

    public void clickSaveButtonOfSection(String nameSection) {
        String saveButton = String.format(saveButtonOfSection, nameSection);
        page.click(saveButton);
    }

    public void clickRadioButton(String btnName) {
        // This way will make it intercepts
        String radioButton = String.format(btnRadio, btnName);
        System.out.println(radioButton);
        page.click(radioButton);
    }

    public String getTextFieldContext(String nameTextField) {
        String txtDynamic = String.format(txt, nameTextField);
        return page.inputValue(txtDynamic);
    }

    public String getFullNameTextFieldValue(String nameTypes) {
        String txtFullNameDynamic = String.format(txtFullName, nameTypes);
        return page.inputValue(txtFullNameDynamic);
    }

    public boolean isTextFieldVisible(String nameTextField) {
        String txtDynamic = String.format(txt, nameTextField);
        try {
            page.waitForSelector(txtDynamic, new Page.WaitForSelectorOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(5000));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void pageWait() {
        page.waitForTimeout(2000);
    }

    public void pageWait(int time) {
        page.waitForTimeout(time * 1);
    }

    public void verifySuccess() {
        try {
            page.waitForSelector(successMessage);
            System.out.println("Success Message is show");
        } catch (Exception e) {
            System.out.println("Success Message is not show");
        }
    }
}
