package com.prog.sel.org.login.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prog.java.util.App;
import com.prog.sele.util.AppUtil;

/**
 * 
 * @author Yogesh
 *
 */
public class LoginPO {

	@FindBy(id = "txtUsername")
	private WebElement username; 
	
	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(id = "btnLogin")
	private WebElement login; //Webelement login = driver.findelement(By.id("btnLogin"))
	
	
	@FindBy(id="spanMessage")
	private WebElement errorMessage;
	
	
	public String getErrorMessage() {
		try {
				return errorMessage.getText();
		}catch(Exception e) {
			return null;
		}
	}
	
	public void enterUserName(String name) {
		this.username.clear();
		this.username.sendKeys(name);
	}
	
	public void enterPassword(String pwd) {
		this.password.clear();
		this.password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		this.login.click();
	}

	public DashboardPO clickLoginWithDashboard() {
		this.login.click();
		return PageFactory.initElements(AppUtil.driver,DashboardPO.class);
	}
	
	public boolean checkForErrorMessage() {
		return getErrorMessage()!=null;
	}
	
}


