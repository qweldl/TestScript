package com.catalog.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.catalog.common.Common;
import com.catalog.pageObjects.HomePage;
import com.catalog.pageObjects.LoginPage;

public class TestLogin {
	
	private WebDriver driver;
	private Logger logger;
	public Common cm;
	public HomePage homepage;
	public LoginPage loginpage;
	public Properties prop;
	public FileInputStream fis;
	
	@BeforeMethod
	@Parameters({"browserType"})
	public void setUp(String browserType) throws IOException{		
		logger = Logger.getLogger("Test");
		cm = new Common(driver);
		PropertyConfigurator.configure("/Users/yanbochen/Downloads/TestScript-master/log4j.properties");
		prop = new Properties();
		fis = new FileInputStream("/Users/yanbochen/Downloads/TestScript-master/config.properties");
		prop.load(fis);
		driver = cm.openBrowser(browserType);
		cm.openUrl();
	}
	
	@AfterMethod
	public void tearDown(){
		//cm.closeBrowser();
	}
	
	
	@Test	
	public void test1() throws IOException{
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		homepage.clicklogyourself();
		prop = new Properties();
		fis = new FileInputStream("/Users/yanbochen/Downloads/TestScript-master/config.properties");
		prop.load(fis);
		loginpage.enterUserName(prop.getProperty("username"));
		loginpage.enterPassword(prop.getProperty("password"));
		loginpage.clickSignInButton();
		homepage.logoff();
	}

}
