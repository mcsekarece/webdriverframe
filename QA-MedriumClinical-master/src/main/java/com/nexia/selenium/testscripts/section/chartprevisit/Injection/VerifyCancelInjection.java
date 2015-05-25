package com.nexia.selenium.testscripts.section.chartprevisit.Injection;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelInjection extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify the action for cancel button")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_019";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * addInjection
	 * Function to verify the action for cancel button
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 31, 2012
	 */
	public boolean addInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + injectionData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, injectionData.userName, injectionData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,injectionData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,injectionData),"Deletion failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//
		assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"could not click on encounter save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Exit Injection//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Injection//
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Cancel button                                      //
			//--------------------------------------------------------------------//
			//Uncheck the check box in list view
			
			/*assertTrue(click(selenium,lnkSummary), "Could not click on summary link");
			waitForPageLoad(selenium);*/
			
			assertTrue(click(selenium,lnkInjection),"Could not click the Injections Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(isElementPresent(selenium,chkInjection),"Could not find the check box more Details;"+injectionData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,chkInjection),"Could not click the check box; More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnCancel),"Could not click the cancel button;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			//Verify whether the created Injection present in summary page after click on cancel
			if(isElementPresent(selenium,lblNoInjection)){
				return true;
			}else
				return false;
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + injectionData.toString());
		}
		return returnValue;
	}
}