package com.nexia.selenium.testscripts.section.chartprevisit.Immunization;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteEncounterImmunization extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting Encounter Immunization")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEncounterRefusedByPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_031";
		immunizationData.fetchChartPreVisitTestData();
		
		deleteEncounterImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}

	/**
	 * deleteEncounterImmunization
	 * function to Delete Encounter Immunization
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 01, 2012
	 */
	
	public boolean deleteEncounterImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
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
			assertTrue(deleteAllEncounters(selenium,immunizationData),"could not delete", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"coul;d not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete existing Immunizations//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteEncounterImmunization(selenium),"Could not Delete All the encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create Immunization//
			//--------------------------------------------------------------------//
			//assertTrue(click(selenium,lnkImmunization),"Could not click the button;More Details:"+immunizationData.toString());
			//waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkEncounterImmunization),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterImmunization,"");
			selenium.focus(lnkEncounterImmunization);
			selenium.fireEvent(lnkEncounterImmunization,"keypress");			
			waitForPageLoad(selenium);			
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,labelImmEncounterdetails),"Is Present", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-6: Delete Immunization//
			//--------------------------------------------------------------------//
			assertTrue(deleteEncounterImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,labelImmEncounterdetails),"Immunization not deleted properly", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
