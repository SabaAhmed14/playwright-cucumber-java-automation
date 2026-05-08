package com.automation.playwright_bdd.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/com/automation/playwright_bdd/features"},
		glue= {"com.automation.playwright_bdd.stepDefinition","com.automation.playwright_bdd.hooks"},
		plugin={"pretty",
				"json:target/cucumber-reports/Cucumber.json",
				"html:test-output.html"
						},
		monochrome = true,
		dryRun = false
		)
public class TestRunner {}