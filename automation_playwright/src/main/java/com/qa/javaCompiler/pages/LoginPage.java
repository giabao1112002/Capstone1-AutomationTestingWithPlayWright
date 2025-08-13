package com.qa.javaCompiler.pages;

import com.microsoft.playwright.Page;
import com.qa.javaCompiler.constants.AppConstants;
import com.qa.javaCompiler.helpers.screenshotHelpers;

public class LoginPage {
    private Page page;
    private screenshotHelpers screenshotHelpers;

    // 1. String Locators
    String txtUser = "//input[@name='username']";
    String txtPassword = "//input[@name='password']";
    String btnLogin = "//button[contains(string(),'Login')]";

    // 2. Constructor
    public LoginPage(Page page) {
        this.page = page;
        this.screenshotHelpers = new screenshotHelpers(page);
        AppConstants.MODULE = "Login";
        AppConstants.TC_INDEX="LoginPageTest";
    }

    // 3.Actions/Method
    public String getLoginPageTitle() {
        return page.title();
    }

    public String getLoginPageURL() {
        return page.url();
    }

    public DashboardPage loginValid(String username, String password) {
        page.fill(txtUser, username);

        page.fill(txtPassword, password);

        page.click(btnLogin);
        return new DashboardPage(page);
    }

    public String takeScreenShot() {
        return screenshotHelpers.takeScreenshot(AppConstants.MODULE, AppConstants.URS_ID, AppConstants.TC_INDEX);
    }
}
