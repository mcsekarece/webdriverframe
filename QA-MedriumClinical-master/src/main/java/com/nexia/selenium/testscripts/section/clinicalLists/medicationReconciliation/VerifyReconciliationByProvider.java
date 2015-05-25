package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyReconciliationByProvider extends AbstractChartPreVisit{
		@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Medical Reconciliatin Approval By provider")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void ReconciliationByProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ChartPreVisitLib medicationData = new ChartPreVisitLib();
			medicationData.workSheetName = "CreateMedication";
			medicationData.testCaseId = "TC_PSM_045";
			medicationData.fetchChartPreVisitTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			MedicalReconciliation(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
		}
	
	
		/**
		 * verifyMedicationReconciliation approval by provider
		 * function to verify Renew Button For Medication
		 * @param 		seleniumHost
		 * @param 		seleniumPort
		 * @param 		browser
		 * @param 		webSite
		 * @throws IOException 
		 * @since  	   May 20,2014
		 */
	
		public boolean MedicalReconciliation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
			
			Selenium selenium=null;
			boolean returnValue=true;
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
				waitForPageLoad(selenium);
				searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
				waitForPageLoad(selenium);
				assertTrue(deleteAllPendingMedication(selenium,medicationData),"Deletion failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
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
				//  Step-5: Switch role to limited access //
				//--------------------------------------------------------------------//					
			/*	assertTrue(switchRole(selenium,medicationData.switchRoleNurse),"Siwtch role failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);*/
				//--------------------------------------------------------------------//
				//  Step-6: Begin Encounter 										  //
				//--------------------------------------------------------------------//
				
				assertTrue(goToBeginEncounter(selenium),"Could not navigate to begin encounter", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selenium.isVisible(lnkEncounterMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);		
				
				selenium.clickAt(lnkEncounterMedication,"");
				//selenium.focus(lnkEncounterMedication);
				//selenium.fireEvent(lnkEncounterMedication,"keypress");			
				//--------------------------------------------------------------------//
				//  Step-7: Create Medication//
				//--------------------------------------------------------------------//
			
				assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);  	
				waitForPageLoad(selenium);  
				
				//--------------------------------------------------------------------//
				//  Step-8:perform medication reconciliation by Limited Access provider//
				//--------------------------------------------------------------------//				
				assertTrue(click(selenium,ChkBoxMedication),"Could not click the CheckBox", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				assertTrue(click(selenium,MedicationrenewButton),"Could not click the Renew button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				assertTrue(selenium.isElementPresent(btnSign),"Sign button should not present for limited access user", selenium, ClassName, MethodName);	
				assertTrue(click(selenium,btnSignLater),"Could not click the sign later button button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				waitForPageLoad(selenium);	
				waitForPageLoad(selenium);	
				assertTrue(selenium.isTextPresent("Pending renewal"),"Medication not added to pending medication",selenium,ClassName,MethodName);				
				assertTrue(selenium.isElementPresent(btnDone),"Done button should present in Encounter->Medication Reconcilation Page", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnDone),"Could not click the Done buttonn", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				waitForPageLoad(selenium);		
				//--------------------------------------------------------------------//
				//  Step-9: Switch role to Full Access access(Provider) //
				//--------------------------------------------------------------------//					
			/*	assertTrue(switchRole(selenium,"Administrator"),"Siwtch role failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);			
				searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-10: Goto Encounter Created by Nurse //
				//--------------------------------------------------------------------//				
		
				assertTrue(click(selenium,lnkencounterTab),"could not click Encounter tab", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				int   count=(Integer)selenium.getXpathCount(inkUnSignedEnCounterAction);
		  
				assertTrue(click(selenium, inkUnSignedEnCounterAction+"["+count+"]"),"could not click pending encounter label", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnEdit),"could not click Edit button in encounter note", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	*/
				//--------------------------------------------------------------------//
				//  Step-11: Goto Encounter Medication //
				//--------------------------------------------------------------------//						
				assertTrue(selenium.isVisible(lnkEncounterMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);						
				selenium.clickAt(lnkEncounterMedication,"");	
				waitForPageLoad(selenium);		
				
				//--------------------------------------------------------------------//
				//  Step-11: Approval By provider  //
				//--------------------------------------------------------------------//					
				assertTrue(click(selenium,btnDone),"Could not click the Done buttonn", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnSign),"Could not click the Done buttonn", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			
				
			}
	catch(Exception e)
	{
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
			return true;
			
		}
	
}
