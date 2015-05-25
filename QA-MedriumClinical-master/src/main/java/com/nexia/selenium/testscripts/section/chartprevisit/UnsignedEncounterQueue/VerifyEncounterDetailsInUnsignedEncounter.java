package com.nexia.selenium.testscripts.section.chartprevisit.UnsignedEncounterQueue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEncounterDetailsInUnsignedEncounter extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Encounter Details In Unsigned Encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void createAllergyWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySignedEncounter(seleniumHost, seleniumPort, browser, webSite, encounterData, userAccount);
	}
	/**
	 * Test for Verifying Encounter Details In Unsigned Encounter
	 * DefectId     #3536 and #3539
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Mar 27, 2013
	 */
	
	public boolean verifySignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, ChartPreVisitLib encounterData, String userAccount) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//		
		    assertTrue(click(selenium,lnkQuickAction),"Could not click on quick action",selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyyHH:MM:SS");
			String date = DateFormat.format(cal.getTime());
			ChartPreVisitLib patientData = new ChartPreVisitLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NP_001";
			patientData.fetchChartPreVisitTestData();
			patientData.lastName=patientData.lastName+date;
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ patientData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"//a[@id='patientOptionsChartView']/span"),"Could not Click on patient Options"+ patientData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Assessment//
			//--------------------------------------------------------------------//
			assertTrue(assesmentSectionForSignedEncounter(selenium,encounterData),"could not Enter the data",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			encounterData.workSheetName = "CreateProblemList";
			encounterData.testCaseId = "TC_CPL_013";
			encounterData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Problem list//
			//--------------------------------------------------------------------//	
			waitForPageLoad(selenium);		
			selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);
			waitForPageLoad(selenium);	
			assertTrue(createProblemList(selenium,encounterData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Save the encounter//
			//--------------------------------------------------------------------//
			selenium.clickAt(lnkBeginEncounterAction, "");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the EncountertAb",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Verify UnSigned encounter note with added details //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"//div[@id='EncountersPendingList']/table/tbody/tr/td/div/div"),"Could not click the un signed encounter quee",selenium,ClassName,MethodName);
			
			if(!verifyStoredValuesInEncounter(selenium,encounterData)){
				Assert.fail("details not saved properly; More Details :"+ encounterData.toString());
				returnValue=false;
			}
			
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + encounterData.toString());
		} 
		return returnValue;
		
	}
	public  boolean verifyStoredValuesForEncounter(Selenium selenium,ChartPreVisitLib encounterData) {

		if(!getText(selenium,"//div[@id='UnsignedEncounterList']/table/tbody/tr/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.medicalCondition.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}

	public  boolean verifyStoredValuesInEncounter(Selenium selenium,ChartPreVisitLib encounterData) throws IOException {
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(encounterData.medicalCondition1),"Could not finf the added problem name in Saved encounter details",selenium,ClassName,MethodName);
		
		return true;
	}
	
}

