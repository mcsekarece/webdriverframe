package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnSignedEncounterPopUp extends AbstractChartPreVisit{
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing UnSignedEncounter PopUp Details ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveInEncounterNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_001";
		encounterData.fetchChartPreVisitTestData();
		verifySaveEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify UnSignedEncounter PopUp Details 
	* @Specification  SRS_EMR_Encounter_OverAll Rev0.0
	* @action 		  Test for verifying UnSignedEncounter PopUp Details 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 09, 2013
	***************************************************************************************************/
	public boolean verifySaveEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
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
		//  Step-3: Delete All Exist Encounter//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
		assertTrue(deleteAllEncounters(selenium,encounterData),"Deletion Failed",selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-3: Begin an encounter//
		//--------------------------------------------------------------------//
		assertTrue(selenium.isTextPresent("Begin Encounter"),"Begin Encounter Text is not Present",selenium, ClassName, MethodName);
		
		assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		assertTrue(selenium.isTextPresent("Encounter in progress"),"Encounter in progress Text is not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		selenium.clickAt(lnkBeginEncounterAction,"");
		selenium.focus(lnkBeginEncounterAction);
		selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblEncounterSave),"Could not click", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		//--------------------------------------------------------------------//
		//  Step-4: Again Neviagte to Begin Encounter//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium, btnBeginEncounter),"Could not click the Begin button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-5: Verify Unsigned Encounter Page details//
		//--------------------------------------------------------------------//
		if(!verifyUnsignedEncounterPage(selenium)){
			Assert.fail("Details are not saved properly");
		}else
			returnValue = true;
		
		
		
		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return returnValue;
	}
	
	public boolean verifyUnsignedEncounterPage(Selenium selenium) throws IOException{
		
		if(!selenium.isTextPresent("Unsigned Encounters")){
			return false;
		}
		
		if(!selenium.isTextPresent("Or start a new encounter")){
			return false;
		}
		assertTrue(click(selenium,lnkUnsignedEncounterPopUp),"Could not click the pop up", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!selenium.isTextPresent("Encounter in progress")){
			return false;
		}
		
		if(!isElementPresent(selenium,btnSign)){
			return false;
		}
		return true;
		
	}
	
	
}
