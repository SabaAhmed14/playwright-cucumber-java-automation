package com.automation.playwright_bdd.pages;

public class SignupPage extends BasePage {
    private final String nameField = ".signup-form>form>input:nth-child(2)";
    private final String emailField = ".signup-form>form>input:nth-child(3)";
    private final String signupButton = ".signup-form>form>button";
    private final String errorMessage = ".signup-form>form>p";
    
    public void enterName(String name) {
        fillLocator(nameField, name);
    }
    
    public void enterEmail(String email) {
        fillLocator(emailField, email);
    }
    
    public void clickSignupButton() {
        clickLocator(signupButton);
    }
    
    public String getErrorMessage() {
        isErrorMessageDisplayed(errorMessage);
        return getText(errorMessage);
    }
}