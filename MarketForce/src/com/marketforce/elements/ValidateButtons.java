package com.marketforce.elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.marketforce.utility.ConsoleLogs;
import com.marketforce.utility.CoreFunctions;
import com.marketforce.utility.GetUrl;
import com.marketforce.utility.Read_XLS;
import com.marketforce.utility.SuiteUtility;

public class ValidateButtons extends ElementBase{
	
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
		FilePath = TestCaseListExcelEight;
		System.out.println("FilePath Is : "+FilePath);
		TestSuiteName = this.getClass().getSimpleName();	
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestSuiteName Is : ", TestSuiteName);
		}
	
	
	
	
	
	
	@DataProvider
	public Object[][] InputButtonData(){
		//To check the class name of text box before and after inputing text and checking the class change after input
		ConsoleLogs.PrintBoundry();
		ConsoleLogs.PrintLogs("TestCaseName Is :","InputButtonData");
		return SuiteUtility.GetTestDataUtility(FilePath, "InputButtonData");	
		}
	
	
	
	
	@Test(dataProvider="InputButtonData",priority=1)
	public void InputButtonData(String TestCaseId,String PageName,String ButtonName,String PageUrl, String assertValue, String headInfo,String inputData1,String inputData2,String inputData3,String inputData4,
            String inputData5,String inputData6,String inputData7,String inputData8,String inputData9,String inputData10,String inputData11,
            String inputData12,String inputData13,String inputData14,String inputData15,String inputData16) throws InterruptedException, IOException{
    
        ConsoleLogs.PrintBoundry();
        ConsoleLogs.PrintLogs(PageName+"_"+ButtonName+"_"+TestCaseId, "Test Case Started");
        GetUrl.hitUrl(driver,PageUrl);  
        

         LinkedList<String> inputDataList=new LinkedList<String>();
         inputDataList=CoreFunctions.putIntoArray(inputData1,inputData2,inputData3,inputData4,inputData5,inputData6,inputData7,inputData8,inputData9,inputData10,inputData11,inputData12,inputData13,inputData14,inputData15,inputData16);
         
         LinkedList<String> xPathList=new LinkedList<String>();
         xPathList=CoreFunctions.ReadFromXl(FilePath.filelocation, ButtonName);

        int control;
        control=inputDataList.size()-xPathList.size()+1;
    //     System.out.println("C: "+control);
     //    System.out.println("d: "+inputDataList.size());
    //     System.out.println("X: "+xPathList.size());

       /*  for (int i = 0; i < inputDataList.size(); i++)

         {System.out.println(i+" "+inputDataList.get(i));
        	 
         }
         
          
         
        
         for (int i = 0; i < xPathList.size(); i++)

         {System.out.println(i+" "+xPathList.get(i));
        	 
         }
         */
         
         for (int i = 0; i < xPathList.size(); i++)

         {
              switch (headInfo.charAt(i))
             { 
              //Text Fields
             case 'T': CoreFunctions.type(driver, element, xPathList.get(i), inputDataList.get(i));
                          break;
             //Email Field
             case 'E': CoreFunctions.type(driver, element, xPathList.get(i), inputDataList.get(i));
             break;
             //For Mobile and Landine
             case 'N':  CoreFunctions.type(driver, element, xPathList.get(i), inputDataList.get(i));
             break;
             // For Dropdown
             case 'D': CoreFunctions.typeDropdown(driver, element, xPathList.get(i),inputDataList.get(i));
                 break;
                // For Multi select Dropdown
             case 'M':  CoreFunctions.TypeMultiDropDown(driver, element, xPathList.get(i),inputDataList.get(i));
             break;
             // For popup like calender
             case 'P':
              //For button like search and submit
             case 'B': CoreFunctions.clickButton(driver, element,  xPathList.get(i));
             break;
          
                 
             }
              
              
          }
    	 Thread.sleep(1500);

         
         boolean b = driver.getPageSource().contains(assertValue);

        // System.out.println(b);
     	 
			
		if(b==true)
			{
				Assert.assertTrue(true);
				ConsoleLogs.PrintLogs(PageName+"_"+ButtonName+"_"+TestCaseId, "PASS");
			}
			else
			{
				ConsoleLogs.PrintLogs(PageName+"_"+ButtonName+"_"+TestCaseId, "FAIL");
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
