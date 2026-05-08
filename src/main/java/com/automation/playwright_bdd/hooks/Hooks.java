package com.automation.playwright_bdd.hooks;

import com.automation.playwright_bdd.utils.*;
import io.cucumber.java.*;

public class Hooks {

	@Before
	public void setUp() {
		driverFactory.driverInitialization();
	}
	
	@After
	public void tearDown() {
		driverFactory.closeDriver();
	}
}
