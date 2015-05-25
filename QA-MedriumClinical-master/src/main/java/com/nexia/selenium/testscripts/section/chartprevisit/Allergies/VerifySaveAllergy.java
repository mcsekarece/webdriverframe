package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySaveAllergy extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for cancel function for Allergy in summary page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createAllergyWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_036";
		allergyData.fetchChartPreVisitTestData();
		verifySaveAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify save functionality in allergy
	* @DefectId	  	  #3117
	* @Specification  SRS_EMR_Med_Summary_Allergies_Rev0.0
	* @action 		  create allergies and save
	* @expected       created allergies be should successfully saved 
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Completed
	* @useraccount    Both
	* @since  	      March 18, 2013
	***************************************************************************************************/

	public boolean verifySaveAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID                           //
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,allergyData),"Could not delete the encounter record", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//

			assertTrue(goToBeginEncounter(selenium),"could not navigate the encounter button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
		
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Add Allergies                                            //
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_007";
			allergyData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			/*allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_008";
			allergyData.fetchChartPreVisitTestData();
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed");
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-6: Verify Cancel button//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,"//div[@id='AllergyList']/table/tbody/tr/td/div/input"),"Could not find the check box more Details;"+allergyData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkAllergy),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,"//div[@id='AllergyList']/table/tbody/tr/td/div/input"),"Could not find the check box more Details;"+allergyData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,"//div[@id='AllergyList']/table/tbody/tr/td/div/input"),"Could not click the check box; More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(isElementPresent(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,btnCancel),"Could not find the cancel button", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,"xpath=(//input[@type='checkbox'])[2]"),"Could not find the link", selenium, ClassName, MethodName);
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
