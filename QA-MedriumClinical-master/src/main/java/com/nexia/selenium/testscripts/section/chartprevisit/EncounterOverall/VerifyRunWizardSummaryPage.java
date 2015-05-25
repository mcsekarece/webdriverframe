package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRunWizardSummaryPage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Delete encounter record in Encounter tab")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void runWizardSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_001";
		encounterData.fetchChartPreVisitTestData();
		verifyRunWizardSummary(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        verify Run Wizard summary page
	* @action 		  Test for verifying Run Wizard summary page
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 03, 2013
	***************************************************************************************************/
	
	public boolean verifyRunWizardSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws         IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib vitalsData1 = new ChartPreVisitLib();
			vitalsData1.workSheetName = "NewPatientCheckIn";
			vitalsData1.testCaseId = "TC_NP_001";
			vitalsData1.fetchChartPreVisitTestData();
			
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData1),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, txtpatientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to Begin encouter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Run wizard Summary Page//
			//--------------------------------------------------------------------//
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium, lnkRunWizard),"could not click the Run Wizard Summary Page",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);		
			
			assertTrue(selenium.isTextPresent("Allergies"),"Allergies text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Problem List"),"Problem List text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Surgical History"),"Surgical History text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Medications"),"Medications text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Immunizations"),"Immunizations text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Injections"),"Injections text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Social History"),"Social History text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Family History"),"Family History text is not present",selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,ajxSearchAllergy)){
				returnValue = true;
			}else
				Assert.fail("Run wizard page is not getting displayed properly");
			
			
			
			
			
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
