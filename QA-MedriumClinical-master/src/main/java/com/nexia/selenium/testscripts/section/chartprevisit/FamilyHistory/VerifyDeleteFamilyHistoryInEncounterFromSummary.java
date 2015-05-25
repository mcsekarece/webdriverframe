package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteFamilyHistoryInEncounterFromSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteEncounterFamilyHistoryInSummaryPage(final String seleniumHost, final int seleniumPort,final String browser, final String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_020";
		historyData.fetchChartPreVisitTestData();
		verifyDeleteHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	/**
	 * verifyDeleteHistory
	 * function to verifyDeleteHistory
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	  * @since  	Oct 17, 2012
	 */

	public boolean verifyDeleteHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
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
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,historyData),"Could not delete", selenium, ClassName, MethodName);
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
			
			selenium.clickAt(lnkFamilyHistory,"");
			//selenium.focus(lnkFamilyHistory);
			//selenium.fireEvent(lnkFamilyHistory,"keypress");
			
			waitForPageLoad(selenium);
							
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Encounter Family History//
			//--------------------------------------------------------------------//
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate Family History //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Delete Family History//
			//--------------------------------------------------------------------//
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSaveFamilyHistory),"Could not click the save button;More details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Again Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!getText(selenium,lblEncounterDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.relation.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click the link;",selenium, ClassName, MethodName);

		/*	if(!getText(selenium,lblEncounterDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.relation.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue= false;
			}else
				returnValue=true;   */
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
