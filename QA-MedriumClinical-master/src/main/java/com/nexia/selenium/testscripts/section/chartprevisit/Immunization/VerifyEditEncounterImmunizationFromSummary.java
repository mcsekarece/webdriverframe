package com.nexia.selenium.testscripts.section.chartprevisit.Immunization;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditEncounterImmunizationFromSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Edit Encounter Immunization From Summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditEncounterImmunizationFromSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_043";
		immunizationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	/**
	 * editImmunization
	 * function to edited Immunization in summary present in encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 02, 2012
	 */

	public boolean editImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
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
			
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllEncounters(selenium,immunizationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Immunization//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium)," Could not navigate to begin encounters", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Existing Encounter Immunization//
			//--------------------------------------------------------------------//
			//assertTrue(deleteEncounterImmunization(selenium),"Could not delete the record");
			//waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,"//div[4]/div/div/div[5]/div/a"),"Could not click the Immunization link");
			
			assertTrue(isElementPresent(selenium,lnkEncounterImmunization),"Could not find the link", selenium, ClassName, MethodName);
			
			
			selenium.clickAt(lnkEncounterImmunization,"");
			//selenium.focus(lnkImmunization);
			//selenium.fireEvent(lnkImmunization,"keypress");
			waitForPageLoad(selenium);
					
			//--------------------------------------------------------------------//
			//  Step-6: Create Encounter Immunization//
			//--------------------------------------------------------------------//
			
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.focus(lnkBeginEncounterAction);
			selenium.clickAt(lnkBeginEncounterAction,"");
			waitForPageLoad(selenium);
			
			//selenium.fireEvent(lnkBeginEncounterAction,"keypress");                          
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Immunization //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSummary),"Could not click on summary link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_008";
			immunizationData.fetchChartPreVisitTestData();
			
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnImmunizationEdit),"Could not Fine the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnImmunizationEdit),"Could not click the edit button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Editing immunization failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSaveImmunization),"Could not click the save button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8:Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium)," Could not navigate to begin encounters", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,BeginEncounter),"Could not fine the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,BeginEncounter),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//assertTrue(click(selenium,"//td[2]/div[4]"),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9: verify Stored Value In Encounter//
			//--------------------------------------------------------------------//
			assertTrue(clickAt(selenium,lnkImmunization,""),"Couls not click immunization link"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoredValue(selenium,immunizationData,userAccount),"Immunization details not saved properly; More Details :"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
										
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValue(Selenium selenium, ChartPreVisitLib immunizationData,String account) throws IOException{
		String date=null;
				
		waitForPageLoad(selenium);
		if (account.equals(CAAccount)) {
			assertTrue(selenium.isTextPresent(immunizationData.Vaccine1CA), " "+ "immunization vaccine Not Present", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);		
		}
		else
		{
			assertTrue(selenium.isTextPresent(immunizationData.vaccineUS), " "+ "immunization vaccine Not Present", selenium, ClassName,MethodName);
			
		}
	
	assertTrue(selenium.isTextPresent(immunizationData.reaction), " "+ "immunization reaction Not Present", selenium, ClassName, MethodName);		
		
			
		
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
				
			}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
		
		}
		//System.out.println(getText(selenium,lblEncouterImmDetails1));
				
		assertTrue(selenium.isTextPresent(date), "" + "Date Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(immunizationData.comment), " "+ "immunization comment Not Present", selenium, ClassName,	MethodName);
		
		
		return true;
	}	
}

