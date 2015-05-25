package com.nexia.selenium.testscripts.section.chartprevisit.MedicalAndSurgicalHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteProcedureInEncounterFromSummary extends AbstractChartPreVisit{
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteEncounterProcedureWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProcedure";
		proData.testCaseId = "TC_CP_027";
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
	 * @since  	    Oct 26, 2012
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
			//  Step-3: delete  Procedure//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProcedure(selenium,proData),"Could not delete the procedure",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCancel),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: delete encounter from encounter tab //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion failed",selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-6: delete  Encounter Procedure//
			//--------------------------------------------------------------------//
			
			
			assertTrue(isElementPresent(selenium,lnkProcedure),"Could not find the link",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			selenium.clickAt(lnkProcedure,"");
			//selenium.focus(lnkProcedure);
			//selenium.fireEvent(lnkProcedure,"keypress");
			
			//waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Add Encounter Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProcedure(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+proData.toString());
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+proData.toString());
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+proData.toString());
			waitForPageLoad(selenium);*/
			

			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Procedure //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"could not click on error close",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSummary),"Could not click the summary link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"could not click on error close",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"could not click on error close",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-9: Delete Procedure//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteProcedure(selenium,proData),"Could not delete the procedure",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSaveProcedure),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-10: Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
			
			//assertTrue(isElementPresent(selenium,"xpath=(//button[@type='button'])[7]"),"Could not fine the button;More Details:"+proData.toString());
			assertTrue(click(selenium,BeginEncounter),"Could not click the button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!isElementPresent(selenium,lblEncouterSumDetails),"Encounter sum details present",selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
