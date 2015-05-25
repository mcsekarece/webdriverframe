package com.nexia.selenium.testscripts.section.chartprevisit.Injection;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForInjection extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Injection with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyInjectionWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_001";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Injection with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyInjectionWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_002";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Dosage unit with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDosageUnitWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_003";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Dosage unit with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDosageUnitWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_004";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Dosage with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDosageWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_005";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Dosage with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDosageWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_006";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Expiry date with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExpiryDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_007";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Expiry date with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExpiryDateWithChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_008";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Expiry date with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExpiryDateWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_009";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Expiry date with number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExpiryDateWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_010";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Administred on with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminOnWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_011";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Administred on with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminOnWithChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_012";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Administred on with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminOnWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_013";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Administred on with number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminOnWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_014";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Administred on with future date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminOnWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_015";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "site with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySiteWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_016";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "site with numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySiteWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_017";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "site with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySiteWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_018";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Route with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRouteWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_019";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "route with numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRouteWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_020";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Route with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRouteWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_021";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Consent with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyConsentWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_022";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Consent with numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyConsentWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_023";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Consent with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyConsentWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_024";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Administred by with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminByWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_025";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Administred by with numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminByWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_026";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Administred by with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminByWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_027";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CPT code1 with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCPTCode1WithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_028";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CPT code1 with numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCPTCode1WithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_029";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CPT code1 with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCPTCode1WithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_030";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CPT Code2 with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCPTCode2WithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_031";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CPT Code2 with numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCPTCode2WithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_032";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CPT Code2 with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCPTCode2WithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_033";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "reaction with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReactionWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_034";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "reaction with numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReactionWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_035";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Reaction with Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReactionWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_036";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Comments with Max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCommentsWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest injectionTestData = new  ChartPreVisitLibUnitTest();
		injectionTestData.workSheetName = "UnitTest_Injection";
		injectionTestData.testCaseId = "TC_In_037";
		injectionTestData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionTestData);
	} 
	
	public boolean unitTestInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest injectionTestData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + injectionTestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, injectionTestData.userName, injectionTestData.userPassword);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step 2:Advanced search with Patient ID 										//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,injectionTestData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in Injection //
			//--------------------------------------------------------------------//
			assertTrue(unitTestForInjection(selenium,injectionTestData),"Injection Failed",selenium, ClassName, MethodName);
			if(!injectionTestData.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium,injectionTestData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium,injectionTestData.validationFieldID).contains(injectionTestData.validationMessage), "The expected validation message should contain the text - "+injectionTestData.validationMessage + " The actual validation message shown - " + getText(selenium,injectionTestData.validationFieldID),selenium, ClassName, MethodName);
			return true;
			}
		
			returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + injectionTestData.toString());
			returnValue=false;
		}
		return returnValue;
	}
}
