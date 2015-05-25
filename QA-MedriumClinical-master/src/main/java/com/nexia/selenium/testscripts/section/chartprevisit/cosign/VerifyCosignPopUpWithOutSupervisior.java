package com.nexia.selenium.testscripts.section.chartprevisit.cosign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCosignPopUpWithOutSupervisior extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing CO-sign pop up in Encounter Note After Removed Provider name in Provider settings ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoSignPopUp(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_009";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyPopUp(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}

	public boolean verifyPopUp(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
	boolean returnValue=false;
	try
	{
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, "doctor", "orthodoc"),"Login Failed ",selenium,ClassName,MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-2:Add supervisor name and remove it for current Provider //
		//--------------------------------------------------------------------//
		/*String provider= getText(selenium, lnkTopMenu);
		String ProviderName= provider.split(",")[0];
		String tempprov[]=ProviderName.split(" ");
		ProviderName=tempprov[1];
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkSettings),"Could not click the Quick option", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,"systemSettingsAction"),"Could not click the system setting link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(searchCurrentProviders(selenium,ProviderName),"Could not search the current provider in Provider section under System Setting Section", selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkEditEncounter),"Could not click Edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxSupervisorName,"a");
		assertTrue(type(selenium,txtDurationFrom,"06/06/2014"),"Could not Enter Duration from date in Edit provider", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtDurationTo,"02/02/2016"),"Could not Enter Duration To date in Edit provider", selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnSave3),"Could not click the Save Buttton", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(!isElementPresent(selenium,btnSave3),"Provider edit page not saved", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkEditEncounter),"Could not click Edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxSupervisorName,"No supervisor required"),"Could not click Supervisor suggest box",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSave3),"Could not click the Save Buttton", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(!isElementPresent(selenium,btnSave3),"Provider edit page not saved", selenium, ClassName, MethodName);*/
		//--------------------------------------------------------------------//  
		//  Step-3: Advanced search with Patient ID//
		//--------------------------------------------------------------------//
		assertTrue(switchRole(selenium,"FULL"), "Could not switch the role", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button",selenium,ClassName,MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-4: Delete Encounter//
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
		//  Step-5: Begin an encounter//
		//--------------------------------------------------------------------//
		
		assertTrue(goToBeginEncounter(selenium),"begin Encounter failed",selenium,ClassName,MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-6: Enter assessment Details//
	 	//--------------------------------------------------------------------//
	selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);
		waitForPageLoad(selenium);		
		deleteProbleforMedRecon(selenium,encounterData);
		waitForPageLoad(selenium);	
		encounterData.workSheetName = "CreateProblemList";
		encounterData.testCaseId = "TC_CPL_013";
		encounterData.fetchChartPreVisitTestData();
		
		//--------------------------------------------------------------------//
		//  Step-7: Create Problem list//
		//--------------------------------------------------------------------//
		
		assertTrue(createProblemList(selenium,encounterData,userAccount),"Creation failed",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);		
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);	
		if(selenium.isConfirmationPresent()){
            System.out.println(selenium.getConfirmation());
            selenium.chooseOkOnNextConfirmation();    }
		assertTrue(click(selenium,btnSign),"could not sign the encounter", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnContinue))
		{
			Assert.fail("Co-sign Pop up not displayed");	
			returnValue=false;
		}
		else
		{
			returnValue= true;
		}
		
		assertTrue(isElementPresent(selenium,"link=Post"),"Encounter is not signed propeerly",selenium,ClassName,MethodName);
	}
	catch(Exception e)
	{
		Assert.fail(e.getMessage());
	}
		
	return returnValue;
	
	}


	public boolean searchCurrentProviders (Selenium selenium,String providerName) throws IOException{

		if(isElementPresent(selenium,chkIncludeInactiveProviderscheckbox)){
		click(selenium,chkIncludeInactiveProviderscheckbox);
		waitForPageLoad(selenium);
		}		
	
	    if(isElementVisible(selenium,btnProviderSearch)){		
		assertTrue(type(selenium,txtProviderSearchbox,providerName),"Could not type the provider first name", selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnProviderSearch),"Could not click the search button", selenium, ClassName, MethodName);			
	    }	
		waitForPageLoad(selenium);
		if(getText(selenium,FirstProvider).toLowerCase(new java.util.Locale("en","US")).trim().contains(providerName.trim().toLowerCase(new java.util.Locale("en","US")))){
		waitForPageLoad(selenium);					
		if(isElementPresent(selenium,btnActiveHealth)){
		assertTrue(click(selenium,btnActiveHealth),"Could not click Active Health ", selenium, ClassName, MethodName);
			}	
		selenium.click(FirstProvider);
		waitForPageLoad(selenium);		
			return true;		
		}
		else
		{
			return false;
		}
		
		/*if(isElementPresent(selenium,vfyProgramDel4)){
			return true;
		}else
			return false;*/	
		
		
	
    }		






























}
