package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySaveInEncounterNote extends AbstractChartPreVisit{
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
	 * @throws     IOException 
	 * @since  	    Nov 28, 2012
	 */
	public boolean verifySaveEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		String date=null;
		String time=null;
		int count=0;
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
			/*String str1 = getText(selenium,lnkTopMenu);
			String Provider =str1.replaceAll(", FULL", "");
			
			String a=getValue(selenium,ajxEncounterProvider);
			if(getValue(selenium,ajxEncounterProvider).equals(Provider)){
				returnValue = true;
			}else
				fail("The Provider name is not getting displyed Properly");*/
			
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"Could not click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("HH:mm");
				time=DateFormat1.format(cal.getTime());
				waitForPageLoad(selenium);
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat.format(cal.getTime());
				waitForPageLoad(selenium);
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("HH:mm");
				time=DateFormat1.format(cal.getTime());
				waitForPageLoad(selenium);
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				waitForPageLoad(selenium);
			}
				
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			while(selenium.isElementPresent(lnkShowMore) && count<=5)
					{
				selenium.click(lnkShowMore);
				waitForPageLoad(selenium);
				count++;
			}
			waitForPageLoad(selenium);
			assertTrue(verifyStoredValue(selenium,encounterData,time,date),"The encounter is not signed", selenium, ClassName, MethodName);
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		}
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib encounterData,String time,String date){
		boolean returnValue=true;
		
		
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String providerName= providerNameTemp.replaceAll(", "+ encounterData.switchRole , "");
		System.out.println(providerName);
		if(!getText(selenium,elementLabSummary).trim().toLowerCase(new java.util.Locale("en","US")).contains(providerName.trim().toLowerCase(new java.util.Locale("en","US"))))
			return false;
		System.out.println(getText(selenium,lblPendingEncounter));
		System.out.println(time);
		/*if(!getText(selenium,lblPendingEncounter.trim()).contains(time.trim()))
			return false;*/
	//	if(!getText(selenium,elementLabSummary).contains(date))
	// 		return false;
		if(getValue(selenium,BeginEncounter).contains("Begin Encounter"))
			return false;
		return returnValue;

	}
}
