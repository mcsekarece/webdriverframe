package com.nexia.selenium.testscripts.section.chartprevisit.TimeLine;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTimeLineTitles extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Time Line Titles")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTimeLineTitles(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchChartPreVisitTestData();
		
		verifyTimeLineTitles(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Time Line Titles
	* @action 		  verify Time Line Titles
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 22, 2013
	***************************************************************************************************/
	
	public boolean verifyTimeLineTitles(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ",selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Create New Patient										  //
			//--------------------------------------------------------------------//
			assertTrue(goToRegisterPatient(selenium), "Could not go to register patient", selenium, ClassName, MethodName);
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_002";
			patientData.fetchHomeTestData();
			
			if(isElementPresent(selenium,lnkContinue)){
				selenium.click(lnkContinue);
			}
			createNewPatientWithMandatory(selenium,patientData);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkPatientOption),"Could not click the link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkViewChart),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: verify Time Line Titles	Without any encounter			  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTimeLine),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!getText(selenium,lnkTimeLine).trim().equalsIgnoreCase("Timeline")){
				return false;
			}
			
			if(isElementPresent(selenium,"headerPanel")){
				return false;
			}
			
//			if(getText(selenium,"//div[1]/div/div[@class='reallyLighter inline']@style").trim().contains("display: none")){
//				return false;
//			}
//			
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter										  //
			//--------------------------------------------------------------------//
			try{
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}catch(Exception e){
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}if(isElementPresent(selenium,lblEncounterChoosePanel))
				if(isElementPresent(selenium,"beginNewEncounter"))
					click(selenium,"beginNewEncounter");
			
			selectValueFromAjaxList(selenium,"providerSuggestBoxIdsuggestBox",encounterData.provider);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: verify Time Line Titles	after the encounter			  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTimeLine),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!getText(selenium,lnkTimeLine).trim().equalsIgnoreCase("Timeline")){
				return false;
			}
			
			if(!getText(selenium,lblEventLastVisit).trim().equalsIgnoreCase("Events since last visit")){
				return false;
			}
			
			if(!getText(selenium,lblEventPreviousVisit).trim().equalsIgnoreCase("Previous Events")){
				return false;
			}
			
				
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
