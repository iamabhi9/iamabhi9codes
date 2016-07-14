package com.marketforce.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickPopsUp {

	public static boolean result=false;
	public static boolean verifyPopUp(WebDriver driver,WebElement element,String Xpath){
		driver.findElement(By.xpath(Xpath)).click();
		Wait.waitInSec(driver, 2);
		
		return result;
	}
}
