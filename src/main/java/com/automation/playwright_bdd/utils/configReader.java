package com.automation.playwright_bdd.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class configReader {
	
	private static Properties prop;
	
	public static Properties loadConfig() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("src/test/java/com/automation/playwright_bdd/configs/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static String getProperty(String key) {
		if (prop == null) {
			loadConfig();
		}
		return prop.getProperty(key);
	}
}
