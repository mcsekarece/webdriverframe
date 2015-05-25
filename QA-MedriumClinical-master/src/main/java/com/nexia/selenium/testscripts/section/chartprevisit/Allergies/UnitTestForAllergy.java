package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForAllergy extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Allergy with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void allergenWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_001";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Allergy with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void allergenWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_002";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Allergy with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void allergenWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_003";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Reactio with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void reactionWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_004";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Reaction with Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void reactioWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_005";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Severity with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void severityWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_006";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups ={"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Severity with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void severityWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_007";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Severity with Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void severityWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_008";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Status with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void statusWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_009";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Status with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void statusWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_010";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Status with Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void statusWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_011";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Onset Date with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void onsetDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_012";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Onset Data with Future date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void onsetDateWithFuture(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_013";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Onset date with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void onsetDateWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_014";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Onset Date with Partial Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void onsetDataWithPartial(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_015";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Onset Date with different Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void onsetDateWithDiffFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_016";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Life style with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void lifeStyleWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_017";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Life style With Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void lifeStyleWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_018";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Comment with Maximum Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void commentWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest allergyData = new ChartPreVisitLibUnitTest();
		allergyData.workSheetName = "UnitTest_Allergy";
		allergyData.testCaseId = "TC_PSA_019";
		allergyData.fetchHomeTestData();
		unitTestAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	public boolean unitTestAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientID);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			// step 3:perform unit test for various fields in  Allergy            //
			//--------------------------------------------------------------------//
			
			assertTrue(unitTestForAllergy(selenium,allergyData),"Allergy Unit test Failed", selenium, ClassName, MethodName);
			allergyData.validationFieldID=allergyData.validationFieldID==null?allergyData.validationFieldID = "" : allergyData.validationFieldID.trim();
			assertTrue(!allergyData.validationFieldID.equals(""), "The validation message did not equal to NULL",selenium, ClassName, MethodName);
			
			assertTrue(isElementPresent(selenium, allergyData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, allergyData.validationFieldID).contains(allergyData.validationMessage), "The expected validation message should contain the text - "+ allergyData.validationMessage + " The actual validation message shown - " + getText(selenium, allergyData.validationFieldID), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
