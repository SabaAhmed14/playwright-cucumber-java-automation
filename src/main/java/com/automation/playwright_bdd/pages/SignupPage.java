package com.automation.playwright_bdd.pages;

import com.automation.playwright_bdd.utils.*;
import com.microsoft.playwright.*;

public class SignupPage extends BasePage {
	private String Name = ".signup-form>form>input:nth-child(2)";
	private String Email = ".signup-form>form>input:nth-child(3)";
	private String SignupButton = ".signup-form>form>button";
	private String ErrorMessage = ".signup-form>form>p";
	
	public void enterName(String name) {
		fillLocator(Name, name);
	}
	
	public void enterEmail(String email) {
		fillLocator(Email, email);
	}
	
	public void clickSignupButton() {
		clickLocator(SignupButton);
	}
	
	public String getErrorMessage() {
		isErrorMessageDisplayed(ErrorMessage);
		return getText(ErrorMessage);
	}
}
