package com.sauce.qa.testpage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sauce.qa.base.Base;
import com.sauce.qa.pageobject.LoginPage;

public class LoginPageTest extends Base {
	
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage= new LoginPage();
	}
	
	@DataProvider
	public Object getData()
	{
		Object obj[][]= new Object[2][2];
		
		obj[0][0]="standard_user";
		obj[0][1]="secret_sauce";
		
		obj[1][0]="invalid";
		obj[1][1]="123456";
		
		return obj;
		
		
	}
	
	@Test(dataProvider = "getData")
	public void validateLoginWithValidDataTest(String userName,String password)
	{
		String expectedTitle="PRODUCT";
		Assert.assertEquals(loginPage.validateLoginWithValidData(userName,password),expectedTitle);
	}
	
	@Test
	public void validateLoginWithInvalidDataTest()
	{
		String expectedError="Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(loginPage.validateLoginWithValidData("anish","1234"),expectedError);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
