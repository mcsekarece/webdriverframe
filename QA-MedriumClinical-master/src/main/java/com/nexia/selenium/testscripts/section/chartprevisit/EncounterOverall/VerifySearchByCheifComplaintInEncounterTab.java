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

public class VerifySearchByCheifComplaintInEncounterTab extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing whether Begin Encounter button present after saving an encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchByCheifComplaintInEncounterTab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_009";
		encounterData.fetchChartPreVisitTestData();
		verifySearchPatientComplanitInEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        Verify Search By CheifComplaint Name In Encounter Tab 
	* @action 		  verifying Search By CheifComplaint Name In Encounter Tab
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Dec 19, 2013	
	***************************************************************************************************/
	public boolean verifySearchPatientComplanitInEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		String date;
		String chiefCompliant1;
		String chiefCompliant2;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to begin encounter								  //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter with 'chief complaint'				  //
			//--------------------------------------------------------------------//
			
			//Get the current date and time and append with chief complaint
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			DateFormat = new SimpleDateFormat("MM_dd_YYYY HH-mm-ss");
			date = DateFormat.format(cal.getTime());
			
			chiefCompliant1= encounterData.chief+ date;
			
			assertTrue(type(selenium,txtChiefCompliant,chiefCompliant1),"Could not Enter the chief", selenium, ClassName, MethodName);
		    assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);

			selenium.focus(lnkBeginEncounterAction);
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.fireEvent(lnkBeginEncounterAction, "click");
		
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Begin an another encounter with 'chief complaint'		  //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Get the current date and time and append with chief complaint
			cal = Calendar.getInstance();
			DateFormat = new SimpleDateFormat("MM_dd_YYYY HH-mm-ss");
			date = DateFormat.format(cal.getTime());
			
			chiefCompliant2= encounterData.chief+ date;
			
			assertTrue(type(selenium,txtChiefCompliant,chiefCompliant2),"Could not Enter the chief", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to encounter tab								  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify search in encounter tab by 'chief complaint' name  //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtEncounterSearch,chiefCompliant1),"Could not Enter the chief", selenium, ClassName, MethodName);
			selenium.keyPress(txtEncounterSearch, "\\13");
			
			
			if(!getText(selenium, lblSummaryEncounetTab).contains(chiefCompliant1)){
				return false;
			}

			if(getText(selenium, lblSummaryEncounetTab).contains(chiefCompliant2)){
				return false;
			}
			
			return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return true;
		
	}
}
