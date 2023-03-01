package com.sauce.qa.testpage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.qa.base.Base;
import com.sauce.qa.pageobject.LoginPage;
import com.sauce.qa.pageobject.ProductPage;

public class ProductPageTest extends Base {
	
	ProductPage productPage;
	LoginPage loginPage;
	
	public ProductPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage= new LoginPage();
		loginPage.validateLoginWithValidData("standard_user","secret_sauce");
		productPage = new ProductPage();
	}
	
	@Test
	public void validateAddToCartTest()
	{
		productPage.validateAddToCart();
	}
	
	@Test
	public void validateLogoutTest()
	{
		productPage.validateLogout();
	}
}
