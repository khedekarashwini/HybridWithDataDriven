package com.prog.sele.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppUtil {

	public static WebDriver driver;
	
	public static WebDriver getWebdriverInstance(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yogesh\\Downloads\\chromedriver_win80.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}
	
	
	public static void closeBrowserInstance(WebDriver driver) {
		if(driver!=null)
			driver.close();
	}
	
	
}
