package com.automation.playwright_bdd.pages;

import com.automation.playwright_bdd.utils.*;
import com.microsoft.playwright.*;


public class HomePage extends BasePage {
	
	private String AutomationImage = ".col-sm-4>div>a>img";
	private String SignupLink = "a[href='/login']";
	
	public void navigateToHomePage() {
		_page.navigate(configReader.getProperty("Base_URL"));
	}
	
	public boolean logoIsDisplayed() { 
		return (_page.locator(AutomationImage)).isVisible();
	}
	
	public String getPageTitle() {
		return getTitle();
	}
	
	public void clickLoginButton() {
		clickLocator(SignupLink);
	}
}