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

public class VerifyStoredValueOfSignedEncounter extends AbstractChartPreVisit{
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing whether Begin Encounter button present after saving an encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueOfSignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_014";
		encounterData.fetchChartPreVisitTestData();
		verifySignedEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	/**
	 * verifySignedEncounter
	 * function to verify whether Begin Encounter button present after saving an encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 20, 2012
	 */

	public boolean verifySignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		String date=null;
		String time=null;
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
			assertTrue(switchRole(selenium,"FULL"),"unable to switch the user role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
			//assertTrue(deleteAllEncounters(selenium,encounterData),"Delete encounter  Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
						date=DateForma1t.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH:mm");
						time=DateFormat.format(cal.getTime());
					}else{
						SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
						date=DateFormat2.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH:mm");
						time=DateFormat.format(cal.getTime());
					}
				}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH:mm");
				time=DateFormat.format(cal.getTime());
				}
			System.out.println(time);
			//--------------------------------------------------------------------//
			//  Step-4: Sign the encounter//
			//--------------------------------------------------------------------//
			
			assertTrue(isElementPresent(selenium,"sign"),"Could not sign encounter", selenium, ClassName, MethodName);
			//assertTrue(click(selenium,"sign"),"Could not click the sign button", selenium, ClassName, MethodName);
			
			selenium.focus("sign");
			selenium.click("sign");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(verifyStoredValues(selenium,encounterData,date,time),"The signed encounter is not saved properly", selenium, ClassName, MethodName);
			
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}return returnValue;
		
	}

	public boolean verifyStoredValues(Selenium selenium,ChartPreVisitLib encounterData,String date,String time) throws IOException{
		boolean returnValue=true;
				
	System.out.println(getText(selenium,lblComplaintEncounter));
		/*if(!getText(selenium,lblComplaintEncounter).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.provider1.trim().toLowerCase(new java.util.Locale("en","US"))))
			return false;*/
	
	assertTrue(selenium.isTextPresent("Chief Complaint"), "" + "Injection Not Present", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
		
	return returnValue;
	}
}		
