package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNoKnownDrugAllergies extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNoKnownDrugAllergies(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_016";
		allergyData.fetchChartPreVisitTestData();
		verifyNoKnownAllergies(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}	
	/*************************************************************************************************** 
	* @purpose        To verify the text No known drug allergies in summary
	* @DefectId		  #1545
	* @action 		  Check on the No known drug allergy check box and click save without entering any data
	* @expected       No known drug allergies text should be displayed in the summary 
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Completed
	* @useraccount    Both
	* @since  	      March 28, 2013
	***************************************************************************************************/
	
	public boolean verifyNoKnownAllergies(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
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
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,allergyData),"Could not delete the record", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//

			assertTrue(goToBeginEncounter(selenium),"could not click the encounter button", selenium, ClassName, MethodName);
			
			selenium.clickAt(action,"");
			selenium.focus(action);	
			selenium.fireEvent(action,"keypress");	
			waitForPageLoad(selenium);

			assertTrue(click(selenium, lblEncounterSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3: Delete Allergy//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Add Allergy//
			//--------------------------------------------------------------------//
			if(!isChecked(selenium,noKnownDrugAllergies))
			{
			assertTrue(click(selenium,noKnownDrugAllergies),"Could not check No sifnificant problem list check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnSave),"Could not check No sifnificant problem list check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(!getText(selenium,txtOnset).contains(allergyData.noKnownDrugAllergy),"", selenium, ClassName, MethodName);
			
			if(getText(selenium,txtOnset).contains(allergyData.noKnownDrugAllergy)){
				returnValue=true;
			}else
				fail("No known drug allergies not appearing in summary");
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
