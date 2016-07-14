package com.marketforce.utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxUtility {
 public static String result=null;
 public static String class1=null;
 public static String class2=null;
public static	Boolean visibility=null;
public static String data1=null;

public static String data2=null;
public static String expURL=null;






 
 public static String getPlaceHolder(WebDriver driver,WebElement element,String Xpath){
	element = driver.findElement(By.xpath(Xpath));
	result=element.getAttribute("placeholder");
	return result;
 }
 public static String getPlaceHolderWithPt(WebDriver driver,WebElement element,String Xpath){
		element = driver.findElement(By.xpath(Xpath));
		result=element.getAttribute("pt-placeholder");
		return result;
	 }
 public static String typeAndValidateTextInput(WebDriver driver,WebElement element,String Xpath,String input) throws InterruptedException{
	element=driver.findElement(By.xpath(Xpath));
	element.clear();
	element.sendKeys(input);

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

 public static boolean CheckDropDown(WebDriver driver,WebElement element,String xPathBox, String XPathDrop)throws InterruptedException{
 
	 element=driver.findElement(By.xpath(xPathBox));
	 element.clear();
	 element=driver.findElement(By.xpath(XPathDrop));
	 data1=element.getText();
	 System.out.println(data1);
element.click();
element=driver.findElement(By.xpath(xPathBox));
data2=element.getAttribute("value");
System.out.println(data2);
if(data1.equals(data2)==true)
{
	return true;
}
else
{
	return false;
}

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
}
