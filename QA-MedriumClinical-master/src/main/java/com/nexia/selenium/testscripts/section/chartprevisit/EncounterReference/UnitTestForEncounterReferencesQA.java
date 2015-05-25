package com.nexia.selenium.testscripts.section.chartprevisit.EncounterReference;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForEncounterReferencesQA extends AbstractChartPreVisit{
	@Test(groups =  {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Reference with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReferenceWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest encounterData = new ChartPreVisitLibUnitTest();
		encounterData.workSheetName = "UnitTest_EncounterReference";
		encounterData.testCaseId = "TC_ER_001";
		encounterData.fetchHomeTestData();
		verifyEncounterReferences(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups =  {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Reference with Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReferenceWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest encounterData = new ChartPreVisitLibUnitTest();
		encounterData.workSheetName = "UnitTest_EncounterReference";
		encounterData.testCaseId = "TC_ER_002";
		encounterData.fetchHomeTestData();
		verifyEncounterReferences(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups =  {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Reference with Alphabates")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReferenceWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest encounterData = new ChartPreVisitLibUnitTest();
		encounterData.workSheetName = "UnitTest_EncounterReference";
		encounterData.testCaseId = "TC_ER_003";
		encounterData.fetchHomeTestData();
		verifyEncounterReferences(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups =  {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Book Mark with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBookMarkWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest encounterData = new ChartPreVisitLibUnitTest();
		encounterData.workSheetName = "UnitTest_EncounterReference";
		encounterData.testCaseId = "TC_ER_004";
		encounterData.fetchHomeTestData();
		verifyEncounterReferences(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups =  {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Book Mark with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBookMarkLinkWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest encounterData = new ChartPreVisitLibUnitTest();
		encounterData.workSheetName = "UnitTest_EncounterReference";
		encounterData.testCaseId = "TC_ER_005";
		encounterData.fetchHomeTestData();
		verifyEncounterReferences(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups =  {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Book Mark with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBookMarkLinkWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest encounterData = new ChartPreVisitLibUnitTest();
		encounterData.workSheetName = "UnitTest_EncounterReference";
		encounterData.testCaseId = "TC_ER_006";
		encounterData.fetchHomeTestData();
		verifyEncounterReferences(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups =  {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Book Mark with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBookMarkLinkWithAlpha(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest encounterData = new ChartPreVisitLibUnitTest();
		encounterData.workSheetName = "UnitTest_EncounterReference";
		encounterData.testCaseId = "TC_ER_007";
		encounterData.fetchHomeTestData();
		verifyEncounterReferences(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify unit test for encounter References
	* @action 		  verifying unit test for Visit References 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Completed
	* @useraccount    Both(Us and Canada)
	* @since  	      July 02, 2013
	***************************************************************************************************/
	
	public boolean verifyEncounterReferences(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLibUnitTest encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Quick actions//
			//--------------------------------------------------------------------//
			assertTrue(goToReference(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Perform unit tests for the Reference//
			//--------------------------------------------------------------------//
			assertTrue(unitTestForReference(selenium,encounterData),"Reference Failed", selenium, ClassName, MethodName);
			if(!encounterData.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium,encounterData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,encounterData.validationFieldID).contains(encounterData.validationMessage), "The expected validation message should contain the text - "+encounterData.validationMessage + " The actual validation message shown - " + getText(selenium,encounterData.validationFieldID), selenium, ClassName, MethodName);
			return true;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
