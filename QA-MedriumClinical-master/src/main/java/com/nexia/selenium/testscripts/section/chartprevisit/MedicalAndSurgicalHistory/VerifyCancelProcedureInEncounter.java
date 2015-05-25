package com.nexia.selenium.testscripts.section.chartprevisit.MedicalAndSurgicalHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelProcedureInEncounter extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing the Cancel Button")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProcedureWithShowDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProcedure";
		proData.testCaseId = "TC_CP_023";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCancelButton(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/**
	 * verifyCancelButton
	 * function to verify Cancel Button
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  		Oct 22, 2012
	 */
	
	public boolean verifyCancelButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
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
			//  Step-3: Delete existing Procedure//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(deleteProcedure(selenium,proData),"Could not delete the procedure",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-4: delete  Encounter Procedure//
			//--------------------------------------------------------------------//
			assertTrue(deleteEncounterProcedure(selenium,proData),"Could not delete the procedure",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(isElementPresent(selenium,lnkProcedure),"Could not find the link");
			//waitForPageLoad(selenium);
			
			selenium.clickAt(lnkProcedure,"");
			//selenium.focus(lnkProcedure);
			//selenium.fireEvent(lnkProcedure,"keypress");
			
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProcedure(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEncouterCancle),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify store Procedure in summary page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue((!getText(selenium,lblEncounterProName).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.proName.trim().toLowerCase(new java.util.Locale("en","US")))),"",selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}
