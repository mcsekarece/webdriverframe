package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPastMedicalHistoryAndPrePareNoteInSummaryReviewWizard extends AbstractChartPreVisit{
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Past Medical History And PrePare Note In Summary Approved Wizard")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPastMedicalHistoryAndPrePareNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_001";
		encounterData.fetchChartPreVisitTestData();
		verifyPastMedicalHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify NextButtonStatus
	* @Specification  SRS_EMR_Encounter_OverAll Rev0.0
	* @action 		  Test for verifying Next button Status
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 09, 2013
	***************************************************************************************************/
	public boolean verifyPastMedicalHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
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
		//  Step-4: Begin an encounter//
		//--------------------------------------------------------------------//
		assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-5: Navigate to Run wizard Summary Page//
		//--------------------------------------------------------------------//
		selenium.clickAt(lnkBeginEncounterAction,"");
		selenium.focus(lnkBeginEncounterAction);
		selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
		waitForPageLoad(selenium);
	
		assertTrue(click(selenium, lnkRunWizard),"could not click the Run Wizard Summary Page",selenium, ClassName, MethodName);	
		waitForPageLoad(selenium);		

		assertTrue(selenium.isTextPresent("Past Medical History"),"Past Medical History text is not present",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent("Prepare Note"),"Prepare Note text is not present",selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-6: Verify Summary Approved Wizard Page//
		//--------------------------------------------------------------------//
		assertTrue(isElementPresent(selenium,lnkNext),"Next button is not present",selenium, ClassName, MethodName);
		assertTrue(isElementPresent(selenium,lnkDone),"Done button is not present",selenium, ClassName, MethodName);
		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			selenium.chooseOkOnNextConfirmation();
		}
		
		//--------------------------------------------------------------------//
		//  Step-7: Navigate to PrePare Note Page//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium, chkPrePareNote),"could not click the PrePare Note Page",selenium, ClassName, MethodName);	
		waitForPageLoad(selenium);	
		
		//--------------------------------------------------------------------//
		//  Step-8:Verify PrePare Note Page//
		//--------------------------------------------------------------------//
		assertTrue(isElementPresent(selenium,btnApplyEncounter),"Apply button is not present",selenium, ClassName, MethodName);
		assertTrue(isElementPresent(selenium,btnSign),"Sign button is not present",selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return returnValue;
	}
}
