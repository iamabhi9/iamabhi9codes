package com.marketforce.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.marketforce.utility.Wait;

public class LinkResults {
	public static String result="";
	public static String res[]=new String[2];
	//Function to return url of social sites
	public static String GetTextElement(WebDriver driver,WebElement element,String Xpath){
		element=driver.findElement(By.xpath(Xpath));
		result=element.getText();
		return result;
	}
	public static String socialLinks(WebDriver driver,WebElement element,String Xpath){
		String winHandleBefore = driver.getWindowHandle();					
		element=driver.findElement(By.xpath(Xpath));
		element.click();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		Wait.waitInSec(driver, 2);
		result=driver.getCurrentUrl();
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return result;
	}
	//Function to return redirect url which open in same window
	public static String[] linksInSameTab(WebDriver driver,WebElement element,String Xpath){					
		element=driver.findElement(By.xpath(Xpath));
		res[0]=element.getText();
		element.click();
		Wait.waitInSec(driver, 2);
		res[1]=driver.getCurrentUrl();
		return res;
	}
	//Function to return redirect url which open in new window
	public static String[] linksInDiffTab(WebDriver driver,WebElement element,String Xpath){					
		String winHandleBefore = driver.getWindowHandle();
		element=driver.findElement(By.xpath(Xpath));
		res[0]=element.getText();
		element.click();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		Wait.waitInSec(driver, 2);
		res[1]=driver.getCurrentUrl();		
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return res;
	}
	//Function to return redirect url with dynamic links text
	public static String[] dynamicLinks(WebDriver driver,WebElement element,String Xpath1,String Xpath2){
		element=driver.findElement(By.xpath(Xpath1));
		res[0]=element.getText();
		element.click();
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
		Wait.waitInSec(driver, 1);
		element=driver.findElement(By.xpath(Xpath2));
		res[1]=element.getText();
		return res;
	}
	public static String[] dynamicLinksWithclick(WebDriver driver,WebElement element,String Xpath1,String Xpath2,String Xpath3){
		String res[]=new String[2];
		element=driver.findElement(By.xpath(Xpath3));
		element.click();
		Wait.waitInSec(driver, 2);
		element=driver.findElement(By.xpath(Xpath1));		
		res[0]=element.getText();
		element.click();
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
		Wait.waitInSec(driver, 2);
		element=driver.findElement(By.xpath(Xpath2));
		res[1]=element.getText();
		return res;
	}
}
