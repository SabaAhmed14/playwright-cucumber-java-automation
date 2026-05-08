package com.automation.playwright_bdd.pages;

import com.automation.playwright_bdd.utils.driverFactory;
import com.microsoft.playwright.*;

public class UserInformation {

	private Page _page;
	private Locator UserInfoTitle;
	
	public UserInformation() {
		this._page = driverFactory.page; // Get the page instance from driverFactory
		UserInfoTitle = _page.locator(".row:nth-child(1)>div>div>h2>b");
	}
	
	public String getUserInformationTitle() {
		return UserInfoTitle.textContent();
	}
}
