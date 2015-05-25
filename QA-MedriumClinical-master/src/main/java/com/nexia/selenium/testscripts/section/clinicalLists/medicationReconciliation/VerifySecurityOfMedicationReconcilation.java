package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOfMedicationReconcilation extends AbstractClinicalList  {
	

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Cancel For Export Chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "CreateMedReconcilationList";
		alertData.testCaseId = "TC_CML_003";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifiySecurityOptionForMedicationReconcilation(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Medication Reconcilation Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		
			
		
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "CreateMedReconcilationList";
		alertData.testCaseId = "TC_CML_001";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifiySecurityOptionForMedicationReconcilation(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
				
		}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Medication Reconcilation Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "CreateMedReconcilationList";
		alertData.testCaseId = "TC_CML_004";
		alertData.fetchClinicalListTestData();
		VerifiySecurityOptionForMedicationReconcilation(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Medication Reconcilation Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "CreateMedReconcilationList";
		alertData.testCaseId = "TC_CML_002";
		alertData.fetchClinicalListTestData();
		VerifiySecurityOptionForMedicationReconcilation(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	/**
	 * Verify Security option  Medication Reconcilation Page
	 * function to Verify Security option Medication Reconcilation Page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	     Apr 29, 2014
	 */
	
	public boolean VerifiySecurityOptionForMedicationReconcilation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib alertData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
		
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + alertData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, alertData.userName, alertData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			AbstractChartPreVisit patientobj= new AbstractChartPreVisit();
			//-------------------------------- ------------------------- ----------//
			//  Step-2:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
//			if(!alertData.testCaseId.equals("TC_CML_004")){			
//			assertTrue(switchRole(selenium,alertData.switchRole),"Could not select",selenium, ClassName, MethodName);
//	 		 waitForPageLoad(selenium);	 
//			waitForPageLoad(selenium);
//			AbstractChartPreVisit Meddata=new AbstractChartPreVisit();
//			Meddata.navigateToPatient(selenium,alertData.patientId);
//			assertTrue(click(selenium,lnkviewchart),"Could not click the viewchart",selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//			assertTrue(click(selenium,lnkSummary),"Could not click the viewchart",selenium, ClassName, MethodName);
//			 waitForPageLoad(selenium);	 
//			 if(selenium.isConfirmationPresent())
//				{
//				 selenium.chooseOkOnNextConfirmation(); 
//				}
//			}
			if(alertData.testCaseId.equals("TC_CML_004")){			
				assertTrue(switchRole(selenium,alertData.switchRole),"Could not select",selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 if(isElementPresent(selenium, btnErrorClose)) 
					 assertTrue(click(selenium, btnErrorClose),"could not click on error close", selenium, ClassName,MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,alertData.patientId),"Could search patient", selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);	 
			}
		
			//-------------------------------- ------------------------- ----------//
			//  Step-4:View Only//
			//--------------------------------------------------------------------//
			
			if(alertData.testCaseId.equals("TC_CML_002")){		
				assertTrue(switchRole(selenium,alertData.switchRole),"Could not select",selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 searchPatientNexiaForProviderHomePage(selenium,alertData.patientId);
				 waitForPageLoad(selenium);	 	
				assertTrue( !isElementVisible(selenium,btnBeginEncounter),"Could not find the link", selenium, ClassName, MethodName);
				
			
			
			}
			//-------------------------------- ------------------------- ----------//
			//  Step-5:Limited Access Only//
			//--------------------------------------------------------------------//
			if(alertData.testCaseId.equals("TC_CML_003")){		
				assertTrue(switchRole(selenium,alertData.switchRole),"Could not select",selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 searchPatientNexiaForProviderHomePage(selenium,alertData.patientId);
				 waitForPageLoad(selenium);	 			
				goToBeginEncounter(selenium);		
				 waitForPageLoad(selenium);	 	
					assertTrue(selenium.isVisible(lnkEncounterMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);		
					assertTrue(isElementPresent(selenium,lnkMedication),"Could not find the link", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);				
					assertTrue(clickAt(selenium,lnkMedication,""),"Could not find the link", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);					
					assertTrue(!isElementVisible(selenium,MedicationStopButton),"Could not find the link", selenium, ClassName, MethodName);
					assertTrue(!isElementVisible(selenium,MedicationholdButton) ,"Could not find the link", selenium, ClassName, MethodName);
					//assertTrue(!isElementVisible(selenium,MedicationrenewButton),"Could not find the link", selenium, ClassName, MethodName);
					assertTrue(!isElementVisible(selenium,MedicationReleaseButton),"Could not find the link", selenium, ClassName, MethodName);
			}
			//-------------------------------- ------------------------- ----------//
			//  Step-6:Full Access  Access Only//
			//--------------------------------------------------------------------//
			
			if(alertData.testCaseId.equals("TC_CML_001")){		
				assertTrue(switchRole(selenium,alertData.switchRole),"Could not select",selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 searchPatientNexiaForProviderHomePage(selenium,alertData.patientId);
				assertTrue(	goToBeginEncounter(selenium),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);		
				assertTrue(isElementPresent(selenium,lnkMedication),"Could not find the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
				assertTrue(clickAt(selenium,lnkMedication,""),"Could not find the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			
				assertTrue(isElementPresent(selenium,MedicationStopButton) && isElementPresent(selenium,MedicationholdButton) &&  isElementPresent(selenium,MedicationrenewButton) &&  isElementPresent(selenium,MedicationReleaseButton),"Limited Access Checking is failed::Renew button should be visible all other button should not be visible", selenium, ClassName, MethodName);
				
		}
	}catch(Exception e){
		Assert.fail(e.getMessage());
		}
		return true;
			
	}
}
