package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySignButtonForSigningAuthority extends AbstractChartPreVisit{
		
	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for  verifying sognlater button in RX page ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifySigningAuthority(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_049";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifySigningAuthorityForLimited(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}	
public boolean VerifySigningAuthorityForLimited(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
		
		Selenium selenium=null;				
	try
	{		
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-2: Advanced search with Patient ID//
		//--------------------------------------------------------------------//
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId),"Could not select", selenium, ClassName, MethodName);
		//--------------------------------------------------------------------//
		//  Step-3:Delete all encounter in encounter tab//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
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
		

		//--------------------------------------------------------------------//
		//  Step-6: Create Medication//
		//--------------------------------------------------------------------//
		waitForPageLoad(selenium);
		assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
		
		//Click on Renew button
		
		//--------------------------------------------------------------------//
		//  Step-7:	Click Add New Button			
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,ChkBoxMedication),"Could not click the CheckBox", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);			
		assertTrue(click(selenium,MedicationrenewButton),"Could not click Add new button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		//--------------------------------------------------------------------//
		//  Step-7:	Click Add New Button			
		//--------------------------------------------------------------------//
		
		assertTrue(VerifySignlaterButton(selenium),"Verification failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
	}
		catch(Exception e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
				
		return true;	
}
	
public boolean VerifySignlaterButton(Selenium selenium) throws IOException
{
	
	assertTrue(isElementPresent(selenium,btnSignLater),"Sign later not present ",selenium,ClassName,MethodName);
		
		assertTrue(isElementPresent(selenium,btnSign),"Sign not present ",selenium,ClassName,MethodName);
			
	return true;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
