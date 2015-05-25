package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditFamilyHistory extends AbstractChartPreVisit{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Edit Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editFamilyHistoryWithShowDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_015";
		historyData.fetchChartPreVisitTestData();
		editFamilyHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	/**
	 * editFamilyHistory
	 * function to add Family History
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
	  * @since  	Oct 04, 2012
	 */
	public boolean editFamilyHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
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
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,historyData),"Could not delete", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
		
				assertTrue(click(selenium, lblEncounterSave),"could not click the save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Family History//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Create Family History//
			//--------------------------------------------------------------------//
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Edit IFamily History//
			//--------------------------------------------------------------------//
			historyData.workSheetName = "CreateFamilyHistory";
			historyData.testCaseId = "TC_CFM_003";
			historyData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,btnFamilyEdit),"Could not click the edit button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(editFamilyHistory(selenium,historyData),"Editing failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnFamilyEdit)," edit button not present;More Details:"+historyData.toString(), selenium, ClassName, MethodName);

			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}