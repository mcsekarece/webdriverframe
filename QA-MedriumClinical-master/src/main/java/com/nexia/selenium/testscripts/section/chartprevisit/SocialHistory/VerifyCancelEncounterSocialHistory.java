package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelEncounterSocialHistory extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Cancel Encounter Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_004";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCancel(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	/**
	 * verifyCancel
	 * function to verify cancel SocialHistory
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 26, 2012
	 */

	public boolean verifyCancel(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib socialData) throws IOException{
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
			//  Step-3: Navigate to Social History //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Social History Entries //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllSocialHistory(selenium,socialData),"Deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete Encounter Social History//
			//--------------------------------------------------------------------//
			
			//assertTrue(deleteSocialHistoryForEncounter(selenium,socialData ),"Deletion Failed",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			//assertTrue(click(selenium,lnkSocialHistory),"Could not click the link;");
			//waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkEncounterSoicalHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterSoicalHistory,"");
			//selenium.focus(lnkSocialHistory);
			//selenium.fireEvent(lnkSocialHistory,"keypress");			
			waitForPageLoad(selenium);				
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Social History//
			//--------------------------------------------------------------------//
			
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: verify Stored Value in Family History //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEnSocialDetails1)){
				return false;
			}else
				return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	}