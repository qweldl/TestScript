package com.ecalix.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecalix.common.Common;

public class HomePage {

	private WebDriver driver;
	public Common cm;

	@FindBy(xpath = ".//*[@id='bodyContent']/div/div[1]/a[1]/u")
	WebElement loginText;
	
	@FindBy(xpath = ".//*[@id='bodyContent']/div/div[1]/a[2]/u")
	WebElement createAccount;

	public HomePage(WebDriver driver) {
		cm = new Common(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement loginText() {
		return loginText;
	}
	
	public WebElement createAccount() {
		return createAccount;
	}

}
