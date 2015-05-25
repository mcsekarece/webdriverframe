package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForEncounterOverAll extends AbstractChartPreVisit{
	@Test(groups =  {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing encounter date with alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterDateWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest encounterData = new ChartPreVisitLibUnitTest();
		encounterData.workSheetName = "UnitTest_EncounterOverAll";
		encounterData.testCaseId = "TC_EO_001";
		encounterData.fetchHomeTestData();
		verifyEncounterButton(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	@Test(groups =  {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing encounter date with special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterDateWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest encounterData = new ChartPreVisitLibUnitTest();
		encounterData.workSheetName = "UnitTest_EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchHomeTestData();
		verifyEncounterButton(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	/**
	 * verifyEncounterButton
	 * function to verify unit test on Encounter overall
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 20, 2012
	 */

	public boolean verifyEncounterButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLibUnitTest encounterData) throws IOException{
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
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Perform unit tests for the encounter//
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtUnsignedEncounterDate,encounterData.encounterDate),"Could not enter Date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			selenium.focus(btnApply);
			selenium.clickAt(btnApply, "");
			waitForPageLoad(selenium);
			encounterData.validationFieldID=encounterData.validationFieldID==null?encounterData.validationFieldID = "" : encounterData.validationFieldID.trim();
			
			if(!encounterData.validationFieldID.equals("")){
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium, encounterData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium, encounterData.validationFieldID).contains(encounterData.validationMessage), "The expected validation message should contain the text - "+ encounterData.validationMessage + " The actual validation message shown - " + getText(selenium, encounterData.validationFieldID), selenium, ClassName, MethodName);
				returnValue=true;
				}
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}