package com.nexia.selenium.testscripts.section.chartprevisit.LabResultFillingManual;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForLabReport extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Receiving Provider with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReceivingProviderWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_001";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Receiving Provider with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReceivingProviderWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_002";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Ordering Provider with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOrderingProviderWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_003";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Ordering Provider with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOrderingProviderWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_004";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Lab Report with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabReportWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_005";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Lab Report with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabReportWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_006";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Collection Date with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCollectionDateWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_007";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Collection Date with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCollectionDateWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_008";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Collection Date with Special Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void CollectionDateWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_009";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Collection time with Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCollectionTimeWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_010";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Collection time with Special Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCollectionTimeWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_011";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Collection time with Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCollectionTimeWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_012";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test Name with Special Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTestWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_013";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test Name with Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTestWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_014";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Result with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyResultWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_015";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Low with Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLowWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_016";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Low with Special Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLowWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_017";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "High with Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHighWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_018";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "High with Special Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHighWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();	
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_019";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Collection Date With Future Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyCollectionDateWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();	
		ChartPreVisitLibUnitTest labReportTestData = new  ChartPreVisitLibUnitTest();
		labReportTestData.workSheetName = "UnitTest_LabReportManual";
		labReportTestData.testCaseId = "TC_ULR_020";
		labReportTestData.fetchHomeTestData();	
		unitTestLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportTestData);
	} 
	/**
	 * unitTestLabReport
	 * function to perform unit tests on lab reports
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 10, 2012
	 */
	
	public boolean unitTestLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest labReportTestData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labReportTestData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, labReportTestData.userName, labReportTestData.userPassword),"Login field", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step 2:Advanced search with Patient ID 										//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,labReportTestData.patientID);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateTofileReportUnitTest(selenium,labReportTestData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in Injection //
			//--------------------------------------------------------------------//
			assertTrue(fileReportUnitTest(selenium,labReportTestData),"File New Lab report Failed", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, labReportTestData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, labReportTestData.validationFieldID).contains(labReportTestData.validationMessage), "The expected validation message should contain the text - "+ labReportTestData.validationMessage + " The actual validation message shown - " + getText(selenium, labReportTestData.validationFieldID), selenium, ClassName, MethodName);
			returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}
}
