package com.automation.playwright_bdd.pages;

import com.automation.playwright_bdd.utils.configReader;
import com.automation.playwright_bdd.utils.LoggerUtil;

public class HomePage extends BasePage {
    
    private final String automationImage = ".col-sm-4>div>a>img";
    private final String signupLink = "a[href='/login']";
    
    public void navigateToHomePage() {
        String url = configReader.getProperty("Base_URL");
        LoggerUtil.info("Navigating to Home Page: " + url);
        _page.navigate(url);
    }
    
    public boolean logoIsDisplayed() { 
        return _page.locator(automationImage).isVisible();
    }
    
    public void clickLoginButton() {
        clickLocator(signupLink);
    }
}