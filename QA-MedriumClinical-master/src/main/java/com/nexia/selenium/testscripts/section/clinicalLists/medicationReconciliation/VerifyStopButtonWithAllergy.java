package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;
public class VerifyStopButtonWithAllergy extends AbstractChartPreVisit{

	
	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Stopfunction with allergy ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void VerijyStopButtonWithAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_049";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStopButton(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	
	
	/**
	 * verifyStop button with allergy
	 * function to verify Release and Hold Button For Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Mar 12, 2014
	 */
	
	
	
public boolean verifyStopButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
	try
	{
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
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
//		assertTrue(deleteAllEncounters(selenium,medicationData),"Could not delete all encounter", selenium, ClassName, MethodName);
		
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
		
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CAE_001";
		allergyData.fetchChartPreVisitTestData();		
		assertTrue(selenium.isVisible(lnkAllergy),"Allergy Link is Not Visible;More Details",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);			
		assertTrue(click(selenium,lnkAllergy),"Could not click the link allergy", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);			
		assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
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
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-6:Verify Stop Button//
		//--------------------------------------------------------------------//
		
		assertTrue(click(selenium,ChkselectAll),"Could not click select all check box ", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,MedicationStopButton),"Could not click stop button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxReleasereasonSuggest,"Allergy"),"Could not click stop button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnContinue),"Could not click save Reason", selenium, ClassName, MethodName);
		if(isElementPresent(selenium,taballergy))
		{
		
			assertTrue(AllergyAsStopReason(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			assertTrue(click(selenium,"yes"),"Could not click the yes", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
		
		}

		//--------------------------------------------------------------------//
		//  Step-6:Adding replacement to current stoped medication//
		//--------------------------------------------------------------------//
		
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_009";
		prescribeData.fetchChartPreVisitTestData();
		
		assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium,btnOverride)){
			assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		
		assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnAddToPending),"Could not click ", selenium, ClassName, MethodName);
				
	}	
	
	catch(Exception e)
		{
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}	
	return returnValue;
}
	
	
	
	
	
	
	
	
	
}
