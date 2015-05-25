package com.nexia.selenium.testscripts.section.chartprevisit.ProblemList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForProblemList extends AbstractChartPreVisit {
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Medication Condition with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationCondtionWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_ProblemList";
		proTestData.testCaseId = "TC_UPL_001";
		proTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Medication Condition with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationCondtionWithMaxlength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_ProblemList";
		proTestData.testCaseId = "TC_UPL_002";
		proTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Onset Date with invallid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOnsetDateWithInvalidDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_ProblemList";
		proTestData.testCaseId = "TC_UPL_003";
		proTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups ={"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Onset Date with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOnsetDateWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_ProblemList";
		proTestData.testCaseId = "TC_UPL_004";
		proTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Onset Date with Future Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOnsetDateWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_ProblemList";
		proTestData.testCaseId = "TC_UPL_005";
		proTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Status With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStatusWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_ProblemList";
		proTestData.testCaseId = "TC_UPL_006";
		proTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Life Stage With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLifeStageWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_ProblemList";
		proTestData.testCaseId = "TC_UPL_007";
		proTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Resolved Date With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyResolvedDateWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_ProblemList";
		proTestData.testCaseId = "TC_UPL_008";
		proTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Coding System With Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCodingSystemWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_ProblemList";
		proTestData.testCaseId = "TC_UPL_009";
		proTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Diagnosis With Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDiagnosisWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest proTestData = new  ChartPreVisitLibUnitTest();
		proTestData.workSheetName = "UnitTest_ProblemList";
		proTestData.testCaseId = "TC_UPL_010";
		proTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proTestData);
	}
	
	public boolean unitTestProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest proTestData) throws IOException{
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
			
			searchPatientNexiaForProviderHomePage(selenium,proTestData.patientID);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in Injection //
			//--------------------------------------------------------------------//
			assertTrue(unitTestProblemList(selenium,proTestData),"Procedure Failed",selenium, ClassName, MethodName);
			proTestData.validationFieldID = proTestData.validationFieldID== null ? proTestData.validationFieldID = "" : proTestData.validationFieldID.trim();
			if(!proTestData.validationFieldID.equals("")){
			assertTrue(isElementPresent(selenium, proTestData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, proTestData.validationFieldID).contains(proTestData.validationMessage), "The expected validation message should contain the text - "+ proTestData.validationMessage + " The actual validation message shown - " + getText(selenium, proTestData.validationFieldID),selenium, ClassName, MethodName);
			returnValue=true;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + proTestData.toString());
			returnValue=false;
		}
		return returnValue;
	}
}
