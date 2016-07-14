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
import com.marketforce.utility.SideLinks;;


public class ValidateSideLinks  extends ElementBase{
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
		FilePath = TestCaseListExcelThree;
		System.out.println("FilePath Is : "+FilePath);
		TestSuiteName = this.getClass().getSimpleName();	
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestSuiteName Is : ", TestSuiteName);
		}
	
	
	
	@DataProvider
	public Object[][] SideLinks(){
		//To retrieve data from Data 1 Column,Data 2 Column,Data 3 Column and Expected Result column of SuiteOneCaseOne data Sheet.
		//Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programatically when reading test data.
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestCaseName Is :","SideLinks");
		return SuiteUtility.GetTestDataUtility(FilePath, "SideLinks");	
		}
	
	@DataProvider
	public Object[][] SideLinksURL(){
		//To retrieve data from Data 1 Column,Data 2 Column,Data 3 Column and Expected Result column of SuiteOneCaseOne data Sheet.
		//Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programatically when reading test data.
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestCaseName Is :","SideLinksURL");
		return SuiteUtility.GetTestDataUtility(FilePath, "SideLinksURL");	
		}


	
	@Test(dataProvider="SideLinks",priority=1)
	public void SideLinks(String TestCaseId,String LabelName,String x_nav,String x_group,String x_subGrp) throws InterruptedException{
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs(LabelName+"_"+TestCaseId, "Test Case Started");
 		if (x_subGrp.length()>1)
		{ 	 actual=SideLinks.verifyMenuItemName(driver,x_nav,x_group,x_subGrp);

 		
		}
		else
		{ 
 			  actual=SideLinks.verifyMenuItemName(driver,x_nav,x_group);

		}
 		
 		
			if (actual.contains(LabelName))
			{    
				Assert.assertTrue(true);
				ConsoleLogs.PrintLogs(TestCaseId+"-"+LabelName, "PASS");
			
			}
			else
			{Assert.assertTrue(false);
			ConsoleLogs.PrintLogs(TestCaseId+"-"+LabelName, "FAIL");
		
				
			}
		
		
   
	}
	
	@Test(dataProvider="SideLinksURL",priority=1)
	public void SideLinksURL(String TestCaseId,String LabelName,String x_nav,String x_group,String x_subGrp, String ExpURL) throws InterruptedException{
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs(LabelName+"_"+TestCaseId, "Test Case Started");
 		if (x_subGrp.length()>1)
		{ 	 actual=SideLinks.verifyMenuItem(driver,x_nav,x_group,x_subGrp);
		
		}
 		else
 		{			 actual=SideLinks.verifyMenuItem(driver,x_nav,x_group);

 			
 		}
		
 		
 		
			if (actual.contains(ExpURL))
			{    
				Assert.assertTrue(true);
				ConsoleLogs.PrintLogs(TestCaseId+"-"+LabelName, "PASS");
			
			}
			else
			{Assert.assertTrue(false);
			ConsoleLogs.PrintLogs(TestCaseId+"-"+LabelName, "FAIL");
		
				
			}
		
		
   
	}
	
	@AfterTest
	public void cleanup() throws InterruptedException{
		ConsoleLogs.PrintBoundry();
		driver.quit();
		Thread.sleep(10000);
		
	}
	
	
	
	

}
