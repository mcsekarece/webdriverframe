package com.nexia.selenium.testscripts.section.chartprevisit.MedicalAndSurgicalHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestProcedures extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Procedure Name With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProcedureNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_Procedure";
		proTestData.testCaseId = "TC_UP_001";
		proTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Procedure Date With Future date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProcedureDateWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_Procedure";
		proTestData.testCaseId = "TC_UP_002";
		proTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups ={"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Procedure Date With Invalid date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProcedureDateWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_Procedure";
		proTestData.testCaseId = "TC_UP_003";
		proTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Onset date with Future date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOnsetDateWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_Procedure";
		proTestData.testCaseId = "TC_UP_004";
		proTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Onset date with Invalid date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOnsetDateWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_Procedure";
		proTestData.testCaseId = "TC_UP_005";
		proTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CPT code with invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCPTCodeWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_Procedure";
		proTestData.testCaseId = "TC_UP_006";
		proTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Consents with invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyConsentsWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_Procedure";
		proTestData.testCaseId = "TC_UP_007";
		proTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	
	
		public boolean unitTestProcedure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest proTestData) throws IOException{
			Selenium selenium=null;
			boolean returnValue=true;
			try{
				//--------------------------------------------------------------------//
				// Step 1:Login to the application//
				//--------------------------------------------------------------------//
				
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proTestData.toString());
				loginForNexiaFromProviderSite(selenium, userAccount, proTestData.userName, proTestData.userPassword);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//Step 2:Advanced search with Patient ID 										//
				//--------------------------------------------------------------------//
				if(isElementPresent(selenium,"errorCloseButton")){
					assertTrue(click(selenium,"errorCloseButton"),"Could not click error close button"+proTestData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				searchPatientNexiaForProviderHomePage(selenium,proTestData.patientID);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"errorCloseButton")){
					assertTrue(click(selenium,"errorCloseButton"),"Could not click error close button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				
				assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				// step 4:perform unit test for various fields in Injection //
				//--------------------------------------------------------------------//
				assertTrue(unitTestForProcedure(selenium,proTestData,userAccount),"Procedure Failed",selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium, proTestData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium, proTestData.validationFieldID).contains(proTestData.validationMessage), "The expected validation message should contain the text - "+ proTestData.validationMessage + " The actual validation message shown - " + getText(selenium, proTestData.validationFieldID),selenium, ClassName, MethodName);
				returnValue=true;
			}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + proTestData.toString());
				returnValue=false;
			}
			return returnValue;
		}
	}
