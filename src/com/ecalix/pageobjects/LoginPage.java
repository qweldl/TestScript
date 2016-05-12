package com.ecalix.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecalix.common.Common;

public class LoginPage {

	private WebDriver driver;
	public Common cm;

	@FindBy(name = "email_address")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id = "tdb5")
	WebElement signin;

	public LoginPage(WebDriver driver) {
		cm = new Common(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement username() {
		return username;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement signin() {
		return signin;
	}

}
