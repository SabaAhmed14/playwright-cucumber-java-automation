package com.automation.playwright_bdd.pages;

import com.automation.playwright_bdd.utils.driverFactory;
import com.automation.playwright_bdd.utils.LoggerUtil;
import com.microsoft.playwright.Page;

public class BasePage {

    protected Page _page;
    
    public BasePage() {
        this._page = driverFactory.page;
    }
    
    public void clickLocator(String locator) {
        LoggerUtil.info("Clicking on element: [" + locator + "]");
        _page.click(locator);
    }
    
    public void fillLocator(String locator, String value) {
        LoggerUtil.info("Entering text value into element: [" + locator + "]");
        _page.fill(locator, value);
    }
    
    public String getText(String locator) {
        String text = _page.textContent(locator);
        LoggerUtil.info("Fetched text [" + text + "] from locator: [" + locator + "]");
        return text;
    }
    
    public String getTitle() {
        String title = _page.title();
        LoggerUtil.info("Current Page Title: [" + title + "]");
        return title;
    }
    
    public String getCurrentURL() {
        String url = _page.url();
        LoggerUtil.info("Current Page URL: [" + url + "]");
        return url;
    }
    
    public boolean isErrorMessageDisplayed(String locator) {
        boolean isVisible = _page.locator(locator).isVisible();
        LoggerUtil.info("Visibility validation for element [" + locator + "] returned: " + isVisible);
        return isVisible;
    }
}