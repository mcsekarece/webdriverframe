package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteEncounterFamilyHistoryInSummaryPage extends AbstractChartPreVisit{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifydeleteEncounterFamilyHistoryInSummaryPage(final String seleniumHost, final int seleniumPort,final String browser, final String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_019";
		historyData.fetchChartPreVisitTestData();
		verfiydeleteHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	/**
	 * verfiycreateHistory
	 * function to verfiy create History
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	  * @since  	Oct 16, 2012
	 */

	public boolean verfiydeleteHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
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
		
			//--------------------------------------------------------------------//
			//  Step-7: verify Stored Value in Family History //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click on summary link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyCollapseViewForFamily(selenium,historyData),"History details not saved properly; More Details :"+ historyData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyExpandViewForFamily(selenium,historyData),"History details not saved properly; More Details :"+ historyData.toString(), selenium, ClassName, MethodName);

		/*	if(!verifyCollapseViewForFamily(selenium,historyData)){
				Assert.fail("History details not saved properly; More Details :"+ historyData.toString());
			}
			
			if(!verifyExpandViewForFamily(selenium,historyData)){
				Assert.fail("History details not saved properly; More Details :"+ historyData.toString());
			}       */
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-8:Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Delete Encounter Family History//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteFamilyHistoryForEncounter(selenium,historyData ),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");
		/*	assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: verify Stored Value in Family History //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click on summary link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,lnkEdit),"Is present",selenium, ClassName, MethodName);

		/*	if(isElementPresent(selenium,lblCollapseView)){
				returnValue = false;
			}else
				returnValue=true;    */
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
