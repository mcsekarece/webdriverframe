package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateCorresponReport extends AbstractChartPreVisit{

	@Test(groups = {"AdvancedSmoke","SingleThread", "Approved","Regression","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Corres report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void CreateCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateCorresReport";
		medicationData.testCaseId = "TC_CCR_001";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreateReport(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	

	/**
	 * function to verify Create Corres Report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    June 23, 2014
	 */
	
	public boolean CreateReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException
	{
		try
		{  
			Selenium selenium=null;
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
            assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
            //--------------------------------------------------------------------//
			//  Step-2: Create correspondence Report									 //
			//--------------------------------------------------------------------//
            assertTrue(navigateToCorresReport(selenium,medicationData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
		
			assertTrue(CreateCorrespondenceReport(selenium,medicationData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
        	waitForPageLoad(selenium);
        	searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
			waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblFirstCorresReport),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
          	waitForPageLoad(selenium);
        	assertTrue(click(selenium, lnkEncounterAction),"Could not click Action  button btn", selenium, ClassName,MethodName);
        	waitForPageLoad(selenium);
        	assertTrue(click(selenium, "//a[@id='Medication Reconciliation']/"),"Could not click Action  button btn", selenium, ClassName,MethodName);
        	waitForPageLoad(selenium);
              	 //--------------------------------------------------------------------//
			//  Step-3: Verify Medication Reconciliation Page									 //
			//--------------------------------------------------------------------//
        	 assertTrue(VerifyMedicationPage(selenium),"Verification failed ", selenium, ClassName,MethodName);  
        	 waitForPageLoad(selenium);
        	 //--------------------------------------------------------------------//
 			//  Step-4:Verify Correspondence Page After Medication Reconciliation Done //
 			//--------------------------------------------------------------------//
        	assertTrue(click(selenium, "done"),"Could not click done button", selenium, ClassName,MethodName);
         	waitForPageLoad(selenium);
         	
        	assertTrue(isElementPresent(selenium,lnkEncounterAction),"Not found", selenium, ClassName,MethodName);

         			}
		catch(Exception e)
				{
		Assert.fail(e.getMessage());
				
				
				}		return true;
				
				
	}
	
	
	public boolean VerifyMedicationPage(Selenium selenium) throws IOException
	{
    	assertTrue(isElementPresent(selenium,MedicationrenewButton),"Not found", selenium, ClassName,MethodName);
    	assertTrue(isElementPresent(selenium,MedicationStopButton),"Not found", selenium, ClassName,MethodName);
    	assertTrue(isElementPresent(selenium,lnkEncounterAction),"Not found", selenium, ClassName,MethodName);

		return true;
	}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

