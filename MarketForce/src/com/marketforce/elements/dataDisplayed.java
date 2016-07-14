package com.marketforce.elements;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.marketforce.utility.ConsoleLogs;
import com.marketforce.utility.GetUrl;
import com.marketforce.utility.Read_XLS;
import com.marketforce.utility.SideLinks;
import com.marketforce.utility.SuiteUtility;
import com.marketforce.utility.CoreFunctions;

public class dataDisplayed extends ElementBase{
	
	Read_XLS FilePath = null;	
	String TestCaseName = null;
	String TestSuiteName = null;
	String expected= null;
	String actual= null;
	String result[]=new String[2];
	String status=null;
	WebElement element=null;
	@BeforeTest	
	public void checkCaseToRun() throws IOException, InterruptedException{
	    //Called init() function from SuiteBase class to Initialize .xls Files
		init();	
		FilePath = TestCaseListExcelFive;
		System.out.println("FilePath Is : "+FilePath);
		TestSuiteName = this.getClass().getSimpleName();	
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestSuiteName Is : ", TestSuiteName);
		}
	
	
	
	
	
	
	@DataProvider
	public Object[][] isVisible(){
		//To check the class name of text box before and after inputing text and checking the class change after input
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestCaseName Is :","isVisible");
		return SuiteUtility.GetTestDataUtility(FilePath, "isVisible");	
		}
	
	
	
	
	@Test(dataProvider="isVisible",priority=1)
		public void textIsVisble(String TestCaseId,String PageName,String boxName,String xPath,String PageUrl,String input) throws InterruptedException{
		
			ConsoleLogs.PrintBoundry();
			ConsoleLogs.PrintLogs(PageName+"_"+boxName+"_"+TestCaseId, "Test Case Started");
			GetUrl.hitUrl(driver,PageUrl);	
			status=CoreFunctions.typeAndCheckVisible(driver, element, xPath,input);
			if(status.equalsIgnoreCase("Pass"))
			{
				Assert.assertTrue(true);
				ConsoleLogs.PrintLogs(PageName+"_"+boxName+"_"+TestCaseId, "PASS");
			}
			else
			{
				ConsoleLogs.PrintLogs(PageName+"_"+boxName+"_"+TestCaseId, "FAIL");
				Assert.assertTrue(false);
			}
			
				
	}
	
	
		@AfterTest
		public void cleanup() throws InterruptedException{
			ConsoleLogs.PrintBoundry();
			driver.quit();
			Thread.sleep(10000);
			
		}

}
