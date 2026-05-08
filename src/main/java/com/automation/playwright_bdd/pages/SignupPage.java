package com.automation.playwright_bdd.pages;

import com.automation.playwright_bdd.utils.*;
import com.microsoft.playwright.*;

public class SignupPage {
	private Page _page;
	private Locator Name;
	private Locator Email;
	private Locator SignupButton;
	
	public SignupPage() {
		this._page = driverFactory.page; // Get the page instance from driverFactory
		Name = _page.locator(".signup-form>form>input:nth-child(2)");
		Email = _page.locator(".signup-form>form>input:nth-child(3)");
		SignupButton = _page.locator(".signup-form>form>button");
	}
	
	public void enterName(String name) {
		Name.fill(name);
	}
	
	public void enterEmail(String email) {
		Email.fill(email);
	}
	
	public void clickSignupButton() {
		SignupButton.click();
	}

}
