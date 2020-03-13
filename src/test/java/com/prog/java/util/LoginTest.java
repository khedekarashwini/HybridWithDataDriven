package com.prog.java.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.prog.sel.org.login.po.DashboardPO;
import com.prog.sel.org.login.po.LoginPO;
import com.prog.sele.util.AppUtil;

public class LoginTest {

	@DataProvider
	public Object[][] multipleUsers(){
		Object [][] testData =new Object[5][3];
		
		testData[0][0]="admin";
		testData[0][1]="admin";
		testData[0][2]="Invalid credentials";
		
		testData[1][0]="admin123";
		testData[1][1]="admin";
		testData[1][2]="Invalid credentials";
		
		
		testData[2][0]="";
		testData[2][1]="";
		testData[2][2]="Username cannot be empty";
		
		
		testData[3][0]="asashdsaj";
		testData[3][1]="";
		testData[3][2]="Password cannot be empty";
		
		
		testData[4][0]="Admin";
		testData[4][1]="admin123";
		testData[4][2]="Success"; //dashboard elements
		return testData;
	}
	
	
	
	@Test(dataProvider = "multipleUsers")
	public void verifyLogin(String unm,String pwd,String msg) {
		WebDriver driver =null;
		try {
			driver = AppUtil.getWebdriverInstance("https://opensource-demo.orangehrmlive.com/");
			LoginPO page = PageFactory.initElements(driver, LoginPO.class);
			page.enterUserName(unm);
			page.enterPassword(pwd);
			
			
			if(msg.equals("Success")) {
					DashboardPO dashboardpage = page.clickLoginWithDashboard();
					String actulmsg = page.getErrorMessage();
					Assert.assertNull(actulmsg);
					Assert.assertNotNull(dashboardpage.welcomeText());
					Assert.assertEquals(dashboardpage.welcomeText(), "Welcome "+unm);
			}else {
				page.clickLogin();
				String actulmsg = page.getErrorMessage();
				Assert.assertEquals(actulmsg, msg);
			}
		}catch(Exception e) {
			System.out.println("error");
		}finally {
			AppUtil.closeBrowserInstance(driver);
		}
	}
	
}
	

	
