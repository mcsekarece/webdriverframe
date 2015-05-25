package com.nexia.selenium.testscripts.section.chartprevisit.cosign;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;
public class EditModeOfSaveEncounter extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing saved encounter in  encounter Queue ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCOSignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_002";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCoEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}

/**
 * Verify  saved encounter in  encounter Queue 
 *  * Function to verify search filter
 * @param 		seleniumHost
 * @param 		seleniumPort
 * @param 		browser
 * @param 		webSite
 * @throws IOException 
 * @since  	    May 30,2014
 */
	
	public boolean verifyCoEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
	
	try
	{		
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
		
		//--------------------------------------------------------------------//  
		//  Step-2: Advanced search with Patient ID//
		//--------------------------------------------------------------------//
		
		searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button",selenium,ClassName,MethodName);		
		//--------------------------------------------------------------------//
		//  Step-3: Delete Encounter//
		//--------------------------------------------------------------------//
		assertTrue(deleteAllEncounters(selenium,encounterData),"Creation Failed",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isVisible(lnkProblemList),"Problem List Link Not Visible;More Details",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(deleteAllProblemList(selenium, encounterData),"Deletion faied",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-4: Begin an encounter//
		//--------------------------------------------------------------------//
		
		assertTrue(goToBeginEncounter(selenium),"begin Encounter failed",selenium,ClassName,MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-5: Enter assessment Details//
	 	//--------------------------------------------------------------------//
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("ddyymm:HH:ss");
		String date=DateFormat.format(cal.getTime());
		encounterData.chiefComplaint=encounterData.chiefComplaint+date;
		String searchKeyWord=	encounterData.chiefComplaint;
		assertTrue(selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition),"Could not select",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);		
		encounterData.workSheetName = "CreateProblemList";
		encounterData.testCaseId = "TC_CPL_013";
		encounterData.fetchChartPreVisitTestData();
		
		//--------------------------------------------------------------------//
		//  Step-6: Create Problem list//
		//--------------------------------------------------------------------//
		
		assertTrue(createProblemList(selenium,encounterData,userAccount),"Creation failed",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);		
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);	
		if(selenium.isConfirmationPresent()){
            System.out.println(selenium.getConfirmation());
            selenium.chooseOkOnNextConfirmation();    }	
		waitForPageLoad(selenium);		
		assertTrue(type(selenium,txtChiefCompliant,encounterData.chiefComplaint),"Could not select",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);	
		selenium.fireEvent(txtChiefCompliant, "blur");
		waitForPageLoad(selenium);	
		//--------------------------------------------------------------------//
		//  Step-7: Save Encounter											//
		//--------------------------------------------------------------------//
		selenium.clickAt(lnkBeginEncounterAction,"");
		selenium.focus(lnkBeginEncounterAction);
		selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
		waitForPageLoad(selenium);
 		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblEncounterSave),"Could not click", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		//--------------------------------------------------------------------//
		//  Step-8: Navigate to Home page//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium, btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-9: Navigate to Encounter Queue and Search Saved Encounter//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkUnSigned),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);      
		waitForPageLoad(selenium);
		assertTrue(type(selenium,"searchTextBox",searchKeyWord),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);
		selenium.keyPress("searchTextBox", "\\13");
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"My encounters"),"Could not select",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);		
		if(isElementPresent(selenium,"unsignedEncounterListItem"))
		{
			assertTrue(click(selenium, "unsignedEncounterListItem"),"Could not click the Save encounter in Unsaved encounter queue ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);	
		}
		else
		{
			Assert.fail("serach result failed in unsigned encounter queue");
		}
		//--------------------------------------------------------------------//
		//  Step-9: Navigate to Encounter Queue and Search Saved Encounter//
		//--------------------------------------------------------------------//
			assertTrue(verifyEditWindow(selenium),"Verification of edit window failed",selenium,ClassName,MethodName);
			
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	return returnValue;	
	}
	
	
	public boolean verifyEditWindow(Selenium selenium) throws IOException
	{					
		assertTrue(selenium.isElementPresent(btnSign),"Could not find the Assement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);			
	return true;	
		
	}
	
}
