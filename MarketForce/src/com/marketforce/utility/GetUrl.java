package com.marketforce.utility;

import org.openqa.selenium.WebDriver;

public class GetUrl {
	
	public static void hitUrl(WebDriver driver,String path) throws InterruptedException
    {
		String newUrl=Configure.BaseURL+path;
	    driver.get(newUrl);
        //new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loadingBarInfo']")));
        Wait.waitInSec(driver, 5); 
    }
}
