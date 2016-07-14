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

public class TypeAndValidate extends ElementBase{
	
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
		FilePath = TestCaseListExcelTwo;
		System.out.println("FilePath Is : "+FilePath);
		TestSuiteName = this.getClass().getSimpleName();	
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestSuiteName Is : ", TestSuiteName);
		}
	
	
	

	@DataProvider
	public Object[][] TypeAndValidate(){
		//To retrieve data from Data 1 Column,Data 2 Column,Data 3 Column and Expected Result column of SuiteOneCaseOne data Sheet.
		//Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programatically when reading test data.
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestCaseName Is :","TypeAndValidate");
		return SuiteUtility.GetTestDataUtility(FilePath, "TypeAndValidate");	
		}
	
	
	
	
	
	@Test(dataProvider="TypeAndValidate",priority=1)
	public void typeAndValidate(String TestCaseId,String PageName,String boxName,String Xpath,String PageUrl,String Expected) throws InterruptedException{
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs(PageName+"_"+boxName+"_"+TestCaseId, "Test Case Started");
		GetUrl.hitUrl(driver,PageUrl);		
        actual=CoreFunctions.typeAndValidateTextInput(driver, element, Xpath,Expected);
		ConsoleLogs.PrintLogs(PageName+"_"+boxName+"_"+TestCaseId, "Expected Typed value "+Expected);
		ConsoleLogs.PrintLogs(PageName+"_"+boxName+"_"+TestCaseId, "Actual Typed value "+actual);		


		if(actual.equalsIgnoreCase(Expected))
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
