package com.automation.playwright_bdd.pages;

import com.automation.playwright_bdd.utils.*;
import com.microsoft.playwright.*;


public class HomePage {
	private Page _page;
	private Locator AutomationImage;
	private Locator SignupLink;
	
	public HomePage() {
		// Constructor can be used to initialize page elements if needed
		this._page = driverFactory.page; // Get the page instance from driverFactory
		AutomationImage = _page.locator(".col-sm-4>div>a>img");
		SignupLink = _page.locator("a[href='/login']");
	}
	
	public void navigateToHomePage() {
		_page.navigate(configReader.getProperty("Base_URL"));
	}
	
	public void logoIsDisplayed() {
		AutomationImage.isVisible();
	}
	
	public String getPageTitle() {
		return _page.title();
	}
	
	public void clickLoginButton() {
		SignupLink.click();
	}
}
