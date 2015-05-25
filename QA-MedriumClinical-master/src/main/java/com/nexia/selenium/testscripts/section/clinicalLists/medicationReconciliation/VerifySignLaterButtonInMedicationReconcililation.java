package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;
import java.io.IOException;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;
public class VerifySignLaterButtonInMedicationReconcililation extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying hold and Release Button For Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void VerifySignLaterButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_050";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyButtonsInAddNew(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}


	/**
	 * verifysign later button
	 * function to verifySign later button
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		Exception 
	 * @since  	    Mar 15, 2014
	 */

	public boolean verifyButtonsInAddNew(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws Exception{
		Selenium selenium=null;	
	try{
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		//--------------------------------------------------------------------//
		//  Step-2: Advanced search with Patient ID//
		//--------------------------------------------------------------------//
		waitForPageLoad(selenium);
		searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
		waitForPageLoad(selenium);
		assertTrue(deleteAllPendingMedication(selenium,medicationData),"Deletion failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		//--------------------------------------------------------------------//
		//  Step-3:Delete all encounter in encounter tab//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
		assertTrue(deleteAllEncounters(selenium,medicationData),"Could not delete all encounter", selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-4: Delete Medication //
		//--------------------------------------------------------------------//			
		// Check if the Medication Link is Visible
		assertTrue(selenium.isVisible(lnkMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);			
		assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	    assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);			
		//--------------------------------------------------------------------//
		//  Step-5: Begin Encounter 										  //
		//--------------------------------------------------------------------//		
		assertTrue(goToBeginEncounter(selenium),"Could not navigate to begin encounter", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isVisible(lnkEncounterMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);		
		
		selenium.clickAt(lnkEncounterMedication,"");
		//selenium.focus(lnkEncounterMedication);
		//selenium.fireEvent(lnkEncounterMedication,"keypress");			
		waitForPageLoad(selenium);					

		//--------------------------------------------------------------------//
		//  Step-6: Create Medication//
		//--------------------------------------------------------------------//
		assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		//--------------------------------------------------------------------//
		//  Step-7:Add medication to pending//
		//--------------------------------------------------------------------//
		waitForPageLoad(selenium);	
		assertTrue(click(selenium,ChkBoxMedication),"Could not click the CheckBox", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium,MedicationrenewButton),"Could not click the Renew button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium,btnSignLater),"Could not click the sign later button button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(selenium.isTextPresent("Pending renewal"),"Medication not added to pending medication",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);		
		assertTrue(selenium.isElementPresent(btnDone),"Done button is not present in Encounter->Medication Reconcilation Page", selenium, ClassName, MethodName);
		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			selenium.chooseOkOnNextConfirmation();
			}
		
		assertTrue(click(selenium,btnDone),"Could not click the Done buttonn", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			selenium.chooseOkOnNextConfirmation();
			}
		//--------------------------------------------------------------------//
		//  Step-7:Verify Medication And plan Section									//
		//--------------------------------------------------------------------//
		assertTrue(verifyPlanAndRecommSectionWithSignLater(selenium,userAccount,medicationData),"Creation failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);			
	}
	catch(Exception e){
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}	
	return true;
		
	
	}


public boolean verifyPlanAndRecommSectionWithSignLater(Selenium selenium,String userAccount,ChartPreVisitLib medicationData) throws IOException{	
	Boolean returntrue=false;
	if(isElementPresent(selenium,lblMedicationPlan)){
		if(userAccount.equals(CAAccount)){
			assertTrue(selenium.isTextPresent(medicationData.prescribeNameCa),"Medication not added to plan and recomm section in encounter note",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
			return true;
		}
			
		else{
			assertTrue(selenium.isTextPresent(medicationData.prescribeName),"Medication not added to plan and recomm section in encounter note",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
			return true;
		}
		
	}
	else{
		return false;
	}	
}








































}
