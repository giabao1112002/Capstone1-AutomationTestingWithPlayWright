package com.qa.javaCompiler.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext bc;
    Page page;
    Properties prop;

    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    public static Browser getBrowser() {
        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }

    public static Page getPage() {
        return tlPage.get();
    }

    public Page initBrowser(Properties prop) {
        String browserName = prop.getProperty("browser").trim();
        // playwright = Playwright.create();

        tlPlaywright.set(Playwright.create());

        switch (browserName) {
            case "chromium":
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                        .setArgs(Arrays.asList("--start-maximized"))));
                break;
            case "firefox":
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)
                        .setArgs(Arrays.asList("--width=1920", "--height=1080"))));
                break;
            case "chrome":
                tlBrowser.set(
                        getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false)
                                .setArgs(Arrays.asList("--start-maximized"))));
                break;
            default:
                System.out.println("Incorrect browser name");
                break;
        }

        tlBrowserContext.set(getBrowser().newContext(
                new Browser.NewContextOptions().setViewportSize(null)));
        tlPage.set(getBrowserContext().newPage());
        getPage().navigate(prop.getProperty("url"));

        return getPage();
    }

    /**
     * This is using for initlialize the properties from config file
     */
    public Properties init_prop() {
        try {
            FileInputStream ip = new FileInputStream(
                    "./src/test/java/com/qa/javaCompiler/resources/config/config.properties");
            prop = new Properties();
            try {
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * Screenshot
     */
    public static String takeScreenShot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return path;
    }
}
