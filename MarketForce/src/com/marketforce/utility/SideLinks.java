package com.marketforce.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SideLinks {
	public static WebDriver driver;
	public static WebElement element;
	public static String result=null;
	public static Actions action;
	public static String res[]=null;

	public static void getMenu(WebDriver driver, String xPath){
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(xPath)));
		action.click().build().perform();
		
	}
	public static String verifyMenuItem(WebDriver driver, String xPath1, String xPath2){
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(xPath1)));
		action.click().build().perform();
		driver.findElement(By.xpath(xPath2)).click();
		result=driver.getCurrentUrl();
		return result;
	}
	public static String verifyMenuItemName(WebDriver driver, String xPath1, String xPath2){
		Actions action=new Actions(driver);
 		action.moveToElement(driver.findElement(By.xpath(xPath1)));
		action.click().build().perform();

		result=driver.findElement(By.xpath(xPath2)).getText();
 
 		return result;
		}
	public static String verifyMenuItem(WebDriver driver, String xPath1, String xPath2,String xPath3){
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(xPath1)));
		action.click().build().perform();
		
		boolean status=driver.findElement(By.xpath(xPath3)).isDisplayed();
		if (status==false) {
			driver.findElement(By.xpath(xPath2)).click();

		} 
		
 		driver.findElement(By.xpath(xPath3)).click();

		result=driver.getCurrentUrl();
		System.out.println(result);
		return result;
	}
	public static String verifyMenuItemName(WebDriver driver, String xPath1, String xPath2,String xPath3){
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(xPath1)));
		action.click().build().perform();
		
		boolean status=driver.findElement(By.xpath(xPath3)).isDisplayed();
		if (status==false) {
			driver.findElement(By.xpath(xPath2)).click();

		} 
		
		result=driver.findElement(By.xpath(xPath3)).getText();
 		return result;
		}
	
}
