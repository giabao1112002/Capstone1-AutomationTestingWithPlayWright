package com.qa.javaCompiler.helpers;

import com.microsoft.playwright.Page;

public class dropdownHelper {
    private final Page page;

    // 1.String Locator
    String dropdownObject = "//label[contains(string(),'%s')]/parent::div/following-sibling::div";
    String dropdownElement = "//label[contains(string(),'Nationality')]/parent::div/following-sibling::div//div[@role='option'and contains(string(),'Vietnamese')]";

    // 2.Constructor
    public dropdownHelper(Page page) {
        this.page = page;
    }

    // 3.Actions/Method
    public void selectOption(String dropdownName, String option) {
        String arrowButtonDropdown = String.format(dropdownObject, dropdownName) + "//i[contains(@class,'arrow')]";
        page.click(arrowButtonDropdown);
        page.waitForTimeout(2000);

        String optionElement = String.format(dropdownObject, dropdownName)
                + "//div[@role='option'and contains(string(),'" + option + "')]";
        page.click(optionElement);
    }
}
