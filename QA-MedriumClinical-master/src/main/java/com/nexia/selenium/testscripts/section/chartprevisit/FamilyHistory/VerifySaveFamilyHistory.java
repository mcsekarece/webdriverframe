package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySaveFamilyHistory extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verfing Save Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createFamilyHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_024";
		historyData.fetchChartPreVisitTestData();
		verifySaveButton(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	/**
	 * verifySaveButton
	 * function to verify Save Button
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
	  * @since  	Oct 15, 2012
	 */

	public boolean verifySaveButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
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
			//  Step-4: Navigate to Encounter //
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
			//  Step-6: CreateFamily History//
			//--------------------------------------------------------------------//
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-7: Verify Save button//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,chkSelectListBox),"Could not click the check box; More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,btnSave),"Could not click the cancel button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(!isElementPresent(selenium,lblFamilyUppercase),"It is present", selenium, ClassName, MethodName);

			
		/*	if(isElementPresent(selenium,lblFamilyUppercase)){
				returnValue= false;
			}else
				returnValue= true;  */
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
