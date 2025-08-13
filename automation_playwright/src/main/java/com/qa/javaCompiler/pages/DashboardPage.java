package com.qa.javaCompiler.pages;

import com.microsoft.playwright.Page;

public class DashboardPage {
    private Page page;

    // 1. String Locators
    String navigation = "//ul/li/a/span[text()=\"%s\"]";
    String btnUpgrade = "//button[contains(string(),'Upgrade')]";

    // 2. Constructor
    public DashboardPage(Page page) {
        this.page = page;
    }

    // 3.Actions/Method
    public String getDashboardTitle() {
        return page.title();
    }

    public String getDashboardURL() {
        return page.url();
    }

    public boolean isUpgradeVisible() {
        return page.isVisible(btnUpgrade);
    }

    public PIMPage clickNavigation(String menubar) {
        String navigations = String.format(navigation, menubar);
        page.click(navigations);
        return new PIMPage(page);
    }
}
