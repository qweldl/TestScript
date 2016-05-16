package com.catalog.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.catalog.common.Common;
public class LoginPage {

	private WebDriver driver;
	private Common cm;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		cm = new Common(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.NAME, using = "email_address")
    private WebElement EMAILADDRESS;
    
    @FindBy(how = How.NAME, using = "password")
    private WebElement PASSWORD;
	
    @FindBy(how = How.XPATH, using = "//*[@id='tdb5']/span[1]")
    private WebElement SIGNIN;
	
    public void enterUserName(String username){
		cm.setValue(EMAILADDRESS, username);	
	}
	
	public void enterPassword(String password){
		cm.setValue(PASSWORD, password);	
	}
	
	public void clickSignInButton(){	   
		SIGNIN.click();
		System.out.println("Sign In Clicked");
	}
}
