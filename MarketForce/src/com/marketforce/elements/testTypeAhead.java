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
import com.marketforce.utility.SuiteUtility;
import com.marketforce.utility.CoreFunctions;

public class testTypeAhead extends ElementBase{
	
	Read_XLS FilePath = null;	
	String TestCaseName = null;
	String TestSuiteName = null;
	String expected= null;
	String actual= null;
	String result[]=new String[2];
	String status=null;
	Boolean testStatus=null;
	WebElement element=null;
	@BeforeTest	
	public void checkCaseToRun() throws IOException, InterruptedException{
	    //Called init() function from SuiteBase class to Initialize .xls Files
		init();	
		FilePath = TestCaseListExcelSeven;
		System.out.println("FilePath Is : "+FilePath);
		TestSuiteName = this.getClass().getSimpleName();	
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestSuiteName Is : ", TestSuiteName);
		}
	
	
	
	
	
	
	@DataProvider
	public Object[][] ValidateDropDown(){
		//To check the class name of text box before and after inputing text and checking the class change after input
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestCaseName Is :","ValidateDropDown");
		return SuiteUtility.GetTestDataUtility(FilePath, "ValidateDropDown");	
		}
	
	@DataProvider
	public Object[][] ValidateTypeAheadDropDown(){
		//To check the class name of text box before and after inputing text and checking the class change after input
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestCaseName Is :","ValidateTypeAheadDropDown");
		return SuiteUtility.GetTestDataUtility(FilePath, "ValidateTypeAheadDropDown");	
		}
	
	@DataProvider
	public Object[][] ValidateDropDownData(){
		//To check the class name of text box before and after inputing text and checking the class change after input
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestCaseName Is :","ValidateDropDownData");
		return SuiteUtility.GetTestDataUtility(FilePath, "ValidateDropDownData");	
		}
	
	@DataProvider
	public Object[][] ValidateTypeAheadDropDownData(){
		//To check the class name of text box before and after inputing text and checking the class change after input
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestCaseName Is :","ValidateTypeAheadDropDownData");
		return SuiteUtility.GetTestDataUtility(FilePath, "ValidateTypeAheadDropDownData");	
		}
	
	
	
	@Test(dataProvider="ValidateDropDown",priority=1)
		public void ValidateDropDown(String TestCaseId,String PageName,String PageUrl,String xPathBox,String xPathDrop) throws InterruptedException{
		
			ConsoleLogs.PrintBoundry();
			ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "Test Case Started");
			GetUrl.hitUrl(driver,PageUrl);	
			testStatus=CoreFunctions.CheckDropDown(driver,element,xPathBox,xPathDrop);
			
			
			
			if(testStatus==true)
			{
				Assert.assertTrue(true);
				ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "PASS");
			}
			else
			{
				ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "FAIL");
				Assert.assertTrue(false);
			}
			
				
	}
	
	
	@Test(dataProvider="ValidateTypeAheadDropDown",priority=1)
	public void ValidateTypeAheadDropDown(String TestCaseId,String PageName,String PageUrl,String xPathBox,String xPathDrop) throws InterruptedException{
	
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "Test Case Started");
		GetUrl.hitUrl(driver,PageUrl);	
		testStatus=CoreFunctions.CheckTypeAheadDropDown(driver,element,xPathBox,xPathDrop);
		
		
		
		if(testStatus==true)
		{
			Assert.assertTrue(true);
			ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "PASS");
		}
		else
		{
			ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "FAIL");
			Assert.assertTrue(false);
		}
		
			
}
	
	
	
	@Test(dataProvider="ValidateDropDownData",priority=1)
	public void ValidateDropDownData(String TestCaseId,String PageName,String PageUrl,String xPathBox,String xPathDrop,String value) throws Exception{
	
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "Test Case Started");
		GetUrl.hitUrl(driver,PageUrl);	
		testStatus=CoreFunctions.SelectAndCheckDropDown(driver,element,xPathBox,xPathDrop,value);
		
		
		
		if(testStatus==true)
		{
			Assert.assertTrue(true);
			ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "PASS");
		}
		else
		{
			ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "FAIL");
			Assert.assertTrue(false);
		}
		
			
}
	
	
	
	@Test(dataProvider="ValidateTypeAheadDropDownData",priority=1)
	public void ValidateTypeAheadDropDownData(String TestCaseId,String PageName,String PageUrl,String xPathBox,String xPathDrop,String value) throws Exception{
	
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "Test Case Started");
		GetUrl.hitUrl(driver,PageUrl);	
		testStatus=CoreFunctions.SelectAndCheckDropDownTwo(driver,element,xPathBox,xPathDrop,value);
		
		
		
		if(testStatus==true)
		{
			Assert.assertTrue(true);
			ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "PASS");
		}
		else
		{
			ConsoleLogs.PrintLogs(PageName+"_"+"_"+TestCaseId, "FAIL");
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
