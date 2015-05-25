package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditFamilyHistoryInEncounterFromSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Edit Family History In Encounter From Summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditFamilyhistoryInEncounter(final String seleniumHost, final int seleniumPort,final String browser, final String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_022";
		historyData.fetchChartPreVisitTestData();
		verifyEditHistoryInEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	/**
	 * verifyEditHistoryInEncounter
	 * function to verify Edit History In Encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	  * @since  	Oct 16, 2012
	 */

	public boolean verifyEditHistoryInEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws   IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Family History//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,historyData),"Could not delete", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Encounter Family History//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteFamilyHistoryForEncounter(selenium,historyData ),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkFamilyHistory),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterFamilyHistory,"");
		
			
			waitForPageLoad(selenium);						
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Encounter Family History//
			//--------------------------------------------------------------------//
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate Family History //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Edit Family History //
			//--------------------------------------------------------------------//
			historyData.workSheetName = "CreateFamilyHistory";
			historyData.testCaseId = "TC_CFM_005";
			historyData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,btnFamilyEdit),"Could not click the edit button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			assertTrue(editFamilyHistory(selenium,historyData),"Editing failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-10: Verify Stored Value//
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValue(selenium,historyData),"History details not saved properly; More Details :"+ historyData.toString(), selenium, ClassName, MethodName);

			
		/*	if(!verifyStoredValue(selenium,historyData)){
				Assert.fail("History details not saved properly; More Details :"+ historyData.toString());
				returnValue=false;
			}else
				returnValue=true;      */
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib historyData) throws IOException{
		//if(!getText(selenium,lblEncounterDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.relation.trim().toLowerCase(new java.util.Locale("en","US")))){
		assertTrue(getText(selenium,lblEnSumFamilyDetails1).toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.relation.trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblEnSumFamilyDetails1).toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.medical.trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblEnSumFamilyDetails1).trim().contains(historyData.age.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblEnSumFamilyDetails1).trim().contains(historyData.ageAtDeath.trim())," ", selenium, ClassName, MethodName);
		
		
		return true;
	}
}
