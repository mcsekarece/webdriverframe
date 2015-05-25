package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;
import java.util.Calendar;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;
public class VerifyNochangeCheckBoxInMedication extends AbstractChartPreVisit{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying No changeCheck bos Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void VerifyNochangeCheckBox(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_046";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyNochangeCheckBox(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	
	public boolean VerifyNochangeCheckBox(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws Exception{
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
				//  Step-6: Verify no change check box//
				//--------------------------------------------------------------------//
				assertTrue(!isChecked(selenium,ChkboxNochange),"Nochange check box on top should be Unchecked by default", selenium, ClassName, MethodName);
					
				
				//--------------------------------------------------------------------//
				//  Step-6: Create Medication//
				//--------------------------------------------------------------------//
				assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				assertTrue(click(selenium,ChkboxNochange),"Could not click the no change check box buttonn", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnDone),"Could not click the Done buttonn", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				waitForPageLoad(selenium);	
				waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
				//  Step-6: Verify no change Warining //
				//--------------------------------------------------------------------//
				assertTrue(!selenium.isTextPresent("No changes done during this medication reconciliation"),"text present", selenium, ClassName, MethodName);
				
	}
	catch(Exception e)
	{
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);

	}
	
return true;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}