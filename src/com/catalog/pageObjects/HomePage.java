package com.catalog.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.catalog.common.Common;

public class HomePage {
	
	private WebDriver driver;
	private Common cm;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		cm = new Common(driver);
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath=".//*[@id='bodyContent']/div/div[1]/a[1]/u")
	WebElement logyourself;
	
	public void clicklogyourself(){
		cm.click(logyourself);
	}
}
