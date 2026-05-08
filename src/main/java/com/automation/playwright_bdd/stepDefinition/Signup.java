package com.automation.playwright_bdd.stepDefinition;

import com.automation.playwright_bdd.pages.*;
import com.automation.playwright_bdd.utils.configReader;

import io.cucumber.java.en.*;

public class Signup {

	HomePage HomePage = new HomePage();
	SignupPage SignupPage = new SignupPage();
	UserInformation UserInformation = new UserInformation();
	public String title = "Enter Account Information";
	
	@When("User clicks on the {string} button")
	public void user_clicks_on_the_button(String string) {
		HomePage.clickLoginButton();
	}

	@And("User enters the name, email address and clicks on the {string} button")
	public void user_enters_the_name_email_address_and_clicks_on_the_button(String string) {
		SignupPage.enterName(configReader.getProperty("Name"));
	    SignupPage.enterEmail(configReader.getProperty("Email"));
	    SignupPage.clickSignupButton();
	}

	@Then("User should see the text {string}")
	public void user_should_see_the_text(String string) {
		String UserTitle = UserInformation.getUserInformationTitle();
		UserTitle.equals(string);
	}
}
