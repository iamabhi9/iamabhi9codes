package com.marketforce.utility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Configure {
	//base url to test
	public static String BaseURL="http://dev1-market.proptiger-ws.com";
	public static String ExpUrl="http://dev1-market.proptiger-ws.com";
	//public static String BaseURL="http://dev1-market.proptiger-ws.com";
	//public static String ExpUrl="http://dev1-market.proptiger-ws.com";
	//DB configuration
	public static String DBURL="jdbc:mysql://192.168.0.28/proptiger";
	
	public static String DBUser="root";
	public static String DBPass="root";
	public static WebDriver driver= null;
	public static int PassCount=0;
	public static int FailCount=0;
	public static int SkipCount=0;
	public static int wait=5;

	//Initialize driver with browser
	public static String UrlToHit(){
		return BaseURL;
	}
	public static String ExpectedBaseURl(){
		
		return ExpUrl;
	}
	
	public static WebDriver LaunchBrowser(String BrowserType,WebDriver driver)
	{
		//WebDriver driver=null;
		if (BrowserType.equalsIgnoreCase("Firefox"))	
		  { driver=new FirefoxDriver();		}		   
		    else if (BrowserType.equalsIgnoreCase("Chrome"))	
		     {
		    	System.setProperty("webdriver.chrome.driver","chromedriver");
		    	driver=new ChromeDriver();	
		     }
		   else 	{
			   		System.out.println("Browser not supported currently...");	
		   			}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
	}
	public static void getUrl(String url,int wait){
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}
	public static void delay(int t){
		driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
	}
		
	}
	
