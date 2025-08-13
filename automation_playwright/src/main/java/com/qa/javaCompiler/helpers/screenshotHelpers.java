package com.qa.javaCompiler.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;

import com.microsoft.playwright.Page;
import com.qa.javaCompiler.constants.AppConstants;

import io.qameta.allure.Allure;

public class screenshotHelpers {
    private final Page page;

    public screenshotHelpers(Page page) {
        this.page = page;
        
    }

    public String takeScreenshot(String module, String ursId, String tcIndex) {
        try {

            // Build folder path
            String reportFolderPath = "target/Screenshots/"; // Adjust as needed
            new File(reportFolderPath).mkdirs();

            // Build screenshot name
            String screenshotName = String.format("%s_%s_%s_SS%02d.png", module, ursId, tcIndex,
                    AppConstants.SCREENSHOT_INDEX);
            AppConstants.SCREENSHOT_INDEX++;

            // Take screenshot
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get(reportFolderPath, screenshotName))
                    .setFullPage(true));
            // Attach it to report        
            try (InputStream is = new FileInputStream(reportFolderPath + screenshotName)) {
                Allure.addAttachment(screenshotName, "image/png", is, ".png");
            }

            return reportFolderPath + screenshotName;
        } catch (Exception e) {
            return null;
        }
    }

}
