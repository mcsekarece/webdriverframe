package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEncounterOverAllPage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Encounter Over All Page details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterOverAllPageDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_008";
		encounterData.fetchChartPreVisitTestData();
		verifyEncounterOverAll(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Encounter over all page details
	* @action 		  Test for verifying Encounter over all page details
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 03, 2013
	***************************************************************************************************/
	
	public boolean verifyEncounterOverAll(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws         IOException{
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
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to Begin encouter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*assertTrue(click(selenium,btnSign),"Could not click the done button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-4: Verify the encounter page details//
			//--------------------------------------------------------------------//
			
			assertTrue(selenium.isTextPresent("Allergies"),"Allergies text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Problem List"),"Problem List text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Surgical History"),"Surgical History text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Medications"),"Medications text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Immunizations"),"Immunizations text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Injections"),"Injections text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Social History"),"Social History text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Family History"),"Family History text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Obstetrical History"),"Obstetrical History text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Chief Complaint"),"Chief Complaint text is not present",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,imgPrescribeMedsIcon),"Prescribe Medication icon is not getting displayed",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,imgLabOrderIcon),"Lab order Icon is not present",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,imgDiOrderIcon),"Di order Icon is not present",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,imgReferralIcon),"Referral Icon is not present",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,imgProcedureIcon),"Procedure  Icon is not present",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,imgIjnectionIcon),"Injection Icon is not present",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,imgImmunizationIcon)," Immunization Icon is not present",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,elementPatienHandOutLink)," Hand out Link is not present",selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,imgReferrence)){
				returnValue = true;
			}else
				Assert.fail("Referrence section is not getting displayed");	
			
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
