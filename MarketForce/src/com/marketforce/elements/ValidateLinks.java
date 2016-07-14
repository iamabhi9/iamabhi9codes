package com.marketforce.elements;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.marketforce.utility.Configure;
import com.marketforce.utility.ConsoleLogs;
import com.marketforce.utility.GetUrl;
import com.marketforce.utility.LinkResults;
import com.marketforce.utility.Read_XLS;
import com.marketforce.utility.SuiteUtility;
import com.marketforce.utility.CoreFunctions;

public class ValidateLinks extends ElementBase{
	Read_XLS FilePath = null;	
	String TestCaseName = null;
	String expectedUrl= null;
	String TestSuiteName = null;
	String actualUrl= null;
	WebElement element=null;
	String result[]=new String[2];
	String expected= null;
	String linkText=null;
	
	@BeforeTest	
	public void checkCaseToRun() throws IOException, InterruptedException{
	    //Called init() function from SuiteBase class to Initialize .xls Files
		init();	
		FilePath = TestCaseListExcelOne;
		System.out.println("FilePath Is : "+FilePath);
		TestSuiteName = this.getClass().getSimpleName();	
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestSuiteName Is : ", TestSuiteName);
	}
	@DataProvider
	public Object[][] MFLinks(){
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestCaseName Is :","MFLinks");
		return SuiteUtility.GetTestDataUtility(FilePath, "MFLinks");	
		}
	
	@Test(dataProvider="MFLinks",priority=1)
	public void MFLinkStatus(String TestCaseId,String PageUrl,String linkName,String xPath,String ExpectedUrl) throws InterruptedException{
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs(linkName+"_"+TestCaseId, "Test Case Started");
		GetUrl.hitUrl(driver, PageUrl);
	
		actualUrl=CoreFunctions.ClickLink(driver, element, xPath);
		actualUrl=actualUrl.toLowerCase();
		ExpectedUrl=ExpectedUrl.toLowerCase();
		ConsoleLogs.PrintLogs("LinkStatus_"+linkName+"_", "Expected Url is "+ExpectedUrl);
		ConsoleLogs.PrintLogs("LinkStatus_"+linkName+"_","Actual Url Found is "+actualUrl);
		
		if(actualUrl.contains(ExpectedUrl))
		{
			ConsoleLogs.PrintLogs("LinkStatus_"+linkName, " PASS");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			ConsoleLogs.PrintLogs("LinkStatus_"+linkName, " FAIL");
		}
		
	}
	
	

	
		@AfterTest
		public void cleanup() throws InterruptedException{
			ConsoleLogs.PrintBoundry();
			driver.quit();
			Thread.sleep(20000);
		}
}
