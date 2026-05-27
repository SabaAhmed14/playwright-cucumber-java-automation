package com.automation.playwright_bdd.pages;

import com.automation.playwright_bdd.utils.driverFactory;
import com.microsoft.playwright.Page;

public class BasePage {

	protected Page _page = driverFactory.page;
	
	public BasePage() {
		this._page = driverFactory.page; // Get the page instance from driverFactory
	}
	
	public void clickLocator(String locator) {
		_page.click(locator);
	}
	
	public String getText(String locator) {
		return _page.textContent(locator);
	}
	
	public void fillLocator(String locator, String value) {
		_page.fill(locator, value);
	}
	
	public String getTitle() {
		return _page.title();
	}
	
	public String getCurrentURL() {
		return _page.url();
	}
	
	public boolean isErrorMessageDisplayed(String locator) {
		return _page.locator(locator).isVisible();
	}
}
