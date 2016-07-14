package com.marketforce.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	public static void waitInSec(WebDriver driver,int wait){
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		
	}
	public static void waitTillVisibilty(WebDriver driver,WebElement element){
		//driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20); //here, wait time is 20 seconds
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
