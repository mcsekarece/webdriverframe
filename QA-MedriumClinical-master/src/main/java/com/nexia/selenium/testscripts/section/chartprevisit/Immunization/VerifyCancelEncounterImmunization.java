package com.nexia.selenium.testscripts.section.chartprevisit.Immunization;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelEncounterImmunization extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "function to verify cancel function for Allergy in Encounter page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelEncounterImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_009";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		cancelEncounterImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	/**
	 * cancelEncounterImmunization
	 * function to verify cancel function for Allergy in Encounter page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 05, 2012
	 */
	
	public boolean cancelEncounterImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
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
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium)," Could not navigate to begin encounters", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
		
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			//selenium.fireEvent(lnkBeginEncounterAction,"keydown");
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			//selenium.fireEvent(lnkBeginEncounterAction,"keyup");
			//selenium.keyPress(lnkBeginEncounterAction, "\\46");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete All Existing Immunization in medical summary page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium)," Could not navigate to begin encounters", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete existing Immunizations in Encounter page//
			//--------------------------------------------------------------------//
			assertTrue(deleteEncounterImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkImmunization),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkImmunization,"");
			//selenium.focus(lnkImmunization);
			//selenium.fireEvent(lnkImmunization,"keypress");
			
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Immunization in Encounter page//
			//--------------------------------------------------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click on Action and Select Cancel
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkBeginEncounterCancel),"Could not click the save button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnYes)){
				selenium.click(btnYes);
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,lblEncouterImmDetails),"Cancel functionality failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
