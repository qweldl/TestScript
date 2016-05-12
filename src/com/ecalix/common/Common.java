package com.ecalix.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class Common {

	private WebDriver driver;
	
	public Common(WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver openBrowser(String browser){
		
		if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/yanbochen/Documents/workspaceQA/CatalogNew/drivers/chromedriver");
			driver = new ChromeDriver();
		} else if(browser.equals("safari")){
			driver=new SafariDriver();
		} else if(browser.equals("firefox")){
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts()
		        .implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Opening the browser");
		return driver;
	}
	

	public void openURL(String URL){
		driver.get(URL);
		System.out.println("open the URL");
	}
	
	public void close(){
		driver.close();
		System.out.println("Browser is closing");
	}
	

	public void getTitle(){
		String title = driver.getTitle();
		System.out.println("The page title is: "+ title);
	
	}
	
	public void clickElement(WebElement element){
		String elementText = element.getText();
		try{
			element.click();
			if(elementText==null){
				System.out.println("is clicked");
			}else{
			System.out.println("element " + elementText +  " is clicked");
			}
		}catch(Exception e){
			System.out.println("element not found");
		}
	}
	
	public void mouseOver(WebElement webelement){
		Actions ac = new Actions(driver);
		ac.moveToElement(webelement).build().perform();
		System.out.println("move mouse to the element ");
	}

	
	public void verifyText(String expected, String actual){
	   if(expected.equals(actual)){
		   System.out.println("Actual text: " + actual +" is equal to expected text " + expected);
	   }else{
		   System.out.println("Actual text: " + actual +" is not equal to expected text " + expected);
	   }
	}
	
	public void verifyNumber(int expected, int actual){
		   if(expected==actual){
			   System.out.println("Actual number: " + actual +" is equal to expected number " + expected);
		   }else{
			   System.out.println("Actual number: " + actual +" is not equal to expected number " + expected);
		   }
		}
	
}
