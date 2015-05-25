package com.nexia.selenium.testscripts.section.chartprevisit.Immunization;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditImmunization extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Injection")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editImmunizationForSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_036";
		immunizationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	/**
	 * editImmunization
	 * function to add Immunization
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	    Sep 26, 2012
	 */
	public boolean editImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLib immunizationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,immunizationData)," Could not delete all encounters", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium)," Could not navigate to begin encounters", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkBeginEncounterAction),"Could not click the button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium, lnkBeginEncounterAction);
			selenium.clickAt(lnkBeginEncounterAction, "");
			selenium.fireEvent(lnkBeginEncounterAction,"click");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lblEncounterSave),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Delete Immunization//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create Immunization//
			//--------------------------------------------------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Edit Immunization//
			//--------------------------------------------------------------------//
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_004";
			immunizationData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,btnImmunizationEdit),"Could not click edit button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Edition failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			assertTrue(isElementPresent(selenium,btnImmunizationEdit),"Element is not present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
				
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
