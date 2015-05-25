package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectedItemInSummaryPage extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeleectedItemsForHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_025";
		historyData.fetchChartPreVisitTestData();
		verifySelectedItem(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	/**
	 * verifySelectedItem
	 * function to verify Selected Item
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	  * @since  	Oct 15, 2012
	 */

	public boolean verifySelectedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
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
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");               
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
				assertTrue(click(selenium, lblEncounterSave),"could not click the save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Family History//
			//--------------------------------------------------------------------//
			
			try{
				selenium.fireEvent(lnkFamilyHistory, "click");
			}catch(Exception e){
				selenium.fireEvent(lnkFamilyHistory, "click");
			}		
			
			
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create Family History//
			//--------------------------------------------------------------------//
			//selenium.clickAt("!chartSummary","");
			//waitForPageLoad(selenium);
			//selenium.clickAt("FamilyHistoryTitle","");
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	        
			selenium.clickAt(lnkFamilyHistory,"");
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	        

			waitForPageLoad(selenium);


			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: verify Selected item show in the summary page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,chkShowAll),"Could not click the show All recorded check box;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click (selenium,btnSave),"Could not click the btnsave save button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifySelectedItem(selenium,historyData)){
				Assert.fail("History details not saved properly; More Details :"+ historyData.toString());
				returnValue = false;
			}
								
			try{
				selenium.fireEvent(lnkFamilyHistory, "click");
			}catch(Exception e){
				selenium.fireEvent(lnkFamilyHistory, "click");
			}
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkSelectListBox),"Could not click the check box;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the btnsave2 save nutton;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
					
			if(selenium.isTextPresent("No family history added")){
				returnValue=true;
			}else
				returnValue=false;
				
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySelectedItem(Selenium selenium,ChartPreVisitLib historyData) throws IOException{
		
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(historyData.relation),""+"Family History Relation Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
	
		assertTrue(selenium.isTextPresent(historyData.medical),""+"Family History Medical Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		return true;
	}
}
