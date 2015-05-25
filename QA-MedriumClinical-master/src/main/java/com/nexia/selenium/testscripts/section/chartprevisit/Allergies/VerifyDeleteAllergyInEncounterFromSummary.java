package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteAllergyInEncounterFromSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify Delete Allergy in Encounter From Summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteEncounterAllergyInSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_031";
		allergyData.fetchChartPreVisitTestData();
		verifyDeleteAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	/**
	 * verifyDeleteAllergy
	 * Function to verify Delete Allergy in Encounter From Summary
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	  * @since  	Oct 25, 2012
	 */

	public boolean verifyDeleteAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,allergyData),"could not delete the record", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//

			assertTrue(goToBeginEncounter(selenium),"could not navigate to encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Delete Family History//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAllergy),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+allergyData.toString());
			//waitForPageLoad(selenium);
			assertTrue(click(selenium,btnCancel),"Could not click the cancel button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate the encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Delete existing Encounter Allergy//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllEncounterAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
		
			
			assertTrue(isElementPresent(selenium,lnkAllergy),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkAllergy,"");
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Encounter Allergy//
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate Allergy in summary page                          //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click on summary link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Delete Family History                                     //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAllergyCancel),"Could not click the cancel button;More details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Again Navigate to Encounter                               //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigate Pop Up Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!getText(selenium,lblEncounterDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(allergyData.severity.trim().toLowerCase(new java.util.Locale("en","US"))),"Failed to delete", selenium, ClassName, MethodName);
				
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
