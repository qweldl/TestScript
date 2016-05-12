package com.ecalix.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public void setUp(){
		cm = new Common(driver);
		driver = cm.openBrowser("safari");
		cm.openURL("http://107.170.213.234/catalog/");

	}

	@AfterMethod
	public void tearDown() {

		cm.close();

	}

	@Test
	public void testLogin(){
		HomePage home = new HomePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		cm.clickElement(home.loginText());
		cm.getTitle();
		//Enter username
		loginpage.username().clear();
		loginpage.username().sendKeys("ExcelDriven.getCelldata(1, 1)");
		System.out.println("Enter username");
		
		//Enter password
		loginpage.password().clear();
		loginpage.password().sendKeys("ExcelDriven.getCelldata(1, 2)");
		System.out.println("Enter password");
		
		//Click log
		cm.clickElement(loginpage.signin());
		
				
	}

	
}
