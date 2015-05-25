package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientComplanitBoxinEncounter extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing whether Begin Encounter button present after saving an encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void patientComplanitBoxInEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_009";
		encounterData.fetchChartPreVisitTestData();
		verifyPatientComplanitBoxWithNewNote(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default"}, description = "Test for Verifing whether Begin Encounter button present after saving an encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void patientComplanitBoxInEncounterWithSameNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_010";
		encounterData.fetchChartPreVisitTestData();
		verifyPatientComplanitBoxWithSameNote(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/**
	 * verifyPatientComplanitBox
	 * function to verify Patient Complanit Box
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
	 * @since  	    Dec 24, 2012
	 */
	public boolean verifyPatientComplanitBoxWithNewNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter in Encounter tab//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
		//	assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"providerSuggestBoxIdsuggestBox",encounterData.provider);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,"//div[3]/input",encounterData.chiefComplaint);
			
			assertTrue(type(selenium,chiefComplaintTextBox,encounterData.chief),"Could not Enter the chief", selenium, ClassName, MethodName);
			
			//assertTrue(click(selenium,"sign"),"Could not click the  sign button");
			
		    assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);

		    //assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
		
			
			selenium.focus(lnkBeginEncounterAction);
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.fireEvent(lnkBeginEncounterAction, "click");
		
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Aagin Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"providerSuggestBoxIdsuggestBox",encounterData.provider);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,chiefComplaint,encounterData.chiefComplaint);
			assertTrue(type(selenium,chiefComplaintText,encounterData.chief),"Could not Enter the chief", selenium, ClassName, MethodName);
			assertTrue(click(selenium,"sign"),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return true;
		
	}
	
	/**
	 * verifyPatientComplanitBoxWithSameNote
	 * function to verifyPatient ComplanitBox WithSameNote
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 24, 2012
	 */
	public boolean verifyPatientComplanitBoxWithSameNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter in Encounter tab//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
		//	assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"providerSuggestBoxIdsuggestBox",encounterData.provider);
			waitForPageLoad(selenium);
			
			
			selectValueFromAjaxList(selenium,"//div[3]/input",encounterData.chiefComplaint);
			//click(selenium,"//div[5]/div/div/div/div/div");
			assertTrue(type(selenium,chiefComplaintTextBox,encounterData.chief),"Could not Enter the chief", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			selenium.clickAt(lnkBeginEncounterAction, "");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction, "keyPress");
			waitForPageLoad(selenium);
			/*assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+encounterData.toString());
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+encounterData.toString());
			waitForPageLoad(selenium);*/
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Aagin Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			
			selectValueFromAjaxList(selenium,"providerSuggestBoxIdsuggestBox",encounterData.provider);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,chiefComplaint,encounterData.chiefComplaint);
			assertTrue(type(selenium,chiefComplaintText,encounterData.chief),"Could not Enter the chief", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,"//body/div[5]/div/div")){
				assertTrue(click(selenium,"//body/div[5]/div/div"),"Could not click the link", selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium,"sign"),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return true;
		
	}
}
