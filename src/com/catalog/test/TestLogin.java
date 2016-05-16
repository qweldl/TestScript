package com.catalog.test;

import java.io.FileInputStream;
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
	
	@BeforeMethod
	@Parameters({"browserType"})
	public void setUp(String browserType) throws IOException{		
		logger = Logger.getLogger("Test");
		cm = new Common(driver);
		PropertyConfigurator.configure("C:\\Users\\Yanbo\\Projects\\project\\automationJava\\log4j.properties");
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Yanbo\\Projects\\project\\automationJava\\config.properties");
		prop.load(fis);
		driver = cm.openBrowser(browserType);
		cm.openUrl();
	}
	
	@AfterMethod
	public void tearDown(){
		cm.closeBrowser();
	}
	
	
	@Test	
	public void test1(){
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.clickSignInButton();
		//loginpage.username().sendKeys();
		logger.info("see me");
	}

}
