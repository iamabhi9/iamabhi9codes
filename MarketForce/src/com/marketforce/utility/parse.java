package com.marketforce.utility;


public class parse {
	public static Read_XLS TestCaseListExcelSeven=null;
	public static String suiteseven=System.getProperty("user.dir")+"/SuiteFiles/ValidateButtons.xls";

	public static void main (String args[])
	{
		String data="TTDTDPB";
		int t=0;
		int d=0;
		int b=0;
		System.out.println("a");
		System.out.println("Path: "+suiteseven);
		System.out.print("return value: "+f1());
	}
		public static Object[][] f1(){
			//To check the class name of text box before and after inputing text and checking the class change after input
			ConsoleLogs.PrintBoundry();
			TestCaseListExcelSeven=new Read_XLS(suiteseven);
			//Read_XLS FilePath = /home/tech-user/mytests/MarketForce/SuiteFiles/ValidateButtons.xls;
			Read_XLS FilePath = TestCaseListExcelSeven;
			ConsoleLogs.PrintLogs("TestCaseName Is :","isVisible");
			return SuiteUtility.GetTestDataUtility(FilePath, "f1");	
			}
		
		
		
	}
	

