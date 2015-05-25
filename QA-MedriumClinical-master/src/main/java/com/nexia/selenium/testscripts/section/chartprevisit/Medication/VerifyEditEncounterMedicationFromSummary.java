package com.nexia.selenium.testscripts.section.chartprevisit.Medication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditEncounterMedicationFromSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Edit Encounter Problem List In Summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditEncounterMedicationInSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_031";
		medicationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	/**
	 * editMedication
	 * function to edited medication in summary present in encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 30, 2012
	 */

	public boolean editMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
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
		
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Created Medications//
			//--------------------------------------------------------------------//
			assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
					
			assertTrue(click(selenium,btnSaveMedication),"Could not click the save button;More Details:"+medicationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
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
			//waitForPageLoad(selenium);		

			assertTrue(isElementPresent(selenium,lnkEncounternoteMedi),"Could not find the link", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounternoteMedi,"");
			//selenium.focus("//tr[2]/td[2]/div/div/div[4]/div/div/div[3]/div/a");
			//selenium.fireEvent("//tr[2]/td[2]/div/div/div[4]/div/div/div[3]/div/a","keypress");			
			//waitForPageLoad(selenium);				
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Medication//
			//--------------------------------------------------------------------//
			assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			/*assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the Action button");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"saveEncounter"),"Could not click the save button");
			waitForPageLoad(selenium);*/
			
			if(isElementPresent(selenium,btnDone)){
				assertTrue(click(selenium,btnDone),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}	
			assertTrue(click(selenium,lnkSummary),"Could not click the summary link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Medication //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			medicationData.workSheetName = "EditMedication";
			medicationData.testCaseId = "TC_PSEM_001";
			medicationData.fetchChartPreVisitTestData();
			
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnProEdit),"Could not Fine the button;More Details:"+medicationData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnProEdit),"Could not click the edit button;More Details:"+medicationData.toString(), selenium, ClassName, MethodName);
			
			
			assertTrue(editMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+medicationData.toString(), selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8:Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
		
			/*assertTrue(goToBeginEncounter(selenium),"Could not navigate to begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEdit),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9: verify Stored Value In Encounter//
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValue(selenium,medicationData,userAccount),"Medical list details not saved properly; More Details :"+ medicationData.toString(), selenium, ClassName, MethodName);
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValue(Selenium selenium, ChartPreVisitLib medicationData,String account) throws IOException{
	
		if(account.equals(CAAccount)){
			assertTrue(selenium.isTextPresent(medicationData.prescribeCa.toUpperCase()),"Could not click the link", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(medicationData.refillQuantityCa.trim()),"Text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(medicationData.refillFrequencyCa.trim()),"Text is not present", selenium, ClassName, MethodName);
			
		}else{
			assertTrue(selenium.isTextPresent(medicationData.prescribeName.trim()),"Text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(medicationData.refillMethod.trim()),"Text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(medicationData.refillQuantity.trim()),"Text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(medicationData.refillFrequency.trim()),"Text is not present", selenium, ClassName, MethodName);
		}
		assertTrue(selenium.isTextPresent(medicationData.refillUnit.trim()),"Text is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(medicationData.refillRoute.trim()),"Text is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(medicationData.refillduration.trim()),"Text is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(medicationData.refillUsage.trim()),"Text is not present", selenium, ClassName, MethodName);
		return true;
	}	
}



