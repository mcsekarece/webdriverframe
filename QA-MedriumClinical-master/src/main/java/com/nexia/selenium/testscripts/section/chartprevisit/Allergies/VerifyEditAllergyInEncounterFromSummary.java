package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditAllergyInEncounterFromSummary extends AbstractChartPreVisit {
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify edit Allergy in Encounter From Summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditAllergyInEncounterFromSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_033";
		allergyData.fetchChartPreVisitTestData();
		verifyEditAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	/**
	 * verifyEditAllergy
	 * Function to verify edit Allergy in Encounter From Summary
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	  * @since  	Oct 25, 2012
	 */
	public boolean verifyEditAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws   IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,allergyData),"could not delete the encouner record", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Allergy//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnCancel),"Could not click the save button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Allergy//
			//--------------------------------------------------------------------//
			/*assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab");
			assertTrue(deleteAllEncounters(selenium,allergyData));*/
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Coul not navigate to encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete existing Encounter Allergy//
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkEncounterAllergy),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterAllergy,"");
			selenium.focus(lnkEncounterAllergy);
			selenium.fireEvent(lnkEncounterAllergy,"keypress");
			
			waitForPageLoad(selenium);
			
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
			
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_004";
			allergyData.fetchChartPreVisitTestData();
			
			//Click Edit button
			assertTrue(click(selenium, lnkAllergyEdit), "Could not click Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Edit the created Allergy
			assertTrue(editAllergy(selenium,allergyData,userAccount),"Edit failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Verify Stored Value                                       //
			//--------------------------------------------------------------------//
			
			assertTrue(verifyStoredValue(selenium,allergyData,userAccount),"History details not saved properly; More Details :"+ allergyData.toString(),selenium, ClassName,MethodName);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib allergyData,String userAccount){
		try
		{
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,lblEncounterAllergyDetails ).toLowerCase(new java.util.Locale("en","US")).trim().contains(allergyData.severity.trim().toLowerCase(new java.util.Locale("en","US"))),"Could Not Get Severity Detail",selenium, ClassName,MethodName);
		
		
		
		
		if(userAccount.equals(CAAccount)){
			
		assertTrue(getText(selenium,lblEncounterAllergyDetails ).toLowerCase(new java.util.Locale("en","US")).trim().contains(allergyData.allergenCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Could Not get allery detail for CA",selenium, ClassName, MethodName);
		
		}
		else{
			assertTrue(getText(selenium,lblEncounterAllergyDetails ).toLowerCase(new java.util.Locale("en","US")).trim().contains(allergyData.allergen.trim().toLowerCase(new java.util.Locale("en","US"))),"Could Not get allergen detail",selenium, ClassName, MethodName);
			
		}}catch(Exception e)
		{
		 e.printStackTrace();
		}
		
		return true;
	}
}
