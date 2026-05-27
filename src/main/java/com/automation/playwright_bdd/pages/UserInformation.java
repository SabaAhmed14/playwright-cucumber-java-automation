package com.automation.playwright_bdd.pages;

import com.automation.playwright_bdd.utils.driverFactory;
import com.microsoft.playwright.*;

public class UserInformation extends BasePage {
	
	String UserInfoTitle = ".row:nth-child(1)>div>div>h2>b";
	
	public String getUserInformationTitle() {
		isErrorMessageDisplayed(UserInfoTitle);
		return getText(UserInfoTitle);
	}
}
