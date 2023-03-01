package com.sauce.qa.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sauce.qa.utility.DataUtility;

public class Base {
	
    public static  WebDriver driver;
	public static Properties prop;
	public static String properties_path="C:\\Users\\user\\eclipse-workspace\\Sauce\\src\\main\\java\\com\\sauce\\qa\\configuration\\config.properties";
	public static BufferedReader reader;
	
	public Base()
	{
		try
		{
		reader=new BufferedReader(new FileReader(properties_path));
		prop=new Properties();
		prop.load(reader);
		}
		catch(FileNotFoundException fis)
		{
			fis.printStackTrace();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
	}
	
	public void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\Sauce\\chromedriver.exe");
			driver=new ChromeDriver();
		
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","");
			driver=new ChromeDriver();
		
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","");
			driver=new ChromeDriver();
		
		}
		else if(browserName.equalsIgnoreCase("opera"))
		{
			System.setProperty("webdriver.opera.driver","");
			driver=new ChromeDriver();
		
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DataUtility.pageLoadTime));
		driver.get(prop.getProperty("url"));
	}
	
	
	

}
