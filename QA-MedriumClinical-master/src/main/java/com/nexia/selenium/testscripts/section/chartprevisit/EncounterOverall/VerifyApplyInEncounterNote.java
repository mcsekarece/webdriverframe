package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyApplyInEncounterNote extends AbstractChartPreVisit{
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing sign functionality in Encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveInEncounterNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_001";
		encounterData.fetchChartPreVisitTestData();
		verifySaveEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	/**
	 * verifySaveEncounter
	 * function to verify save functionality in Encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 28, 2012
	 */
	public boolean verifySaveEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
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
		
		assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(deleteAllEncounters(selenium,encounterData),"Could nor delete", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3: Begin an encounter//
		//--------------------------------------------------------------------//
		assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-4: Save the encounter//
		//--------------------------------------------------------------------//
		
		selectValueFromAjaxList(selenium,"providerSuggestBoxIdsuggestBox",encounterData.provider);
		selenium.focus( btnApplyEncounter);
		selenium.clickAt( btnApplyEncounter, "Could not click apply button");
		
		//assertTrue(click(selenium,"apply"),"Could not click the save button");
		assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-5: Advanced search with Patient ID//
		//--------------------------------------------------------------------//
		
		assertTrue(verifyStoredValue(selenium,encounterData),"The encounter is not signed", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return returnValue;
	}
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib encounterData){
		boolean returnValue=true;
		
		if(getValue(selenium,"//div[3]/button").contains("Begin Encounter"))
			return false;
		if(getValue(selenium,"providerSuggestBoxIdsuggestBox").contains("encounterData.provider"))
			return false;
		
		if(getText(selenium,"css=div.gwt-Label").contains(encounterData.provider1))
			return false;
		return returnValue;
	
	}
}
