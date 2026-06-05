package com.automation.playwright_bdd.hooks;

import com.automation.playwright_bdd.pages.BasePage;
import com.automation.playwright_bdd.utils.*;
import com.aventstack.extentreports.*;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import java.io.File;

public class Hooks extends BasePage {

    private static ExtentReports extent = ExtentManager.getInstance();
    
    @Before(order = 0)
    public void setUp() {
        File reportDir = new File("test-output");
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }
        
        // Removed the "Suite Execution Starting" log from here
        driverFactory.driverInitialization();
    }

    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        ExtentTest test = extent.createTest(scenario.getName());
        ExtentTestManager.setTest(test);
        LoggerUtil.info("--- Scenario Setup: [" + scenario.getName() + " ] ---");
    }
    
    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        ExtentTest test = ExtentTestManager.getTest();
        
        if (scenario.isFailed()) {
            LoggerUtil.error("Scenario Result: FAILED -> " + scenario.getName());
            try {
                String screenshotPath = ScreenshotUtil.capture(driverFactory.page, scenario.getName().replaceAll("[^a-zA-Z0-9]", "_"));
                if (test != null) {
                    test.addScreenCaptureFromPath(screenshotPath);
                }
            } catch (Exception e) {
                LoggerUtil.error("Failed to capture viewport trace: " + e.getMessage());
            }
        } else {
            LoggerUtil.pass("Scenario Result: PASSED -> " + scenario.getName());
        }
    }

    @After(order = 0)
    public void tearDown() {
        LoggerUtil.info("Tearing down Playwright Context Page pipelines...");
        driverFactory.closeDriver();
        LoggerUtil.info("--- Scenario Cycle Ended ---");
        
        // Flush HERE so it captures everything including the tearDown log, 
        // right before this scenario context officially closes out.
        if (extent != null) {
            extent.flush();
        }
    }
}