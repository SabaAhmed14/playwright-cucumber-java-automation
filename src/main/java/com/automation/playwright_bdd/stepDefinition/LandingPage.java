package com.automation.playwright_bdd.stepDefinition;

import com.automation.playwright_bdd.pages.HomePage;

import io.cucumber.java.en.*;

public class LandingPage {
	HomePage homePage = new HomePage();
	public String title = "Automation Exercise";

	@Given("User opens the Automation site")
	public void user_opens_the_Automation_site() {
		homePage.navigateToHomePage();
	}

	@When("User sees the title of the page as \"Automation Practice Site\"")
	public void user_should_be_navigated_to_the_homepage_page() {
	    String title = homePage.getPageTitle();
	    title.equals(title);
	}

	@Then("User should see the logo of the page")
	public void user_sees_page_logo() {
		homePage.logoIsDisplayed();
	}
}
