package com.nexia.selenium.testscripts.section.chartprevisit.cosign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyOnBehalfOfForPrescribePage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing default value in on behalf of ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOnbehalfOfForCosignEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_006";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCoEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing default value in on behalf of with out Supervisior Name ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOnbehalfOfwithoutSuperVisiorName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_007";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCoEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	
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
			String provider= getText(selenium, lnkTopMenu);
			String providerName= provider.split(",")[0];
			waitForPageLoad(selenium);
		
		if(encounterData.testCaseId.equals("TC_CO_006"))
		{	assertTrue(click(selenium,lnkSettings),"Could not click the Quick option", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,"systemSettingsAction"),"Could not click the system setting link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(searchCurrentProviders(selenium,providerName),"Could not search the current provider in Provider section under System Setting Section", selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkEditEncounter),"Could not click Edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		encounterData.CosignProv=selenium.getValue(ajxSupervisorName).trim();
		
			if(encounterData.CosignProv.contains("No supervisor required"))			{
				Assert.fail("Current provider does not have Supervisor:::Please add super in Provider setting");
			}
			else			{
				returnValue=true;
			}	
		}
		if(encounterData.testCaseId.equals("TC_CO_007"))		{
			assertTrue(click(selenium,lnkSettings),"Could not click the Quick option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"systemSettingsAction"),"Could not click the system setting link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchCurrentProviders(selenium,providerName),"Could not search the current provider in Provider section under System Setting Section", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkEditEncounter),"Could not click Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			encounterData.CosignProv=selenium.getValue(ajxSupervisorName).trim();
				if(encounterData.CosignProv.contains("No supervisor required"))				{
					returnValue=true;
					
				}
				else				{
					Assert.fail("Current provider Should not have Supervisor:::Please remove super in Provider setting");
				}
		}
		
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not click the Quick option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"//a[@id='patientOptionsPrescribeMedication']/span"),"Could not click the Quick option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Verify default value//
			//--------------------------------------------------------------------//
	assertTrue(verifySuggestBox(selenium,encounterData),"Verifying On behalf of suggest box in Create DI order page failed (suggest box mighnt not have supervisor or current provider name)", selenium, ClassName, MethodName);
		
}	
catch(Exception e)
{
	Assert.fail(e.getMessage());
	
	
}	return returnValue;	
	
	}

	public boolean verifySuggestBox(Selenium selenium, ChartPreVisitLib encounterData)
	{
				String supervisorName=selenium.getValue(ajxProvider);	
			
		if(encounterData.testCaseId.equals("TC_CO_006"))
		{
			
			if(supervisorName.trim().toLowerCase().contains(encounterData.CosignProv.toLowerCase()))
			{
				return true;
			}
		
			else
				{
				
		Assert.fail("OnBehalf of Suggest box does not has Supervisior Provider name");
		return false;
				}
				
		}
		else
		{
			String currentprovider[]=selenium.getText(vfyUserName).replace(", FULL ", "").split(" ");
			String currentProviderName=currentprovider[1]+" "+currentprovider[0];
			encounterData.CosignProv=currentProviderName;
			if(supervisorName.trim().toLowerCase().contains(encounterData.CosignProv.toLowerCase()))
			{
				return true;
			}
		
			else
				{
				
				return false;	
				}
					}

	
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
		assertTrue(click(selenium,btnActiveHealth)," ", selenium, ClassName, MethodName);
			}	
		assertTrue(	click(selenium,FirstProvider),"Could not click tha first provider", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
			return true;		
		}
		else
		{
			return false;
		}
			
		
	
    }		


	
	
	
	
	
	
	
	
	
	





























}
