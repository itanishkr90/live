package com.sauce.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.action.ActionDriver;
import com.sauce.qa.base.Base;

public class ProductPage extends Base {
	
	ActionDriver actionDriver = new ActionDriver();
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addToCart;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement drawer;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logout;
	
	public ProductPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void validateAddToCart()
	{
		actionDriver.click(driver, addToCart);
	}
	
	public void validateLogout()
	{
		actionDriver.click(driver, drawer);
		actionDriver.sleep(1000);
		actionDriver.click(driver, logout);
	}

}
