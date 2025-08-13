package com.qa.javaCompiler.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.javaCompiler.base.BaseTest;
import com.qa.javaCompiler.constants.AppConstants;

import io.qameta.allure.Allure;

public class LoginPageTest extends BaseTest {

    // @Test
    // public void loginPageTitleTest() {
    // String actualTitle = loginPage.getLoginPageTitle();
    // Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);

    // }

    // @Test
    // public void loginPageURLTest() {
    // String actualURL = loginPage.getLoginPageURL();
    // Assert.assertEquals(actualURL, prop.getProperty("url"));
    // }

    @Test
    public void loginValid_loginPage() {
        Allure.step("Take Screenshot", () -> {
            loginPage.takeScreenShot();
        });

        Allure.step("Login to Orange HRM", () -> {
            loginPage.loginValid(prop.getProperty("username"), prop.getProperty("password"));
        });
    }

}
