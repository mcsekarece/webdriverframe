package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditEncounter extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing the saved encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void verifyEditEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_003";
		encounterData.fetchChartPreVisitTestData();
		editEncounter(seleniumHost, seleniumPort, browser, webSite,userAccount, encounterData);
	}
	/*************************************************************************************************** 
	* @purpose        To edit a saved encounter
	* @DefectId	  	  #2146
	* @action 		  save an encounter with an assessment and edit the saved encounter
	* @expected       edited encounter should should be saved 
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Completed
	* @useraccount    Both
	* @since  	      March 22, 2013
	***************************************************************************************************/
	public boolean editEncounter(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2: Create a new patient and get Patient Id					  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);			
				ChartPreVisitLib vitalsData = new ChartPreVisitLib();
				vitalsData.workSheetName = "NewPatientCheckIn";
				vitalsData.testCaseId = "TC_NP_001";
				vitalsData.fetchChartPreVisitTestData();
				assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				String patId = getText(selenium, "patientID");
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				searchPatientNexiaForProviderHomePage(selenium,patId);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-3: Begin an encounter//
				//--------------------------------------------------------------------//
				assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);

				if(selenium.isConfirmationPresent()){
					System.out.println(selenium.getConfirmation());
					//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
					selenium.chooseOkOnNextConfirmation();
					}
				
				//--------------------------------------------------------------------//
				//  Step-4: Create Assessment//
				//--------------------------------------------------------------------//
				encounterData.workSheetName = "CreateProblemList";
				encounterData.testCaseId = "TC_CPL_013";
				encounterData.fetchChartPreVisitTestData();
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition1);
				waitForPageLoad(selenium);
				assertTrue(createProblemList(selenium,encounterData,userAccount),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.clickAt(lnkBeginEncounterAction, "");
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-5: Save the encounter//
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lstActionSaveEncounter),"Could not click the save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-6: Edit the encounter//
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lblPendingEncounter),"Could not click the Pending encounter tab", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.isAlertPresent();
				selenium.chooseOkOnNextConfirmation();
				//assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click ‘OK’ to continue, or ‘Cancel’ to stay on this page.","Navigation confirmation Message is not displayed");
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-7: Edit the assessment										//
				//--------------------------------------------------------------------//
				assertTrue(isElementPresent(selenium,lblEncounterDetails),"Could not find the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.clickAt(lblEncounterDetails,"");
				assertTrue(click(selenium,btnAssessmentedit),"Could not click the save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(editProblemList(selenium,encounterData,userAccount),"Editing failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.focus(lnkBeginEncounterAction);
				selenium.clickAt(lnkBeginEncounterAction, "");
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-5: Save the encounter//
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lstActionSaveEncounter),"Could not click the save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!isElementPresent(selenium,lstActionSaveEncounter),"Could not save the edited encounter", selenium, ClassName, MethodName);

				
		  	}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		  	}
		return returnValue;
		}
	}
