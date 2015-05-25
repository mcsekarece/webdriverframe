package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddDrugAllergyInPrescribeMedication extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAddAllergyInPrescribeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_007";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDrugAllergyInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * addDrugAllergyInteraction
	 * function to verify add drug Allergy in prescribe medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 17, 2012
	 */
	
	public boolean addDrugAllergyInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws IOException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);	
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");	
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete All existing Allergy//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllAllergy(selenium,prescribeData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Add Allergy//
			//--------------------------------------------------------------------//
			
			assertTrue(createAllergyForMedWarnings(selenium,prescribeData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkAllergyEdit),"edit button is not present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, labPrescribeAllergen),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyStoredValues(selenium, prescribeData,userAccount), "Allergy date not stored properly", selenium, ClassName, MethodName);
			return true;
	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
	}

	/**
	 * verifyStoredValues
	 * To verify stored values in prescribe medication page
	 * @param selenium
	 * @param prescribeData
	 * @return
	 * @throws IOException 
	 * @since Dec 17, 2012 
	 */
	
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeData,String account) throws IOException{
		waitForPageLoad(selenium);
		if(account.equals(CAAccount)){
			assertTrue((getText(selenium,labPrescribeAllergen).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.allergenCa.trim().toLowerCase(new java.util.Locale("en","US")).trim())),"Verification failed", selenium, ClassName, MethodName);
		}else
		{
			assertTrue((getText(selenium,labPrescribeAllergen).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.allergen.trim().toLowerCase(new java.util.Locale("en","US")).trim())),"Verification failed", selenium, ClassName, MethodName);
		}
		assertTrue((getText(selenium,labPrescribeAllergen).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.severity.trim().toLowerCase(new java.util.Locale("en","US")).trim())),"Verification failed", selenium, ClassName, MethodName);
		return true;
	}
}
