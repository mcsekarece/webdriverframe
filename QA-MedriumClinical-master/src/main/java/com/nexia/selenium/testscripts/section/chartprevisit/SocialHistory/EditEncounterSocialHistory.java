package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditEncounterSocialHistory extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing Social History for Encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editEncounterSocialHistoryWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_016";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	/**
	 * editSocialHistory
	 * function to edit SocialHistory
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 23, 2012
	 */

	public boolean editSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib socialData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + socialData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, socialData.userName, socialData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,socialData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,socialData),"Deletion failed",selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete existing Social History//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllSocialHistory(selenium,socialData),"Deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		

			
		
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			selenium.focus(lnkEncounterSoicalHistory);		
			selenium.clickAt(lnkEncounterSoicalHistory,"");
		
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Social History//
			//--------------------------------------------------------------------//
			
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Edit Created Social History From Encounter//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEnSumSocHistoryDetails),"Could not click on Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			
			socialData.workSheetName = "CreateSocialHistory";
			socialData.testCaseId = "TC_CSH_003";
			socialData.fetchChartPreVisitTestData();
			//socialData.testCaseId = "TC_CSH_016";
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEnSocialDetails)){
				returnValue=true;
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}