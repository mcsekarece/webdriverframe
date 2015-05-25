package com.nexia.selenium.testscripts.section.chartprevisit.Injection;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditInjectionInEncounterFromSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify, Edited Injection in summary page present in Encounter page ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditInjectionInEncounterFromSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_025";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * editInjection
	 * Function to verify, Edited Injection in summary page present in Encounter page 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 01, 2012
	 */
	public boolean editInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + injectionData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, injectionData.userName, injectionData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,injectionData.patientId);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,injectionData),"Deletion failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Begin Encounter                               //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Injection//
			//--------------------------------------------------------------------//
			//assertTrue(deleteAllEncounterInjection(selenium,injectionData),"Deletion Failed");
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Injection in Encounter page//
			//--------------------------------------------------------------------//
			
			//assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkEncounterInjection),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterInjection,"");
			selenium.focus(lnkEncounterInjection);
			selenium.fireEvent(lnkEncounterInjection,"keypress");
			
			waitForPageLoad(selenium);
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click on Action and select save 
			/*assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+injectionData.toString());
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+injectionData.toString());
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+injectionData.toString());
			waitForPageLoad(selenium);*/
			
			injectionData.workSheetName = "CreateInjection";
			injectionData.testCaseId = "TC_CI_002";
			injectionData.fetchChartPreVisitTestData();
			
			//Click on Injection in medical summary
			assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click on Edit 
			assertTrue(click(selenium, btnInjectionEdit), "Could not click on Edit",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------------------------//
			//  Step-6: Edit Injection in summary page which is created in Encounter page  //
			//-----------------------------------------------------------------------------//
			assertTrue(editInjection(selenium,injectionData,userAccount,providerName),"Edit injection Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click on save
			//assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+injectionData.toString());
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Again Navigate to Encounter                               //
			//--------------------------------------------------------------------//
		    assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
		
			//--------------------------------------------------------------------//
			//  Step-8: Verify Stored Value                                       //
			//--------------------------------------------------------------------//
			if(!verifyStoredValue(selenium,injectionData,userAccount)){
				Assert.fail("Injection details not saved properly; More Details :"+ injectionData.toString());
				returnValue=false;
			}else
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + injectionData.toString());
		}
		return returnValue;
	}
	
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib injectionData,String account) throws IOException{
		//assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:"+injectionData.toString());
		String date=null;
		waitForPageLoad(selenium);
		//System.out.println(getText(selenium,"//div[7]/div/div"));
		
		assertTrue(isTextPresent(selenium,injectionData.injection.toUpperCase()),""+"Injection Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
			
		assertTrue(isTextPresent(selenium,injectionData.reaction),""+"Injection Reaction Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
			
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
			date=DateFormat.format(cal.getTime());
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
		}
		waitForPageLoad(selenium);
		System.out.println(date);
		
		assertTrue(isTextPresent(selenium,date),""+"Injection Date Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(isTextPresent(selenium,injectionData.comment),""+"Injection Comment Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
	
		return true;
	}
}
