package com.automation.playwright_bdd.utils;

import com.microsoft.playwright.*;

public class driverFactory {

	public static Page page;
	private static Playwright playwright;
	public static Browser browser;
	
	public static Page driverInitialization() {
		// Use try-with-resources to ensure Playwright and Browser are closed automatically
		playwright = Playwright.create();
		
		boolean headlessValue = Boolean.parseBoolean(configReader.getProperty("headless"));
			
			// Launch Chromium; setHeadless(false) to see the browser window
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setHeadless(headlessValue)
				.setSlowMo(100)); // Slows down execution by 100ms for visibility

			BrowserContext context = browser.newContext();
			page = context.newPage();
			
			// Navigate and interact
			page.navigate(configReader.getProperty("Base_URL"));
			System.out.println("Page Title: " + page.title());
			
			// Cleanup happens automatically due to try-with-resources
			return page; // Return the page for further use in tests
	}
	
	public static void closeDriver() {
		if (playwright != null) {
			playwright.close(); // This will also close the browser and context
		}
	}
}
