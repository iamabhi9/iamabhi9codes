package com.marketforce.utility;

import com.marketforce.utility.Read_XLS;

public class FileLocations {
	public static String suiteone=System.getProperty("user.dir")+"/SuiteFiles/Links.xls";
	public static String suitetwo=System.getProperty("user.dir")+"/SuiteFiles/TextBoxes.xls";
	public static Read_XLS TestSuiteListExcel=null;	
	public static Read_XLS getSuite(String testCase){
		
		//Initializing Test Suite List(TestSuiteList.xls) File Path Using Constructor Of Read_XLS Utility Class.
		String suiteName="suite"+testCase;
		System.out.println("suite name is : "+suiteName);
		TestSuiteListExcel = new Read_XLS(suiteName);
		
		return TestSuiteListExcel;
	}
}
