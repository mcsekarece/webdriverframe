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

public class VerifyEditEncounterInjectionInSummaryPage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify Edited Encounter Injection in summary page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditEncounterInjectionInSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_024";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * editInjection
	 * Function to verify Edited Encounter Injection in summary page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 02, 2012
	 */
	public boolean editInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
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
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			//selenium.fireEvent(lnkBeginEncounterAction,"keydown");
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"could not click on encounter save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-3: Delete Exit Injection in medical summary//
			//--------------------------------------------------------------------//
			try{
				selenium.fireEvent(lnkInjection, "click");
			}catch(Exception e){
				selenium.fireEvent(lnkInjection, "click");
			}
			
			assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click on save
			
			if(isElementPresent(selenium,btnCancel))
			assertTrue(click(selenium,btnCancel),"Could not click the save button;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Begin Encounter                               //
			//--------------------------------------------------------------------//
			try{
				selenium.fireEvent(BeginEncounter, "click");
			}catch(Exception e){
				selenium.fireEvent(BeginEncounter, "click");
			}
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEncounterChoosePanel)){

				if(isElementPresent(selenium,lblEncounterChoosePanel)){
					if(isElementPresent(selenium,lnkStartNewWncouter)){
						click(selenium,lnkStartNewWncouter);
					}
					waitForPageLoad(selenium);
				}
			}
					
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Delete Exit Injection in Encounter page//
			//--------------------------------------------------------------------//
			//assertTrue(deleteAllEncounterInjection(selenium,injectionData),"Deletion Failed");
			//waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6: Create Injection in Encounter page//
			//--------------------------------------------------------------------//
			
			//assertTrue(click(selenium,lnkInjection),"Could not click the injection link");
			//waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkEncounterInjection),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterInjection,"");
			waitForPageLoad(selenium);
			selenium.focus(lnkEncounterInjection);
			waitForPageLoad(selenium);
			selenium.fireEvent(lnkEncounterInjection,"keypress");
			
			waitForPageLoad(selenium);
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Get Current Data and Time//
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateForma1t=new SimpleDateFormat("MMMMMM d, yyyy");
						date=DateForma1t.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}else{
						SimpleDateFormat DateFormat2=new SimpleDateFormat("MMMMMM dd, yyyy");
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
			assertTrue(click(selenium,lnkSummary),"Could not click on summary link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			try{
				selenium.fireEvent(lnkInjection, "click");
				//assertTrue(click(selenium,lnkInjection),"Could not click the link;");
			}catch(Exception e){
				selenium.fireEvent(lnkInjection, "click");
					//assertTrue(click(selenium,lnkInjection),"Could not click the link;");
			}
			
			if(!verifyCollapseViewForInjection(selenium, injectionData,userAccount)){
				Assert.fail("injection details not saved properly; More Details :"+ injectionData.toString());
			}
			if (userAccount.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());
			} 
			
			if(!verifyExpandViewForInjection(selenium, injectionData,providerName, date, time)){
				Assert.fail("injection details not saved properly; More Details :"+ injectionData.toString());
			}
			
			//Click on cancel
			assertTrue(click(selenium,"cancelInjection"),"Could not click the save1 button;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9:Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
			try{
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
				//selenium.fireEvent("//div[3]/button", "click");
			}catch(Exception e){
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEncounterChoosePanel)){

				if(isElementPresent(selenium,lblEncounterChoosePanel)){
					if(isElementPresent(selenium,lnkStartNewWncouter)){
						click(selenium,lnkStartNewWncouter);
					}
					waitForPageLoad(selenium);
				}
			}
				
			//Click on created Injection and select edit button
			assertTrue(isElementPresent(selenium,lblEncounterInjection),"Could not find encounter details",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lblEncounterInjection), "Could not click on created Injection",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium, lblEncounterSave), "Could not click on Edit button",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			assertTrue(click(selenium, btnInjectionEditEncounter), "Could not click on Edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			injectionData.workSheetName = "CreateInjection";
			injectionData.testCaseId = "TC_CI_002";
			injectionData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-10: Edit Injection//
			//--------------------------------------------------------------------//
			
			assertTrue(editInjection(selenium,injectionData,userAccount,providerName),"Edit injection Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: Get current date and Time//
			//--------------------------------------------------------------------//
		
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateForma1t=new SimpleDateFormat("MMMMMM d, yyyy");
						date=DateForma1t.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}else{
						SimpleDateFormat DateFormat2=new SimpleDateFormat("MMMMMM dd, yyyy");
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
			
			//Click on Action button and select save 
			assertTrue(click(selenium, lnkBeginEncounterAction),"Could not click on Action button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"Could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//Click on Injection in medical summary
			try{
				selenium.fireEvent(lnkInjection, "click");
				//assertTrue(click(selenium,lnkInjection),"Could not click the link;");
			}catch(Exception e){
				selenium.fireEvent(lnkInjection, "click");
					//assertTrue(click(selenium,lnkInjection),"Could not click the link;");
			}
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: verify Stored Value for edited Injection in List view            //
			//--------------------------------------------------------------------//
			if(!verifyCollapseViewForInjection(selenium,injectionData,userAccount)){
				Assert.fail("Injection details not saved properly; More Details :"+ injectionData.toString());
			}
			if (userAccount.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MMM dd, yyyy");
				date = DateFormat.format(cal.getTime());
			}
			
			assertTrue(verifyExpandViewForInjection(selenium,injectionData,providerName, date,time), "Injection details not saved properly; More Details :"+ injectionData.toString(), selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + injectionData.toString());
		}
		return returnValue;
	}
}
