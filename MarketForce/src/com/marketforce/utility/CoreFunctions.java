package com.marketforce.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class CoreFunctions {
 public static String result=null;
 public static String class1=null;
 public static String class2=null;
public static	Boolean visibility=null;
public static String data1=null;

public static String data2=null;
public static String expURL=null;


 public static String typeAndValidateTextInput(WebDriver driver,WebElement element,String Xpath,String input) throws InterruptedException{
	element=driver.findElement(By.xpath(Xpath));
	element.clear();
	element.sendKeys(input);
Thread.sleep(1000);
	result=element.getAttribute("value");
	return result;
 }
 
 public static void type(WebDriver driver,WebElement element,String Xpath,String input) throws InterruptedException{
	element=driver.findElement(By.xpath(Xpath));
	element.sendKeys(input);
}
 public static String returnValue(WebDriver driver,WebElement element,String Xpath) throws InterruptedException{
	element=driver.findElement(By.xpath(Xpath));
	result=element.getAttribute("value");
	return result;
 }
 
 
 
 public static String typeAndCheckClass(WebDriver driver,WebElement element,String xPath, String input) throws InterruptedException{
		element=driver.findElement(By.xpath(xPath));
		String parent_xpath = new String (xPath.substring(0, xPath.length()-6));
		class1=driver.findElement(By.xpath(parent_xpath)).getAttribute("class");
		element.clear();
		element.sendKeys(input);
		element.sendKeys(Keys.TAB);
		class2=driver.findElement(By.xpath(parent_xpath)).getAttribute("class");


		if (!class1.equals("")==true && class2.contains("active")==true)
		{    				
				return "Pass";
			
			
		 
		}
		else
		{
			return "Fail";

		}
		
		

	 }
 
 public static String typeAndCheckVisible(WebDriver driver,WebElement element,String xPath, String input) throws InterruptedException{
		element=driver.findElement(By.xpath(xPath));
		String parent_xpath = new String (xPath.substring(0, xPath.length()-6));
		class1=driver.findElement(By.xpath(parent_xpath)).getAttribute("class");
		element.clear();

		element.sendKeys(input);
		element.sendKeys(Keys.TAB);
		element=driver.findElement(By.xpath(parent_xpath));
		visibility=element.isDisplayed();
		
 if (visibility==true)
 {    				
		return "Pass";
	
	

}
else
{
	return "Fail";

}

 }
 
 
 public static String CheckExsist(WebDriver driver,WebElement element,String xPath, String input) throws InterruptedException{
 	
	 element=driver.findElement(By.xpath(xPath));
 		System.out.println(element.getText());
  
	
return "Pass";
		
		

	 }

 public static void typeDropdown(WebDriver driver,WebElement element,String xPathBox,String inputText)throws InterruptedException{
 
 	 String xPathDown=null;
	 xPathDown=xPathBox.substring(xPathBox.indexOf(",")+1, xPathBox.length());
	 xPathBox=xPathBox.substring(0, xPathBox.indexOf(","));
	 element=driver.findElement(By.xpath(xPathBox));
	 element.clear();
	 element.sendKeys(inputText);
	 Thread.sleep(2000);

	 System.out.println(xPathDown);
	 element=driver.findElement(By.xpath(xPathDown));
  element.click();


 }

 
 
 
 public static boolean CheckDropDown(WebDriver driver,WebElement element,String xPathBox, String XPathDrop)throws InterruptedException{
 
	 element=driver.findElement(By.xpath(xPathBox));
	 element.clear();
	 element=driver.findElement(By.xpath(XPathDrop));
	 data1=element.getText();
 element.click();
element=driver.findElement(By.xpath(xPathBox));
data2=element.getAttribute("value");
 if(data1.equals(data2)==true)
{
	return true;
}
else
{
	return false;
}

 }
 
 
 
 
 
public static void TypeMultiDropDown(WebDriver driver,WebElement element,String xPathBox,String inputText)throws InterruptedException{
	 String xPathDown=null;
	 xPathDown=xPathBox.substring(xPathBox.indexOf(",")+1, xPathBox.length());
	 xPathBox=xPathBox.substring(0, xPathBox.indexOf(","));
	 element=driver.findElement(By.xpath(xPathBox));
	 element.clear();
	 Thread.sleep(500);
	 element.sendKeys(inputText);
	 Thread.sleep(2000);
	 System.out.println(xPathDown);

	 element=driver.findElement(By.xpath(xPathDown));
 	 element.click();
 	 element=driver.findElement(By.xpath(xPathBox));
 
    element.sendKeys(Keys.TAB);

}

 
 
 
public static boolean CheckTypeAheadDropDown(WebDriver driver,WebElement element,String xPathBox, String XPathDrop)throws InterruptedException{
	 
	 element=driver.findElement(By.xpath(xPathBox));
	 element=driver.findElement(By.xpath(xPathBox));
	 element.clear();
	 Thread.sleep(2000);
	 element=driver.findElement(By.xpath(XPathDrop));
	 data1=element.getText();
	     element.click();
 	 element=driver.findElement(By.xpath(xPathBox));
 
element.sendKeys(Keys.TAB);
 xPathBox = new String (xPathBox.substring(0, xPathBox.length()-9));
 xPathBox=xPathBox.concat("/div[1]/div");
 	 element=driver.findElement(By.xpath(xPathBox));
	 
	 data2=element.getAttribute("value");
 	 data2=element.getText();
 
if ( data1.equals(data2)==true)
{
	return true;
}
else
{
	return false;
}
	
 	 
	
}

	
	 
	 
	 
  
	 
	 
 
 public static boolean SelectAndCheckDropDown(WebDriver driver,WebElement element,String xPathBox, String XPathDrop,String data)throws Exception{
	 element=driver.findElement(By.xpath(xPathBox));
	 element.clear();
 	 element.sendKeys(data);
 	 //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 Thread.sleep(2000);
	 element=driver.findElement(By.xpath(XPathDrop));
	 data1=element.getText();
  element.click();
 	 element=driver.findElement(By.xpath(xPathBox));
	 element.sendKeys(Keys.TAB);
 	 data2=element.getAttribute("value");
 
if (data1.contains(data)==true && data1.equals(data2)==true)
{
	return true;
}
else
{
	return false;
}
	
 	 
	 
 } 
 
 
 
 public static boolean SelectAndCheckDropDownTwo(WebDriver driver,WebElement element,String xPathBox, String XPathDrop,String data)throws Exception{
	 element=driver.findElement(By.xpath(xPathBox));
	 element.clear();
 	 element.sendKeys(data);
 	 //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 Thread.sleep(2000);
	 element=driver.findElement(By.xpath(XPathDrop));
	 data1=element.getText();
	     element.click();
 	 element=driver.findElement(By.xpath(xPathBox));
 
element.sendKeys(Keys.TAB);
 xPathBox = new String (xPathBox.substring(0, xPathBox.length()-9));
 xPathBox=xPathBox.concat("/div[1]/div");
 	 element=driver.findElement(By.xpath(xPathBox));
	 
	 data2=element.getAttribute("value");
 	 data2=element.getText();
 
if (data1.contains(data)==true && data1.equals(data2)==true)
{
	return true;
}
else
{
	return false;
}
	
 	 
	
}
 

 
 
 public static String ClickLink(WebDriver driver,WebElement element,String xPath)throws InterruptedException
 {
	 element=driver.findElement(By.xpath(xPath));
	 String winHandleBefore = driver.getWindowHandle(); 

	 element.click();
	 int i=0;
	 for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		   ++i;
		}

	 
	
	 expURL=driver.getCurrentUrl();
	 
	 if (i==2)
	 driver.close();
	 
	 driver.switchTo().window(winHandleBefore);
	 
 	 return expURL;

	 
 }
 
 public static LinkedList<String> putIntoArray(String inputData1,String inputData2,String inputData3,String inputData4,String inputData5,
         String inputData6,String inputData7,String inputData8,String inputData9,String inputData10,
         String inputData11,String inputData12,String inputData13,String inputData14,
         String inputData15,String inputData16)throws InterruptedException
 {  
  LinkedList<String> dataList = new LinkedList<String>();
 
 dataList.add(inputData1);
 dataList.add(inputData2);
 dataList.add(inputData3);
 dataList.add(inputData4);
 dataList.add(inputData5);
 dataList.add(inputData6);
 dataList.add(inputData7);
 dataList.add(inputData8);
 dataList.add(inputData9);
 dataList.add(inputData10);
 dataList.add(inputData11);
 dataList.add(inputData12);
 dataList.add(inputData13);
 dataList.add(inputData14);
 dataList.add(inputData15);
 dataList.add(inputData16);
   

     return dataList;
 }
 
 public static void clickButton(WebDriver driver,WebElement element,String xPath)throws InterruptedException
 { element=driver.findElement(By.xpath(xPath));
     element.click();
 }
 
 
 public static LinkedList<String>  ReadFromXl(String SheetPath, String Sheet)throws InterruptedException, IOException
 {  
 		FileInputStream fs = new FileInputStream(SheetPath);
 	HSSFWorkbook wb = new HSSFWorkbook(fs);
 	HSSFSheet sheet = wb.getSheet(Sheet);
 	LinkedList<String> xPathList = new LinkedList<String>(); 
 	int totalNoOfRows = sheet.getLastRowNum();
 			
 	for (int i=1;i<=totalNoOfRows;i++)
 	{    		
 		HSSFRow row = sheet.getRow(i);

	int totalNoOfCols = row.getLastCellNum();
	System.out.println("totalNoOfCols: "+totalNoOfCols);
	 
	for (int j=0;j<=totalNoOfCols;j++)
	{ System.out.println(row.getCell(j));
	if (row.getCell(j)==null)
		break;
	
	xPathList.add(row.getCell(j).toString());
	}
	
	
	
}
	return xPathList;}
 
}
