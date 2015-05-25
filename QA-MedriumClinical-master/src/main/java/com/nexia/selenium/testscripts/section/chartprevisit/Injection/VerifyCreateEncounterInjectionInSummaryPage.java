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

public class VerifyCreateEncounterInjectionInSummaryPage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify Encounter Injection in summary page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCreateEncounterInjectionInSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_020";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * addInjection
	 * Function to verify Encounter Injection in summary page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @throws IOException 
	 * @since  	    Nov 01, 2012
	 */
	public boolean addInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws InterruptedException, IOException{
		String date=null;
		String time = null;
		
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
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Exit Injection//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,btnInjectsave),"Could not click the cancel button;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,injectionData),"Deletion failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Begin Encounter                               //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigate to Begin Encounter failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Delete Exit Injection//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounterInjection(selenium,injectionData),"Deletion Failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-6: Create Injection//
			//--------------------------------------------------------------------//
			//assertTrue(click(selenium,lnkInjection),"Could not click the injection link");
			//waitForPageLoad(selenium);
			
			
			assertTrue(isElementPresent(selenium,lnkEncounterInjection),"Could not find the link",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterInjection,"");
			//selenium.focus(lnkInjection);
			//selenium.fireEvent(lnkInjection,"keypress");
			
			waitForPageLoad(selenium);
			
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Get Current Data and Time
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM dd, yyyy");
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
			//Click on save 
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			//--------------------------------------------------------------------//
			//  Step-7: verify Stored Value in summary page//
			//--------------------------------------------------------------------//
			if(!verifyStoredValue(selenium, injectionData, date, time,providerName)){
				Assert.fail("injection details not saved properly; More Details :"+ injectionData.toString());
			}
			//--------------------------------------------------------------------//
			//  Step-8: verify Stored Value for Injection in List view            //
			//--------------------------------------------------------------------//
			try{
			assertTrue(click(selenium,lnkInjection),"Could not click the link;",selenium, ClassName, MethodName);
			}catch(Exception e){
				assertTrue(click(selenium,lnkInjection),"Could not click the link;",selenium, ClassName, MethodName);
			}
			
			//waitForPageLoad(selenium);
			
			if(!verifyCollapseViewForInjection(selenium, injectionData,userAccount)){
				Assert.fail("injection details not saved properly; More Details :"+ injectionData.toString());
			}
				
			if(!verifyExpandViewForInjection(selenium, injectionData,providerName, date, time)){
				Assert.fail("injection details not saved properly; More Details :"+ injectionData.toString());
			}
			else
			returnValue=true;
			
	
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + injectionData.toString());
		}
		return returnValue;
	}
	
	
	
	
	public boolean verifyStoredValue(Selenium selenium, ChartPreVisitLib injectionData,String date,String time, String providerName ) throws IOException{
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,injectionSummaryArrow), "Could not click on expand arrow",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
		assertTrue(selenium.isTextPresent(injectionData.injection.trim()),"Could not Find the text",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(injectionData.reaction.trim()),"Could not Find the text",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(injectionData.comment),"Could not Find the text",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(injectionData.dosage.trim()),"Could not Find the text dosage",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(injectionData.dosageUnit.trim()),"Could not Find the text dosageUnit",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(providerName.trim()),"Could not Find the text",selenium, ClassName, MethodName);
		//assertTrue(selenium.isTextPresent(injectionData.route.trim()),"Could not Find the text route",selenium, ClassName, MethodName);
		//assertTrue(selenium.isTextPresent(injectionData.site.trim()),"Could not Find the text site",selenium, ClassName, MethodName);
		//assertTrue(selenium.isTextPresent(injectionData.lotNumber.trim()),"Could not Find the text lotNumber",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(date.trim()),"Could not Find the text date",selenium, ClassName, MethodName);
		//assertTrue(selenium.isTextPresent(injectionData.verifyCpt1.trim()),"Could not Find the text verifyCpt1",selenium, ClassName, MethodName);
		//assertTrue(selenium.isTextPresent(injectionData.verifyCpt2.trim()),"Could not Find the text verifyCpt2",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		/*assertTrue(verifyTimeStampForProviderPage(selenium,"xpath=(//div[@id='chartListItemFullWidthWrapper'])[8]", date, time),"Verification failed",selenium, ClassName, MethodName);*/
		//waitForPageLoad(selenium);
			return true;

	}
}
