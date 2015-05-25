package com.nexia.selenium.testscripts.section.chartprevisit.Injection;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditEncounterInjection extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Injection")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editEncounterInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_017";
		injectionData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * editInjection
	 * Function to add Encounter Injection
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 30, 2012
	 */
	public boolean editInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
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
			//  Step-3: Navigate to Begin Encounter                               //
			//--------------------------------------------------------------------//
		    
			assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Exit Injection//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllEncounterInjection(selenium,injectionData),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Injection//
			//--------------------------------------------------------------------//
			
			//assertTrue(click(selenium,lnkInjection),"Could not click the Injections Link");
			//waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkInjection),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkInjection,"");
			//selenium.focus(lnkInjection);
			//selenium.fireEvent(lnkInjection,"keypress");
			
			waitForPageLoad(selenium);			
			
			assertTrue(deleteInjection(selenium),"Delete Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Click on edit button
			
			assertTrue(click(selenium,lnkInjection),"Could not click the Injections Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkEdit), "Could not click on Edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			injectionData.workSheetName = "CreateInjection";
			injectionData.testCaseId = "TC_CI_002";
			injectionData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-5: Edit Injection//
			//--------------------------------------------------------------------//
			assertTrue(editInjection(selenium,injectionData,userAccount,providerName),"Edit injection Failed",selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,lblEncounterDetails)){
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
