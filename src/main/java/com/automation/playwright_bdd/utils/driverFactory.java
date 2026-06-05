package com.automation.playwright_bdd.utils;

import com.microsoft.playwright.*;

public class driverFactory {

    public static Page page;
    private static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;

    public static Page driverInitialization() {

        playwright = Playwright.create();

        boolean headlessValue = Boolean.parseBoolean(configReader.getProperty("headless"));

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(headlessValue).setSlowMo(100);

        browser = playwright.chromium().launch(launchOptions);

        Browser.NewContextOptions contextOptions =new Browser.NewContextOptions();
        
        contextOptions.setViewportSize(Integer.parseInt(configReader.getProperty("viewportWidth")),Integer.parseInt(configReader.getProperty("viewportHeight")));

        context = browser.newContext(contextOptions);

        page = context.newPage();

        page.navigate(configReader.getProperty("Base_URL"));

        System.out.println("Page Title: " + page.title());

        return page;
    }

    public static void closeDriver() {

        if (context != null)
            context.close();

        if (browser != null)
            browser.close();

        if (playwright != null)
            playwright.close();
    }
}