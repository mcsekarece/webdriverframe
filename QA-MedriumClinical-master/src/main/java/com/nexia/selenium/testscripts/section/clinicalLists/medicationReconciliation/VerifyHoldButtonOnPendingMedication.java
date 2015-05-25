package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHoldButtonOnPendingMedication extends AbstractChartPreVisit{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying hold and Release Button For Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void VerifyHoldButtonWithPending(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_007";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyHoldWithPendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying hold and Release Button For Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyStopButtonWithPending(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_045";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyHoldWithPendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	/**
	 * verifyRenewButtonForMedication
	 * function to verify Hold operation for pending medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws Exception 
	 * @since  	    Mar 14, 2014
	 */
	public boolean verifyHoldWithPendingMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws Exception{
		Selenium selenium=null;
		
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,medicationData),"Could not delete all encounter", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Medication //
			//--------------------------------------------------------------------//			
			// Check if the Medication Link is Visible
			assertTrue(selenium.isVisible(lnkMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			//--------------------------------------------------------------------//
			//  Step-5: Begin Encounter 										  //
			//--------------------------------------------------------------------//		
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isVisible(lnkEncounterMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			
			selenium.clickAt(lnkEncounterMedication,"");
			//selenium.focus(lnkEncounterMedication);
			//selenium.fireEvent(lnkEncounterMedication,"keypress");			
			waitForPageLoad(selenium);					
			   assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-6: Create Medication//
			//--------------------------------------------------------------------//
			assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			//--------------------------------------------------------------------//
			//  Step-7:Add medication to pending//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,ChkBoxMedication),"Could not click the CheckBox", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(click(selenium,MedicationrenewButton),"Could not click the Renew button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(click(selenium,btnSignLater),"Could not click the sign later button button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(selenium.isTextPresent("Pending renewal"),"Medication not added to pending medication",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			//--------------------------------------------------------------------//
			//  Step-8:Verify hold button with pending medication//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,ChkselectAll),"Could not click the CheckBox", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			if(medicationData.testCaseId.equals("TC_PSM_045"))
			{
				assertTrue(click(selenium,MedicationStopButton),"Could not click the stop", selenium, ClassName, MethodName);			
				waitForPageLoad(selenium);	
				assertTrue(isElementPresent(selenium,btnContinue),"Dialog box not appear for confirmation",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnContinue),"Could not click continue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				selectValueFromAjaxList(selenium, ajxMedShow,"Compliance issues");			
				assertTrue(click(selenium,btnContinue),"Could not click continue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,"no"),"Dialog box not appear for confirmation",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,"no"),"Could not click No", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
			}
			else
			{
				assertTrue(click(selenium,MedicationholdButton),"Could not click the link", selenium, ClassName, MethodName);			
				waitForPageLoad(selenium);	
				
				assertTrue(isElementPresent(selenium,btnContinue),"Dialog box not appear for confirmation",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnContinue),"Could not click continue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				selectValueFromAjaxList(selenium, ajxMedShow,"Admission to hospital");			
				assertTrue(click(selenium,btnContinue),"Could not click continue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(selenium.isTextPresent("Held"),"Held In blue color not present or Medication not held", selenium, ClassName, MethodName);

				/*if(!selenium.isTextPresent("Held"))
				{			
					Assert.fail("Held In blue color not present or Medication not held");
					return false;
				}	*/
			}
			
					
		}
		catch(Exception e)
		{
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}	
	return true;
	
	}	
	
}
