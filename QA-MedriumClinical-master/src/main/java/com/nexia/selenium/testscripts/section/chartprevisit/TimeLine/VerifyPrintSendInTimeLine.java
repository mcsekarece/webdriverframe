package com.nexia.selenium.testscripts.section.chartprevisit.TimeLine;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPrintSendInTimeLine extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Print Send In TimeLine")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrintSendInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchChartPreVisitTestData();
		verifyPrintSendInTimeLine(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Print Send In TimeLine
	* @action 		  verify Print Send In TimeLine
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 28, 2013
	***************************************************************************************************/
	
	public boolean verifyPrintSendInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
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
			//  Step-5: verify The Print/ Send Option							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTimeLine),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium, lnlPrintsend)){
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
