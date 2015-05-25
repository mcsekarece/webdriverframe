package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRunWizardDetailsInEncounterNotePage extends AbstractChartPreVisit{
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Run Wizard Details In Encounter Note Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProblemListWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_020";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}	
	/*************************************************************************************************** 
	* @purpose        verify Run Wizard Details in Encounter note
	* @action 		  Test for verifying Details in Encounter note
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 09, 2013
	***************************************************************************************************/

	public boolean addProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,"FULL"),"unable to switch the user role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion Failed",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounter//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Run wizard Summary Page//
			//--------------------------------------------------------------------//
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
			}
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium, lnkRunWizard),"could not click the Run Wizard Summary Page",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);		

			//--------------------------------------------------------------------//
			//  Step-5: click Problem List Link//
			//--------------------------------------------------------------------//
			while(!isElementPresent(selenium,txtMedicatl)){
				//FIX ME
				 if(selenium.isConfirmationPresent()){
					 System.out.println(selenium.getConfirmation());
					 //Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
					 selenium.chooseOkOnNextConfirmation();
				 }
				assertTrue(click(selenium, lnkNext),"could not click the Next button",selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);		
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium, lnkDone),"could not click the Done button",selenium, ClassName, MethodName);	
			//waitForPageLoad(selenium);		
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Added Procedure									  //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isTextPresent(proData.medicalCondition1),"The Text is not Present",selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
