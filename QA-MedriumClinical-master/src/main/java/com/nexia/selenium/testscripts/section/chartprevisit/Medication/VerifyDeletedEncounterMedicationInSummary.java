package com.nexia.selenium.testscripts.section.chartprevisit.Medication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeletedEncounterMedicationInSummary extends AbstractChartPreVisit{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying whether deleted encounter medication present in summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteEncounterMedicationInSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_029";
		medicationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		deleteMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	/**
	 * deleteMedication
	 * function to delete Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 29, 2012
	 */

	public boolean deleteMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,lnkTabMore),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Created Medications//
			//--------------------------------------------------------------------//
			assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSaveMedication),"Could not click the save button;More Details:"+medicationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,medicationData),"Could not delete all encounter", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
				
			//--------------------------------------------------------------------//
			//  Step-5: Delete Encounter Medications//
			//--------------------------------------------------------------------//
			assertTrue(deleteEncounterMedication(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkEncounternoteMedi),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.focus(lnkEncounternoteMedi);
			selenium.clickAt(lnkEncounternoteMedi,"");
			//selenium.focus("//tr[2]/td[2]/div/div/div[4]/div/div/div[3]/div/a");
			//selenium.fireEvent("//tr[2]/td[2]/div/div/div[4]/div/div/div[3]/div/a","keypress");			
			//waitForPageLoad(selenium);		
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Medication//
			//--------------------------------------------------------------------//
			assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			/*assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the Action button");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"saveEncounter"),"Could not click the save button");
			waitForPageLoad(selenium);*/
			
			
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Stored Values//
			//--------------------------------------------------------------------//
			
			if(isElementPresent(selenium,btnDone)){
				assertTrue(click(selenium,btnDone),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}		
			//assertTrue(click(selenium,lnkSummary),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//selenium.focus(lnkMedication);
			assertTrue(click(selenium, lnkTabMore),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyCollapseViewForMedication(selenium,medicationData,userAccount),"Medication details not saved properly in collapse view :"+ medicationData.toString(), selenium, ClassName, MethodName);

			
			assertTrue(verifyCollapseViewForMedication(selenium,medicationData,userAccount),"Medication details not saved properly in Expand view :"+ medicationData.toString(), selenium, ClassName, MethodName);
			

			//--------------------------------------------------------------------//
			//  Step-8:Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			//--------------------------------------------------------------------//
			//  Step-9: Delete Encounter Family History//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteEncounterMedication(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: verify Delete Medication in Summary Page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"MedicationTitle"),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			assertTrue(selenium.isTextPresent("No data to display"),"No data to display",selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
