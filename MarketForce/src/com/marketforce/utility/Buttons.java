package com.marketforce.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Buttons {
public static String result="";

	public static String getText(WebDriver driver,WebElement element,String Xpath){
		element=driver.findElement(By.xpath(Xpath));
		result=element.getText();
		return result;
	}
	public static String clickAndGetText(WebDriver driver,WebElement element,String Xpath){
		element=driver.findElement(By.xpath(Xpath));
		element.click();
		result=driver.findElement(By.xpath(Xpath)).getText();
		return result;
	}
	public static String getButtonColour(WebDriver driver,WebElement element,String Xpath){
		element=driver.findElement(By.xpath(Xpath));
		result=element.getCssValue("background-color");
		return result;
		
	}

}
