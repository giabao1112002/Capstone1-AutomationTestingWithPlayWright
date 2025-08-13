package com.qa.javaCompiler.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qa.javaCompiler.base.BaseTest;
import com.qa.javaCompiler.constants.AppConstants;
import io.qameta.allure.*;

public class PIMPageTest extends BaseTest {

    @Test
    @Description("TC01_Login_as_admin_and_create_new_user_and_verify_it_present")
    public void addEmployee() {

        Allure.step("From login page go to Dashboard Page", () -> {
            dashboardPage = loginPage.loginValid(prop.getProperty("username"), prop.getProperty("password"));
        });

        Allure.step("Check the URL is correct", () -> {
            if (dashboardPage
                    .getDashboardURL()
                    .equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
                Allure.step("Correct URL");
            } else {
                Assert.fail("Incorrect URL");
            }
        });

        Allure.step("From Dashboard page go to PIM page", () -> {
            pimPage = dashboardPage.clickNavigation("PIM");
        });

        Allure.step("Wait", () -> {
            pimPage.pageWait();
        });

        Allure.step("Take Screenshot", () -> {
            pimPage.takeScreenShot();
        });

        Allure.step("Check if Employee Id text field is visible", () -> {
            if (pimPage.isTextFieldVisible("Employee Id")) {
                Allure.step("Employee Id is visible");
            } else {
                Assert.fail("Employee Id is not visible");
            }
        });

        Allure.step("Navigate to add employee", () -> {
            pimPage.pimNavigate("Add Employee");
        });

        Allure.step("Wait", () -> {
            pimPage.pageWait();
        });

        Allure.step("Click Login Details", () -> {
            pimPage.clickLoginDetails();
        });

        Allure.step("Fill First Name", () -> {
            pimPage.fillFullName("firstName", AppConstants.FIRST_NAME);

        });

        Allure.step("Fill Middle Name", () -> {
            pimPage.fillFullName("middleName", AppConstants.MIDDLE_NAME);
        });

        Allure.step("Fill Last Name", () -> {
            pimPage.fillFullName("lastName", AppConstants.LAST_NAME);
        });

        Allure.step("Fill Employee Id", () -> {
            pimPage.fillTextField("Employee Id", AppConstants.RANDOM_EMPLOYEE_ID);
        });

        Allure.step("Take Screenshot", () -> {
            pimPage.takeScreenShot();
        });

        Allure.step("Verify Full Name", () -> {
            if (pimPage.getFullNameTextFieldValue("firstName").equals(AppConstants.FIRST_NAME)
                    && pimPage.getFullNameTextFieldValue("middleName").equals(AppConstants.MIDDLE_NAME)
                    && pimPage.getFullNameTextFieldValue("lastName").equals(AppConstants.LAST_NAME)) {
                System.out.println("Correct input Full Name");
                Allure.step("null");
            } else {
                Assert.fail("Incorrect Full name");
            }
        });

        Allure.step("Wait for page to be ready", () -> {
            pimPage.pageWait();
        });

        Allure.step("Fill Username", () -> {
            pimPage.fillTextField("Username", AppConstants.USERNAME_WITH_ID);
        });

        Allure.step("Fill Password", () -> {
            pimPage.fillTextField("Password", AppConstants.PASSWORD);
        });

        Allure.step("Fill Confirm Password", () -> {
            pimPage.fillTextField("Confirm Password", AppConstants.PASSWORD);
        });

        Allure.step("Wait for page to be ready", () -> {
            pimPage.pageWait();
        });

        Allure.step("Take Screenshot", () -> {
            pimPage.takeScreenShot();
        });

        Allure.step("Click Save Button in Personal Details section", () -> {
            pimPage.clickSaveButton();
        });

        Allure.step("Verify success message is displayed", () -> {
            pimPage.verifySuccess();
        });

        // Fill Personal Details
        Allure.step("Fill Other Id", () -> {
            pimPage.fillTextField("Other Id", AppConstants.OTHER_ID);
        });

        Allure.step("Fill Driver's License Number", () -> {
            pimPage.fillTextField("Driver's License Number", AppConstants.DRIVER_LISCENCE);
        });

        Allure.step("Select License Expiry Date", () -> {
            pimPage.chooseDateOnCalendar("License Expiry Date", "19", "January", "2020");
        });

        Allure.step("Wait for 3 seconds", () -> {
            pimPage.pageWait(3000);
        });

        Allure.step("Select Date of Birth", () -> {
            pimPage.chooseDateOnCalendar("Date of Birth", "8", "December", "2002");
        });

        Allure.step("Select Gender: Male", () -> {
            pimPage.clickRadioButton("Male");
        });

        Allure.step("Select Nationality: Vietnamese", () -> {
            pimPage.selectOptionFromDropdown("Nationality", "Vietnamese");
        });

        Allure.step("Select Marital Status: Single", () -> {
            pimPage.selectOptionFromDropdown("Marital Status", "Single");
        });

        Allure.step("Wait for 3 seconds", () -> {
            pimPage.pageWait(3000);
        });

        Allure.step("Take Screenshot", () -> {
            pimPage.takeScreenShot();
        });

        Allure.step("Click Save button in Personal Details section", () -> {
            pimPage.clickSaveButtonOfSection("Personal Details");
        });

        Allure.step("Wait for 3 seconds", () -> {
            pimPage.pageWait(3000);
        });

        Allure.step("Verify Success Message is displayed", () -> {
            pimPage.verifySuccess();
        });

        Allure.step("Verify Other Id", () -> {
            if (pimPage.getTextFieldContext("Other Id").equals(AppConstants.OTHER_ID)) {
                Allure.step("Correct Other Id");
            } else {
                Assert.fail("Incorrect Other Id");
            }
        });

        Allure.step("Verify Driver's License Number", () -> {
            if (pimPage.getTextFieldContext("Driver's License Number").equals(AppConstants.DRIVER_LISCENCE)) {
                Allure.step("Correct License Number");
            } else {
                Assert.fail("Incorrect License Number");
            }
        });

        // Fill Custom Fields
        Allure.step("Select Blood Type: A+", () -> {
            pimPage.selectOptionFromDropdown("Blood Type", "A+");
        });

        Allure.step("Click Save button in Custom Fields section", () -> {
            pimPage.clickSaveButtonOfSection("Custom Fields");
        });

        Allure.step("Navigate to Employee List", () -> {
            pimPage.pimNavigate("Employee List");
        });

        Allure.step("Take Screenshot", () -> {
            pimPage.takeScreenShot();
        });
        Allure.step("null");

        Allure.step("Check if Employee Id text field is visible", () -> {
            if (pimPage.isTextFieldVisible("Employee Id")) {
                Allure.step("Employee Id is visible");
            } else {
                Assert.fail("Employee Id is not visible");
            }
        });

        Allure.step("Fill Employee Name", () -> {
            pimPage.fillTextField("Employee Name",
                    AppConstants.FIRST_NAME + " " + AppConstants.MIDDLE_NAME + " " + AppConstants.LAST_NAME);
        });

        Allure.step("Fill Employee Id", () -> {
            pimPage.fillTextField("Employee Id", AppConstants.RANDOM_EMPLOYEE_ID);
        });

        Allure.step("Take Screenshot", () -> {
            pimPage.takeScreenShot();
        });

        Allure.step("Click Search Button", () -> {
            pimPage.clickSearchButton();
        });

        Allure.step("Wait for search results (5 seconds)", () -> {
            pimPage.pageWait(5000);
        });

        List<String> values = new ArrayList<>();

        Allure.step("Create list to store employee data", () -> {
            values.add(AppConstants.RANDOM_EMPLOYEE_ID);
            values.add(AppConstants.MIDDLE_NAME);
            values.add(AppConstants.LAST_NAME);

            for (String value : values) {
                System.out.println(value);
            }
        });

        Allure.step("Verify Employee is visible in the table", () -> {
            pimPage.verifyRowWithValuesPresentInTable(values);
        });

        Allure.step("Take Screenshot", () -> {
            pimPage.takeScreenShot();
        });

    }
}
