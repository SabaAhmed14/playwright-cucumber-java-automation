package com.automation.playwright_bdd.utils;

import com.aventstack.extentreports.ExtentTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

	private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);
	
	public static void info(String message) {
		logger.info(message);
		
		// Sync with Extent Report if a test instance is currently running
		ExtentTest test = ExtentTestManager.getTest();
		if (test != null) {
			test.info(message);
		}
	}
	
	public static void error(String message) {
		logger.error(message);
		
		ExtentTest test = ExtentTestManager.getTest();
		if (test != null) {
			test.fail(message);
		}
	}
	
	public static void debug(String message) {
		logger.debug(message);
		
		ExtentTest test = ExtentTestManager.getTest();
		if (test != null) {
			test.info("<font color='gray'>[DEBUG] " + message + "</font>");
		}
	}
	
	public static void warn(String message) {
		logger.warn(message);
		
		ExtentTest test = ExtentTestManager.getTest();
		if (test != null) {
			test.warning(message);
		}
	}

	// Added a helper specifically for step pass confirmations
	public static void pass(String message) {
		logger.info("PASS: " + message);
		
		ExtentTest test = ExtentTestManager.getTest();
		if (test != null) {
			test.pass(message);
		}
	}
}