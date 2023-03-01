package com.sauce.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.action.ActionDriver;
import com.sauce.qa.base.Base;

public class LoginPage extends Base {
	
	ActionDriver actionDriver = new ActionDriver();
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//span[contains(text(),'Products')]")
	WebElement productTitle;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String validateLoginWithValidData(String username,String pass)
	{
		actionDriver.sleep(2000);
		actionDriver.type(userName, username);
		actionDriver.sleep(2000);
		actionDriver.type(password, pass);
		actionDriver.sleep(2000);
		actionDriver.click(driver, loginBtn);
		actionDriver.sleep(5000);
		String title=driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText().toString();
		return title;
	}
	public String validateLoginWithInvalidData(String username,String pass)
	{
		actionDriver.sleep(1000);
		actionDriver.type(userName, username);
		actionDriver.sleep(1000);
		actionDriver.type(password, pass);
		actionDriver.sleep(1000);
		actionDriver.click(driver, loginBtn);
		actionDriver.sleep(2000);
		String error=driver.findElement(By.cssSelector("div.login_wrapper div.login_wrapper-inner div.form_column div.login-box form:nth-child(1) > div.error-message-container.error:nth-child(3)")).getText().toString();
		return error;

		
	}
   
}
