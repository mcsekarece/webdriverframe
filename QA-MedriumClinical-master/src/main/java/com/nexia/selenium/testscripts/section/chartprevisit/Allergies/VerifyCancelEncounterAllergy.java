package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelEncounterAllergy extends AbstractChartPreVisit {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for cancel function for Allergy in Encounter page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelEncounterAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CAE_005";
		allergyData.fetchChartPreVisitTestData();
		verifyCancelAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	/**
	 * verifyCancelAllergy
	 * function to verify cancel function for Allergy in Encounter page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	  * @since  	Oct 23, 2012
	 */

	public boolean verifyCancelAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID                           //
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,allergyData),"Cpould not delete the enocunter record", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//

			assertTrue(goToBeginEncounter(selenium),"Could not navigate the begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Allergy and Delete Allergy in Summary//
			//--------------------------------------------------------------------//

			try{
				selenium.fireEvent(lnkAllergy, "click");
			}catch(Exception e){
				selenium.fireEvent(lnkAllergy, "click");
			}
			
			
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter //
			//--------------------------------------------------------------------//
						
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete existing Allergy in Encounter                      //
			//--------------------------------------------------------------------//
				//selenium.fireEvent(lnkAllergy, "click");
				
				selenium.clickAt(lnkEncounterAllergy,"");
				selenium.focus(lnkEncounterAllergy);
				selenium.fireEvent(lnkEncounterAllergy,"keypress");
				
		   //assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Add Allergy                                               //
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEncouterCancle),"Could not click the cancel button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(selenium.isElementPresent(btnSignOutConfirmation))
			{
				assertTrue(click(selenium,btnSignOutConfirmation),"Could not click yes button"+allergyData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: verify Stored Value in Allergy 					  //
			//--------------------------------------------------------------------//
			try{
				selenium.fireEvent(lnkAllergy, "click");
			}catch(Exception e){
				selenium.fireEvent(lnkAllergy, "click");
			}
			
			waitForPageLoad(selenium);
			
			assertTrue(!isElementPresent(selenium,lnkAllergyEdit),"Cancel functionality failed", selenium, ClassName, MethodName);

		/*	if(isElementPresent(selenium,"//a[contains(text(),'Edit')]")){
				fail("Cancel functionality failed");
				returnValue = false;
			}else
				returnValue=true;  */
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
