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

public class VerifyDeleteExternalMedication extends AbstractChartPreVisit {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Delete  button For External Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void DeleteEncounterMedicationReconcillation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_047";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyDelete(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}



	/**
	 * function to verify DeleteExternalEncounter Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Mar 14, 2014
	 */
	public boolean VerifyDelete(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
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
		
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId),"Could not select the patient ", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(deleteAllPendingMedication(selenium,medicationData),"Deletion failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		//--------------------------------------------------------------------//
		//  Step-3: Delete Medication //
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-4: Create Medication//
		//--------------------------------------------------------------------//
		assertTrue(createMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnSaveMedication),"Could not click the Save button", selenium, ClassName, MethodName);
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
		//--------------------------------------------------------------------//
		//  Step-6: Delete External Medication   							  //
		//--------------------------------------------------------------------//
		assertTrue(isElementPresent(selenium,btnDelete),"Delete Button not present for External Medication", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnDelete),"Could not click the delete", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtdeleteReason,"reason"),"Could not click the delete", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnDeleteReason),"Could not click Delete button;More Details:",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
			
	}
	catch(Exception e){
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
	}
}
