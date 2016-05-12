package com.ecalix.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ecalix.common.Common;
import com.ecalix.pageobjects.HomePage;
import com.ecalix.pageobjects.LoginPage;


public class Test1 {

	private WebDriver driver;
	public Common cm;
	public HomePage HomePage;
	public LoginPage LoginPage;

	@BeforeMethod
	public void setUp() {
		cm = new Common(driver);
		driver = cm.openBrowser();
		cm.openURL("http://107.170.213.234/catalog/");

	}

	@AfterMethod
	public void tearDown() {

		//cm.close();

	}

	@Test
	public void testLogin(){
		HomePage home = new HomePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		cm.clickElement(home.loginText());
		cm.getTitle();
		//Enter username
		loginpage.username().clear();
		loginpage.username().sendKeys("ecalix@test.com");
		
		//Enter password
		loginpage.password().clear();
		loginpage.password().sendKeys("test123");
		
		//Click login
		cm.clickElement(loginpage.signin());
		
		cm.getTitle();
		
				
	}

	
}
