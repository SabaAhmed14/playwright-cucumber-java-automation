package com.automation.playwright_bdd.stepDefinition;

import com.automation.playwright_bdd.pages.*;
import com.automation.playwright_bdd.utils.configReader;

import io.cucumber.java.en.*;

public class SignupStepDef {

	HomePage HomePage = new HomePage();
	SignupPage SignupPage = new SignupPage();
	UserInformation UserInformation = new UserInformation();
	public String title = "Enter Account Information";
	
	@When("User clicks on the {string} button")
	public void user_clicks_on_the_button(String string) {
		HomePage.clickLoginButton();
	}

	@And("User enters the {string}, {string} and clicks on the Signup button")
	public void user_enters_the_name_email_address_and_clicks_on_the_button(String name, String email) {
		if(name.startsWith("config:")&&email.startsWith("config:")) {
			String key = name.split(":")[1]; // Extract the key from "config.Key"
			name = configReader.getProperty(key);
			key = email.split(":")[1]; // Extract the key from "config.Key"
			email = configReader.getProperty(key);
		}
		SignupPage.enterName(name);
		SignupPage.enterEmail(email);
		SignupPage.clickSignupButton();
	}

	@Then("User should see the text {string}")
	public void user_should_see_the_text(String ExpectedText) {
		String returnedValue = UserInformation.getUserInformationTitle();
		if (returnedValue == null || !returnedValue.equalsIgnoreCase(ExpectedText)) {
			throw new AssertionError("Expected text: " + ExpectedText + ", but was: " + returnedValue);
		}
	}
	
	@Then("User should see the error message {string}")
	public void user_should_see_the_error_message(String errorMessage) {
		String returnedValue =SignupPage.getErrorMessage();
	    if (returnedValue == null || !returnedValue.equalsIgnoreCase(errorMessage)) {
			throw new AssertionError("Expected text: " + errorMessage + ", but was: " + returnedValue);
		}
	}
}