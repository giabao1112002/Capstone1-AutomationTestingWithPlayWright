package com.qa.javaCompiler.tests;

import org.testng.annotations.Test;

import com.qa.javaCompiler.base.BaseTest;

public class DashboardPageTest extends BaseTest {

    @Test
    public void navigateToDashboardPage() {
        // Create Dashboard page from login
        dashboardPage = loginPage.loginValid(prop.getProperty("username"),prop.getProperty("password"));

        // Check the title is correct
        if (dashboardPage.getDashboardTitle().equals("OrangeHRM")) {
            System.out.println("Correct Title");
        } else {
            System.out.println("Incorrect Title");
        }

        // Check the URL is correct
        if (dashboardPage
                .getDashboardURL().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
            System.out.println("Correct URL");
        } else {
            System.err.println("Incorrect URL");
        }

        dashboardPage.clickNavigation("PIM");
    }
}
