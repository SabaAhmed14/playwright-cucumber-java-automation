package com.automation.playwright_bdd.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/com/automation/playwright_bdd/features"},
		glue= {"com.automation.playwright_bdd.stepDefinition","com.automation.playwright_bdd.hooks"},
		tags= "@Smoke",
		plugin={"pretty",
				"json:target/cucumber-reports/Cucumber.json",
				"html:target/test-output.html"
						},
		monochrome = true,
		dryRun = false
		)
public class TestRunner {

	@BeforeClass
	public static void beforeSuite() {
		System.out.println("\n=================================================");
		System.out.println("===== ALL TEST SUITE EXECUTION STARTING =========");
		System.out.println("=================================================\n");
	}

	@AfterClass
	public static void afterSuite() {
		System.out.println("\n=================================================");
		System.out.println("===== ALL TEST SUITE EXECUTION COMPLETED ========");
		System.out.println("=================================================\n");
	}
}