package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;
public class VerifyInputParametersOfMedicalReconPage extends AbstractChartPreVisit {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying select all check box")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void VerifySelectAllChkOfMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_007";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyParameters(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Non compliant")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void VerifyNonCompliantChkBoxOfMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_008";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyParameters(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	
	
	
	/**
	 * function to verify Input parameters of Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Mar 13, 2014
	 */
	public boolean VerifyParameters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException
	{
		  Selenium selenium=null;
			boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
            assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
            //--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			  assertTrue(searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId),"Could not select", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
      		assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
		//	assertTrue(deleteAllEncounters(selenium,medicationData),"Could not delete all encounter", selenium, ClassName, MethodName);
			
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
			waitForPageLoad(selenium);
			assertTrue(selenium.isVisible(lnkEncounterMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			
			selenium.clickAt(lnkEncounterMedication,"");
			//selenium.focus(lnkEncounterMedication);
			//selenium.fireEvent(lnkEncounterMedication,"keypress");			
			waitForPageLoad(selenium);				
			assertTrue(!selenium.isTextPresent("Selected items will be shown in the summary"),"shown in summary should not presend", selenium, ClassName, MethodName);		
			waitForPageLoad(selenium);
			assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation Encounter Medication failed failed", selenium, ClassName, MethodName);
 			waitForPageLoad(selenium);		
			assertTrue(selenium.isTextPresent("Added"),"Added in blue color not present", selenium, ClassName, MethodName);		
 			waitForPageLoad(selenium);		
			//--------------------------------------------------------------------//
			//  Step-6:Verify Select All Check Box 										  //
			//--------------------------------------------------------------------//
			if(medicationData.testCaseId.equals("TC_PSM_007"))
			{
			assertTrue(VerifySelectAllCheckbox(selenium),"Could not navigate to begin encounter", selenium, ClassName, MethodName);
			}
			//--------------------------------------------------------------------//
			//  Step-7:Verify Non complinat Check Box 										  //
			//--------------------------------------------------------------------//
			
			if(medicationData.testCaseId.equals("TC_PSM_008"))
			{
			assertTrue(VerifyNonCompliantCheckbox(selenium),"Could not navigate to begin encounter", selenium, ClassName, MethodName);
			
			}
		}
		
		catch(Exception e)
		{
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	
		return true;
	}	
	
	public boolean VerifySelectAllCheckbox(Selenium selenium) throws Exception{
	
	
		assertTrue(!isChecked(selenium,ChkselectAll),"Initally Select all should be un checked", selenium, ClassName, MethodName);
			
		
		assertTrue(click(selenium,ChkselectAll),"Could not click the link", selenium, ClassName, MethodName);
		
		assertTrue(isChecked(selenium,ChkBoxMedication)," After click Select all  medicatio check box should be checked", selenium, ClassName, MethodName);
			
		
		return true;
	}
public boolean VerifyNonCompliantCheckbox(Selenium selenium) throws Exception{
		
		assertTrue(click(selenium,ChkNoncompliant),"Could not click the link", selenium, ClassName, MethodName);		
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent("NON-COMPLIANT"),"After check NON-compliant check box,Medication label should show NONCOMPLIANT in Red color", selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnDone),"Could not click Continue button", selenium, ClassName, MethodName);		
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent("NON-COMPLIANT"),"Non compliant Warning not present", selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkEncounterMedication),"Could not click the link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,ChkNoncompliant),"Could not click the link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnDone),"Could not click Continue button", selenium, ClassName, MethodName);		
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(!selenium.isTextPresent("NON-COMPLIANT"),"Could not click the link", selenium, ClassName, MethodName);
			
		
	
		return true;
	}
	
	
}
