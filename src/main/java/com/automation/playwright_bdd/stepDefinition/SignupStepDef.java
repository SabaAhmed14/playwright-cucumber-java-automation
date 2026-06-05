package com.automation.playwright_bdd.stepDefinition;

import com.automation.playwright_bdd.pages.*;
import com.automation.playwright_bdd.utils.configReader;
import com.automation.playwright_bdd.utils.LoggerUtil;
import io.cucumber.java.en.*;

public class SignupStepDef {

    HomePage homePage = new HomePage();
    SignupPage signupPage = new SignupPage();
    UserInformation userInformation = new UserInformation(); // Keep instance variable lowercase ideally
    
    @When("User clicks on the {string} button")
    public void user_clicks_on_the_button(String buttonName) {
        LoggerUtil.info("Step: Clicking on button: " + buttonName);
        homePage.clickLoginButton();
    }

    @And("User enters the {string}, {string} and clicks on the Signup button")
    public void user_enters_the_name_email_address_and_clicks_on_the_button(String name, String email) {
        if (name.startsWith("config:") && email.startsWith("config:")) {
            String nameKey = name.split(":")[1];
            name = configReader.getProperty(nameKey);
            
            String emailKey = email.split(":")[1];
            email = configReader.getProperty(emailKey);
            LoggerUtil.info("Resolved config profiles -> Name: " + name + ", Email: " + email);
        }
        
        signupPage.enterName(name);
        signupPage.enterEmail(email);
        signupPage.clickSignupButton();
    }

    @Then("User should see the text {string}")
    public void user_should_see_the_text(String expectedText) {
        String returnedValue = userInformation.getUserInformationTitle();
        LoggerUtil.info("Validating registration inner header text. Expected: [" + expectedText + "], Actual: [" + returnedValue + "]");
        if (returnedValue == null || !returnedValue.equalsIgnoreCase(expectedText)) {
            throw new AssertionError("Expected text: " + expectedText + ", but was: " + returnedValue);
        }
        LoggerUtil.pass("Header verification text matched.");
    }
    
    @Then("User should see the error message {string}")
    public void user_should_see_the_error_message(String errorMessage) {
        String returnedValue = signupPage.getErrorMessage();
        LoggerUtil.info("Validating error state alert. Expected: [" + errorMessage + "], Actual: [" + returnedValue + "]");
        if (returnedValue == null || !returnedValue.equalsIgnoreCase(errorMessage)) {
            throw new AssertionError("Expected text: " + errorMessage + ", but was: " + returnedValue);
        }
        LoggerUtil.pass("Error alert text pattern matched validation parameters.");
    }
}