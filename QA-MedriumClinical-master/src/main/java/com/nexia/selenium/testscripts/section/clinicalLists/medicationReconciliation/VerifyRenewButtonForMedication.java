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

public class VerifyRenewButtonForMedication extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Renew Button For Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void renewButtonForMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_007";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyRenewButton(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	
	
	/**
	 * verifyRenewButtonForMedication
	 * function to verify Renew Button For Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 23, 2012
	 */
	
	public boolean verifyRenewButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
		
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
			assertTrue(click(selenium, lnkQuickLink), "Could not click Quick Action Button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not click Quick Action Button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib PatientData = new ChartPreVisitLib();	
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NP_001";
			String date=null;	
			PatientData.fetchChartPreVisitTestData();		
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MMMMddHH:mm:ss");
			date = DateFormat.format(cal.getTime());
			PatientData.lastName=PatientData.lastName+date;
			assertTrue( createNewPatientWithMandatory(selenium,PatientData),"Could not create a patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,PatientData.lastName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			/*assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllEncounters(selenium,medicationData),"Could not delete all encounter", selenium, ClassName, MethodName);*/
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Medication //
			//--------------------------------------------------------------------//			
			// Check if the Medication Link is Visible
		
			/*assertTrue(selenium.isVisible(lnkMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		   assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-5: Begin Encounter 										  //
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isVisible(lnkEncounterMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			
			selenium.clickAt(lnkEncounterMedication,"");
			
			waitForPageLoad(selenium);		
			

			//--------------------------------------------------------------------//
			//  Step-6: Create Medication//
			//--------------------------------------------------------------------//
			assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//Click on Renew button
			
			//--------------------------------------------------------------------//
			//  Step-7:	Click Add New Button			
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,ChkBoxMedication),"Could not click the CheckBox", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			assertTrue(click(selenium,MedicationrenewButton),"Could not click Add new button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	//use this for vrifyinh tha edit with sign
			assertTrue(click(selenium,btnEditBlue),"Could not click Edit Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,"Dup"),"Could not type reason;More Details:",selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			ChartPreVisitLib medicationData1 = new ChartPreVisitLib();
			medicationData1.workSheetName = "PrescribeMedi";
			medicationData1.testCaseId = "TC_PM_009";
			medicationData1.fetchChartPreVisitTestData();	
		//	selectValueFromAjaxList(selenium,"locationListSuggestBoxsuggestBox" ,medicationData1.location);
			assertTrue(addPrescribeMedication(selenium,medicationData1,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnUpdatepres),"Could not click the Update Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	   
			assertTrue(!isElementPresent(selenium,btnUpdatepres),"Renew Medication Not done Properly", selenium, ClassName, MethodName);
				
			
			assertTrue((isElementPresent(selenium,btnDeleteBlue)) && (isElementPresent(selenium,btnApproveBlue)),"Renew Medication Not done Properly", selenium, ClassName, MethodName);
								
			assertTrue(click(selenium,lnkApprove),"Could not click the Approve All button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(click(selenium,"sign"),"Could not click the Approve All button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(type(selenium,"//input[@type='password']",medicationData.userPassword),"Could not type reason;More Details:",selenium,ClassName,MethodName);
			assertTrue(click(selenium,"//span/button"),"Could not click the Approve All button", selenium, ClassName, MethodName);
			
		
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
