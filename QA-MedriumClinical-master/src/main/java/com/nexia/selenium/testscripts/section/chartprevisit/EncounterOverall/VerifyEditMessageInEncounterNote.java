package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditMessageInEncounterNote extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing whether Begin Encounter button present after saving an encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void verifyEncounterInProgressButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_007";
		encounterData.fetchChartPreVisitTestData();
		verifyEncounterButton(seleniumHost, seleniumPort, browser, webSite,userAccount, encounterData);
	}
	/**
	 * verifyEncounterButton
	 * function to verify whether Begin Encounter button present after saving an encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 15, 2012
	 */

	public boolean verifyEncounterButton(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
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
			assertTrue(deleteAllEncounters(selenium,encounterData),"could not Delete", selenium, ClassName, MethodName);
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,btnBeginEncounter),"Could not find the begin encounter button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnBeginEncounter),"Could not begin encounter", selenium, ClassName, MethodName);
			if(isElementPresent(selenium,"beginNewEncounter"))
				assertTrue(click(selenium,"beginNewEncounter"),"Could not click the link", selenium, ClassName, MethodName);

			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
				}
			String str = getText(selenium, lnkTopMenu);
			String Rprovider = str.replaceAll(", " + encounterData.switchRole, "");

			String tempArray[] = Rprovider.split(" ");
			String providerName = tempArray[1] + ", " + tempArray[0];
			if(isElementPresent(selenium,"link="+providerName.toUpperCase()))
			{
			assertTrue(click(selenium,"link="+providerName.toUpperCase()),"could not click link", selenium, ClassName, MethodName);
			}
			assertTrue(selectValueFromAjaxList(selenium,ajxProviderSugBox,"ABRAHAM"),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,btnApplyEncounter),"Could not click apply button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium,"css=div.edited-encounter-note-message > div.gwt-Label").contains("This note has been edited by"))
				returnValue=true;
			else
				Assert.fail("Note messaqge not present");
				
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		}
	}
