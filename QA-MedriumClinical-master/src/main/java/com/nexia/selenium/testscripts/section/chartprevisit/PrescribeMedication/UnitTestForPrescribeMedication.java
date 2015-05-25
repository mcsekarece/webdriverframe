package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForPrescribeMedication extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "On behalf Of Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOnBehalfOfWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_001";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Location Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLocationWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_002";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Method Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMethodWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_003";
		prescribeTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Quantity Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyQuantityWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_004";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUnitWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_005";
		prescribeTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Route Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRouteWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_006";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Frequency Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFrequencyWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_007";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Usage Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUsageWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_008";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Increase/Decrease Quantity Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseQuantityWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_009";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Increase/Decrease Unit Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseUnitWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_010";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Increase/Decrease Route Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseRouteWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_011";
		prescribeTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Increase/Decrease Frequency Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseFrequencyWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_012";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Increase/Decrease Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseDecreaseWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_013";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Increase Duration Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseDurationWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_014";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Increase Duration Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_015";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Increase Duration Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseStopWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_016";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Increase Duration Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleMethod1WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_017";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Quantity 1 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleQuantity1WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_018";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Unit1 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleUnit1WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_019";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Unit1 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleRoute1WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_020";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Frequency1 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleFrequency1WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_021";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Usage1 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleUsage1WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_022";
		prescribeTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple Method2 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleMethod2WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_023";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Quantity 2 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleQuantity2WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_024";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Unit2 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleUnit2WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_025";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Unit2 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleRoute2WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_026";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Frequency2 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleFrequency2WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_027";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Usage2 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleUsage2WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_028";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Duration1 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleDuration1WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_029";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Multiple directions Duration2 Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleDuration2WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_030";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Dispense with alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDispenseWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_031";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Dispense with Special Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDispenseWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_032";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Dispense with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDispenseWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_033";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Dispense with Decimal")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDispenseWithDecimal(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_034";
		prescribeTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Dispense Unit with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDispenseUnitWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_035";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Invalid Fill On date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void verifyFillOnWithInvalidDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_036";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Fill On date with spaces")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void verifyFillOnWithSpaces(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_037";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Fill On date with past date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void verifyFillOnWithPastDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_038";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " ReFill with alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReFillWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_039";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " ReFill with spcial characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReFillWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_040";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " ReFill with decimals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReFillWithDecimals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_041";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " ReFill duration with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReFillDurationWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_042";
		prescribeTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " ReFill duration with Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReFillDurationWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_043";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " ReFill duration with Special Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReFillDurationWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_044";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " ReFill duration with Special Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReFillDurationListWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_045";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Refill Method Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillMethodWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_046";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}  
	
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Refill Quantity Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillQuantityWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_047";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Refill Unit Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillUnitWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_048";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Refill Unit Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillRouteWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_049";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Refill Frequency Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillFrequencyWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_050";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Refill Usage Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillUsageWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_051";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Refill Duration Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillDurationWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_052";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "search pharmacy with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPharmacySearchWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_053";
		prescribeTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "zip with Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_054";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "zip with Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_055";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "zip with Special Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_056";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "zip with spaces")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipWithSpaces(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_057";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Fill On date with alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFillOnWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_058";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Fill On date with special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFillOnWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_059";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Increase decrease duration with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseDecreaseDurationWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_060";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Increase duration with decimals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseDurationWithDecimals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_061";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Increase duration with alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseDurationWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_062";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Increase duration with special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseDurationWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_063";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Target with decimals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetWithDecimals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_064";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Target with alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_065";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Target with special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_066";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description ="Increase/decrease Quantity with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseDecreaseQuantityWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_067";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Increase/Decrease Quantity with decimals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseDecreaseQuantityWithDecimals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_068";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Increase/Decrease Quantity with alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseDecreaseQuantityWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_069";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Increase/Decrease Quantity with special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncreaseDecreaseQuantityWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_070";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Free Text With Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEntertheFreeTextWithMaxValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_071";
		prescribeTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Free Text With Less Than Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEntertheFreeTextWithLessThan140characters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_072";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Free Text With Less Than Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEntertheFreeTextWith140Characters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_073";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Additional Directions With Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdditionalDirectionsWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_074";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Additional Directions With Less Than Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdditionalDirectionsWithLessThan140Characters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_075";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Additional Directions With Less Than Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdditionalDirectionsWith140Characters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_076";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Refills With Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNoOfRefillsWithMorethan2numbers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_077";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Refills With Less Than Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNoOfRefillsWithlessThan2numbers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_078";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Refills With Less Than Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNoofRefillsWith2numbers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_079";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Notes To Pharmacy With Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNotesToPharmacyWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_080";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Notes To Pharmacy With Less Than Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNotesToPharmacyWithlessThan70characters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_081";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Notes To Pharmacy With Less Than Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNotesToPharamacywith70characters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_082";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Dispense With Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDispenseWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_083";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Dispense With Less Than Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDispenseWithLessThan6numbers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_084";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Dispense With Less Than Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDispenseWith6numbers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_085";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Free Form Medication With Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFreeFormMedicationMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_086";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Dispense With Less Than Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchMedicationWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_087";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	@Test(groups ={"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = " Free Form Medication With Max length in CA view")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFreeFormMedicationMaxlengthCAView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_088";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Free Form Medication With Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFreeFormMedicationWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_089";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Additional directions With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdditionalDirectionWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ChartPreVisitLibUnitTest prescribeTestData = new  ChartPreVisitLibUnitTest();
		prescribeTestData.workSheetName = "UnitTest_Prescribe_Medication";
		prescribeTestData.testCaseId = "TC_PM_090";
		prescribeTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		prescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeTestData);
	}
	/**
	 * prescribeMedication
	 * function to perform unit test on the prescribe medication page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	     Sep 12, 2012
	 */
	
	public boolean prescribeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest prescribeTestData)throws Exception{
		Selenium selenium = null;
		String data;
		int count;
		int count1;
		
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeTestData.userName, prescribeTestData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//Step 2:Advanced search with Patient ID 										//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,prescribeTestData.patientID);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			if(!prescribeTestData.responsibleProvider.isEmpty())
				if(!prescribeTestData.responsibleProvider.contains("N/A"))
					selectValueFromAjaxList(selenium,ajxProvider,prescribeTestData.responsibleProvider);			
			click(selenium,"//body/div[4]/div/div/div/div/div");
			
				
			if(!prescribeTestData.location.isEmpty())
				if(!prescribeTestData.location.contains("N/A"))
					selectValueFromAjaxList(selenium,ajxLoaction,prescribeTestData.location);			
				click(selenium,"//body/div[4]/div/div/div/div/div");
			if(prescribeTestData.testCaseId.equals("TC_PM_086")||prescribeTestData.testCaseId.equals("TC_PM_089")){
				assertTrue(click(selenium, "css=button.primary-button"),"Could not click the free form button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
				else{
					if(prescribeTestData.testCaseId.equals("TC_PM_087")||prescribeTestData.testCaseId.equals("TC_PM_088") ){
						assertTrue(type(selenium, ajxDrugsList,prescribeTestData.freeText),"Could not type in the search box",selenium,ClassName,MethodName);
						waitForPageLoad(selenium);
						assertTrue(getText(selenium, "//div[4]/div/div/div/div/div").contains(""), "The search returned no results -  Not found",selenium,ClassName,MethodName);
				         return true;	
					}
				
				assertTrue(selectValueFromAjaxList(selenium, ajxDrugsList,"c"),"Could not type in the search box",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				//assertTrue(click(selenium, "//td[2]/div/div/div[4]/div[2]/div[3]/button"),"Could not click the search button");
				assertTrue(click(selenium, "link=Edit"),"Could not select the medication",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				waitForPageLoad(selenium);
				//Check if the "Proceed Anyway" Button is present
				if(isElementPresent(selenium,btnCancelButton)){
					assertTrue(click(selenium,btnCancelButton),"Could not Click Proceed Anyway button",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
				}
				
				}
					
			
			if(prescribeTestData.testCaseId.equals("TC_PM_002") || prescribeTestData.testCaseId.equals("TC_PM_001")){
				if(prescribeTestData.validationFieldID.equals("")){
					return true;
				}
				assertTrue(isElementPresent(selenium, prescribeTestData.validationFieldID), "The validation message field did not appear",selenium,ClassName,MethodName);
				assertTrue(getText(selenium, prescribeTestData.validationFieldID).contains(prescribeTestData.validationMessage), "The expected validation message should contain the text - "+ prescribeTestData.validationMessage + " The actual validation message shown - " + getText(selenium, prescribeTestData.validationFieldID),selenium,ClassName,MethodName);
				return true;
			}
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeTestData.reason),"Could not type reason;More Details:"+prescribeTestData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeTestData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in prescribe mediation//
			//--------------------------------------------------------------------//
			assertTrue(prescribeMedicationUnitTest(selenium, prescribeTestData), "Unit test failed",selenium,ClassName,MethodName);
			
			if(prescribeTestData.testCaseId.equals("TC_PM_089")){
				
				assertTrue(isElementPresent(selenium, prescribeTestData.validationFieldID), "The validation message field did not appear",selenium,ClassName,MethodName);
				assertTrue(getText(selenium, prescribeTestData.validationFieldID).contains(prescribeTestData.validationMessage), "The expected validation message should contain the text - "+ prescribeTestData.validationMessage + " The actual validation message shown - " + getText(selenium, prescribeTestData.validationFieldID),selenium,ClassName,MethodName);
				return true;
			}
			
			prescribeTestData.validationFieldID = prescribeTestData.validationFieldID == null ? prescribeTestData.validationFieldID = "" : prescribeTestData.validationFieldID.trim();
			
			if(prescribeTestData.validationFieldID.equals("")){
				return true;
			}
			
			if(prescribeTestData.maxLength.equals("")){
				assertTrue(isElementPresent(selenium, prescribeTestData.validationFieldID), "The validation message field did not appear",selenium,ClassName,MethodName);
				assertTrue(getText(selenium, prescribeTestData.validationFieldID).contains(prescribeTestData.validationMessage), "The expected validation message should contain the text - "+ prescribeTestData.validationMessage + " The actual validation message shown - " + getText(selenium, prescribeTestData.validationFieldID),selenium,ClassName,MethodName);
				returnValue=true;
			}else{
				if(prescribeTestData.test.contains("MaxLength")){
					data=getValue(selenium,prescribeTestData.validationFieldID);
					count=data.length();
					waitForPageLoad(selenium);
					count1=Integer.parseInt(prescribeTestData.maxLength);
					waitForPageLoad(selenium);
					if(count>count1)
						returnValue=false;
					else if(count==count1)
						returnValue=true;
					waitForPageLoad(selenium);
				}
				else if(prescribeTestData.test.contains("MinLength")||prescribeTestData.test.contains("ExactLength")){
					if(isElementPresent(selenium,btnEdit))
						returnValue=true;
					else
						returnValue=false;
				}
			}
			}catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*) Detailed data:" + prescribeTestData.toString(),selenium,ClassName,MethodName);
			returnValue=false;
		}
		return returnValue;
	}
	
}
