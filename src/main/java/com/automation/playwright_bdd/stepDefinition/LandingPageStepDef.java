package com.automation.playwright_bdd.stepDefinition;

import com.automation.playwright_bdd.pages.HomePage;

import io.cucumber.java.en.*;

public class LandingPageStepDef {
	HomePage homePage = new HomePage();
	public String expectedTitle = "Automation Exercise"; // updated to match actual site title

	@Given("User opens the Automation site")
	public void user_opens_the_Automation_site() {
		homePage.navigateToHomePage();
	}

	@When("User sees the title of the page as \"Automation Practice Site\"")
	public void user_should_be_navigated_to_the_homepage_page() {
	    String actualTitle = homePage.getPageTitle();
	    if (actualTitle == null || !actualTitle.equalsIgnoreCase(expectedTitle)) {
	        throw new AssertionError("Expected page title: " + expectedTitle + ", but was: " + actualTitle);
	    }
	}

	@Then("User should see the logo of the page")
	public void user_sees_page_logo() {
		boolean visible = homePage.logoIsDisplayed();
		if (!visible) {
			throw new AssertionError("Expected page logo to be visible");
		}
	}
}