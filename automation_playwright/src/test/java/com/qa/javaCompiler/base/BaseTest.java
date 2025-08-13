package com.qa.javaCompiler.base;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.javaCompiler.factory.PlaywrightFactory;
import com.qa.javaCompiler.pages.DashboardPage;
import com.qa.javaCompiler.pages.LoginPage;
import com.qa.javaCompiler.pages.PIMPage;

public class BaseTest {
    protected PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected PIMPage pimPage;

    @BeforeClass
    public void setUp() {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        loginPage = new LoginPage(page);
    }

    @AfterClass
    public void tearDown() {
        page.context().browser().close();
    }

    @AfterSuite
    public void generateAllureReport() {
        try {
            String command = "cmd /c cd /d D:\\ProjectPlaywright\\playwrightproject_orangehrm\\orangehrm_playwright && allure generate --single-file allure-results";
            // String command = "cmd /c cd /d
            // D:\\ProjectPlaywright\\playwrightproject_orangehrm\\orangehrm_playwright &&
            // allure serve allure-results";
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
