package com.nexia.selenium.testscripts.section.chartprevisit.MedicalAndSurgicalHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteProcedure extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteProcedureWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProcedure";
		proData.testCaseId = "TC_CP_018";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	
	/**
	 * deleteProcedure
	 * function to delete Procedure
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Sep 27, 2012
	 */
	
	public boolean deleteProcedure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
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
			
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
	
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"Could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete existing Procedure//
			//--------------------------------------------------------------------//
			assertTrue(deleteProcedure(selenium,proData),"Could not delete the procedure",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProcedure(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkProcedure),"Could not click the Procedure link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lblProDetails),"Not Present",selenium, ClassName, MethodName);

		/*	if(!isElementPresent(selenium,lblProDetails)){
				returnValue=false;
			}
			*/
			//--------------------------------------------------------------------//
			//  Step-6: Delete Created Procedure//
			//--------------------------------------------------------------------//
			assertTrue(deleteProcedure(selenium,proData),"Could not delete the procedure",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnCancelProcedures), "Could not click on save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			/*assertTrue(click(selenium,lnkSummary), "Could not click on summary link");
			waitForPageLoad(selenium);*/
			
			assertTrue(selenium.isTextPresent("No medical and surgical history added "),"Procedure deletion failed",selenium, ClassName, MethodName);

		/*	if(!selenium.isTextPresent("No medical and surgical history added ")){
				Assert.fail("Procedure deletion failed");
				returnValue = false;
			}else
				returnValue = true;*/
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}