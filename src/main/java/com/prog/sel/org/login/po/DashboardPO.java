package com.prog.sel.org.login.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPO {

	@FindBy(id="welcome")
	private WebElement welcome;
	
	public String welcomeText() {
		try {
			return welcome.getText();
		}catch(Exception e) {
			return null;
		}
	}
	
	
}
