package com.marketforce.begins;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.marketforce.utility.GetUrl;
import com.marketforce.utility.Read_XLS;
import com.marketforce.utility.Wait;

public class GetSetup {
	public static WebDriver driver= null;
	public static Read_XLS TestCaseListExcelOne=null;
	public static Read_XLS TestCaseListExcelTwo=null;
	public static Read_XLS TestCaseListExcelThree=null;
	public static Read_XLS TestCaseListExcelFour=null;
	public static Read_XLS TestCaseListExcelFive=null;
	public static Read_XLS TestCaseListExcelSix=null;
	public static Read_XLS TestCaseListExcelSeven=null;
	public static Read_XLS TestCaseListExcelEight=null;


public static String suiteone=System.getProperty("user.dir")+"/SuiteFiles/ValidateLinks.xls";
	public static String suitetwo=System.getProperty("user.dir")+"/SuiteFiles/ValidateTextItens.xls";
public static String suitethree=System.getProperty("user.dir")+"/SuiteFiles/ValidateSideLinks.xls";
public static String suitefour=System.getProperty("user.dir")+"/SuiteFiles/PlaceHolderAnimation.xls";
public static String suitefive=System.getProperty("user.dir")+"/SuiteFiles/dataDisplayed.xls";
public static String suitesix=System.getProperty("user.dir")+"/SuiteFiles/Verifyheading.xls";
public static String suiteseven=System.getProperty("user.dir")+"/SuiteFiles/testTypeAhead.xls";
public static String suiteeight=System.getProperty("user.dir")+"/SuiteFiles/ValidateButtons.xls";

	public void init() throws IOException, InterruptedException{
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.get("http://dev1-market.proptiger-ws.com");
	//	driver.get("http://dev1-market.proptiger-ws.com");

	driver.findElement(By.name("username")).sendKeys("vipin.s@makaan.com");
	 driver.findElement(By.name("password")).sendKeys("12345");
	 driver.findElement(By.id("loginsubmit")).click();
TestCaseListExcelOne=new Read_XLS(suiteone);
	TestCaseListExcelTwo=new Read_XLS(suitetwo);
	TestCaseListExcelThree=new Read_XLS(suitethree);
	TestCaseListExcelFour=new Read_XLS(suitefour);
	TestCaseListExcelFive=new Read_XLS(suitefive);
	TestCaseListExcelSix=new Read_XLS(suitesix);
	TestCaseListExcelSeven=new Read_XLS(suiteseven);

	TestCaseListExcelEight=new Read_XLS(suiteeight);

	}
}
