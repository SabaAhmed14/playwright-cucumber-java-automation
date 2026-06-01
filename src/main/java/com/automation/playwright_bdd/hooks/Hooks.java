package com.automation.playwright_bdd.hooks;

import com.automation.playwright_bdd.pages.BasePage;
import com.automation.playwright_bdd.utils.*;
import com.aventstack.extentreports.*;
import io.cucumber.java.Scenario;

import io.cucumber.java.*;

public class Hooks extends BasePage {

	private ExtentTest test;
	private static ExtentReports extent = ExtentManager.getInstance();
	
	@Before(order = 0)
	public void setUp() {
		LoggerUtil.info("=====Test Started=====");
		driverFactory.driverInitialization();
		LoggerUtil.info("Driver Initialized...");
	}
	@Before(order = 1)
	public void beforeScenario(Scenario scenario) {
	    test = extent.createTest(scenario.getName());
	    ExtentTestManager.setTest(test);
	    test.info("Scenario Started: "+ scenario.getName());
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) 
	{
		if (scenario.isFailed()) 
		{
			test.fail("Scenario Failed");
            String screenshotPath = ScreenshotUtil.capture(driverFactory.page,scenario.getName());
            test.addScreenCaptureFromPath(screenshotPath);
        } 
		else 
		{
            test.pass("Scenario Passed");
        }
        extent.flush();
    }
	@After(order = 0)
	public void tearDown() {
		LoggerUtil.info("Closing the driver...");
		driverFactory.closeDriver();
		LoggerUtil.info("Driver Closed...");
		LoggerUtil.info("=====Test Ended=====");
	}
}
