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

public class VerifyDeleteEncounterInjectionInSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify deleted Encounter Injection in summary page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteInjectionInEncounterSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_022";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * addInjection
	 * Function to verify deleted Encounter Injection in summary page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 01, 2012
	 */
	public boolean addInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date=null;
		String time=null;
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
			//  Step-3: Delete Exit Injection//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkInjection),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCancel),"Could not click the save button;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Begin Encounter                               //
			//--------------------------------------------------------------------//
		
			
		assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Injection//
			//--------------------------------------------------------------------//
			//assertTrue(click(selenium,lnkInjection),"Could not click the link;");
			//waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkInjection),"Could not find the link",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			selenium.clickAt(lnkInjection,"");
			//selenium.focus(lnkInjection);
			//selenium.fireEvent(lnkInjection,"keypress");
			
			waitForPageLoad(selenium);
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Get current date and Time
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
						date=DateForma1t.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}else{
						SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
						date=DateFormat2.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}
				}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				time=DateFormat.format(cal.getTime());
			}
		
			//--------------------------------------------------------------------//
			//  Step-8: verify Stored Value for Injection in List view            //
			//--------------------------------------------------------------------//
			try{
				selenium.fireEvent(lnkSummary, "click");
				selenium.fireEvent(lnkInjection, "click");
				//assertTrue(click(selenium,lnkInjection),"Could not click the link;");
			}catch(Exception e){
				//assertTrue(click(selenium,lnkInjection),"Could not click the link;");
				selenium.fireEvent(lnkSummary, "click");
				selenium.fireEvent(lnkInjection, "click");
			}
			waitForPageLoad(selenium);
			
			if(!verifyCollapseViewForInjection(selenium, injectionData,userAccount)){
				Assert.fail("injection details not saved properly; More Details :"+ injectionData.toString());
			}
			
			if(!verifyExpandViewForInjection(selenium, injectionData,providerName, date, time)){
				Assert.fail("injection details not saved properly; More Details :"+ injectionData.toString());
				returnValue=false;
			}
			else
				returnValue=true;
			//Click on save button in List view
			assertTrue(click(selenium,btnInjectsave),"Could not click the save button;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to Begin Encounter                               //
			//--------------------------------------------------------------------//
			try{
				selenium.clickAt(BeginEncounter, "");
				selenium.focus(BeginEncounter);
				selenium.fireEvent(BeginEncounter, "keypress");
				//selenium.fireEvent(BeginEncounter, "click");
			}catch(Exception e){
				selenium.clickAt(BeginEncounter, "");
				selenium.focus(BeginEncounter);
				selenium.fireEvent(BeginEncounter, "keypress");
				
				//selenium.fireEvent(BeginEncounter, "click");
			}
			
			
			/*if(isElementPresent(selenium, BeginEncounter)){
				assertTrue(click(selenium, BeginEncounter));
				waitForPageLoad(selenium);*/
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	        
	        waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblEncounterChoosePanel)){
					if(isElementPresent(selenium,lnkStartNewWncouter)){
						click(selenium,lnkStartNewWncouter);
					}
					waitForPageLoad(selenium);
				}
				assertTrue(isElementPresent(selenium,lnkEncounterAction),"Sign button is not present",selenium, ClassName, MethodName);
			//}
			//--------------------------------------------------------------------//
			//  Step-3: Delete created Injection//
			//--------------------------------------------------------------------//
				if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		        
		        waitForPageLoad(selenium);	
			assertTrue(deleteAllEncounterInjection(selenium,injectionData),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	        
	        waitForPageLoad(selenium);
			//Click on action and select save
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"could not click on encounter save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click on injection in medical summary page
			try{
				selenium.fireEvent(lnkInjection, "click");
			}catch(Exception e){
				selenium.fireEvent(lnkInjection, "click");
			}
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnInjectionEdit)){
				returnValue = false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + injectionData.toString());
		}
		return returnValue;
	}
	
}
