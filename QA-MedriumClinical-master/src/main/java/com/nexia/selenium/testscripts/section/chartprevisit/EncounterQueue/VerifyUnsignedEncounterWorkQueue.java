package com.nexia.selenium.testscripts.section.chartprevisit.EncounterQueue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnsignedEncounterWorkQueue extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing save functionality in Encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveInEncounterNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_012";
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
	 * @defect      #2121	
	 * @throws     IOException 
	 * @since  	    Nov 28, 2012
	 */
	public boolean verifySaveEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		String date = null;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			assertTrue(switchRole(selenium,encounterData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

		//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
			
			assertTrue(deleteAllEncounters(selenium,encounterData),"Could nor delete", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		

			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Save the encounter//
			//--------------------------------------------------------------------//
		
			
			
			assertTrue(clickAt(selenium,lnkBeginEncounterAction,""),"Could not Click ", selenium, ClassName, MethodName);
			assertTrue(focus(selenium,lnkBeginEncounterAction),"Could not Focus ", selenium, ClassName, MethodName);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"Could not click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Home page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Encounter Queue//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkUnSigned),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxShow,"My encounters"),"Could not select", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblUnEncounterQueue),"Could not click the First record", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "!chartTimeline"),"Could not click Edit ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ encounterData.switchRole , "");
			
			//Verify the edited details
		
			assertTrue((selenium.isTextPresent("This note has been edited by " +providerName)),"Could not select", selenium, ClassName, MethodName);
						
			

			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
