package com.qa.javaCompiler.helpers;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class tableHelper {
    private final Page page;

    // 1.String Locator
    String table = "//div[@role='table']";
    String btnLeft_Right = "//button[contains(@class,'next')]/i[contains(@class,'%s')]";
    String rowTable = "//div[@role='table']//div[@role='rowgroup' and not(contains(@class,'header'))]//div[@role='row']";

    // 2.Constructor
    public tableHelper(Page page) {
        this.page = page;
    }

    // 3.Actions/Method
    public boolean verifyRowWithValuesPresentInTable(List<String> values) {
        while (true) {
            // Get all rows on the current page
            List<Locator> rows = page.locator(rowTable).all();

            // Check each row for the presence of all values
            for (Locator row : rows) {
                String rowText = row.textContent();
                boolean allMatch = true;
                for (String value : values) {
                    if (rowText == null || !rowText.contains(value)) {
                        allMatch = false;
                        break;
                    }
                }
                if (allMatch) {
                    System.out.println("Row found: " + rowText);
                    return true;
                }
            }

            // Try to go to the next page if the "next" button is enabled/visible
            String btnRight = String.format(btnLeft_Right, "right");
            Locator nextBtn = page.locator(btnRight);
            if (nextBtn.isVisible() && !nextBtn.isDisabled()) {
                nextBtn.click();
                page.waitForTimeout(1000);
            } else {
                break;
            }
        }
        System.out.println("No matching row found in the table.");
        return false;
    }

}
