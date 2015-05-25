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


public class VerifyStopFunctionOfMedication extends AbstractChartPreVisit {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Renew Button For Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void VerifyStopFunctionOfMedications(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_023";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyStop(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Renew Button For Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyStopFunctionOfMedicationWithTwoMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_019";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyStop(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	/**
	 * function to verify Release and Hold Button For Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Mar 12, 2014
	 */
	
	
	
	
	
	public boolean VerifyStop(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
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
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
      		assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,medicationData),"Could not delete all encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(deleteAllPendingMedication(selenium,medicationData),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
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
			assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			

			//--------------------------------------------------------------------//
			//  Step-7:	Verify Stop		  //
			//--------------------------------------------------------------------//
		
			if(medicationData.testCaseId.equals("TC_PSM_023"))
			{
				assertTrue(click(selenium,ChkBoxMedication),"Could not click the CheckBox", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);					
				assertTrue(click(selenium,MedicationStopButton),"Could not click stop button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);				
			medicationData.stopreason="Change in medication/dose";
			waitForPageLoad(selenium);	
			assertTrue(selectValueFromAjaxList(selenium, ajxReleasereasonSuggest,medicationData.stopreason),"Could not Select stop reason", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnContinue),"Could not click save Reason", selenium, ClassName, MethodName);		
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,"no"),"Could not click yes button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,AddMedi),"After Stop press System should return to Medication Reconcillation page ", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnDone),"Could not click Continue button", selenium, ClassName, MethodName);		
			waitForPageLoad(selenium);
			assertTrue(VerifyTimeStamp(selenium),"Verification failed", selenium, ClassName, MethodName);
		
		}					
			
			if(medicationData.testCaseId.equals("TC_PSM_019"))
			{
				
				medicationData.workSheetName = "CreateMedication";
				medicationData.testCaseId = "TC_PSM_015";
				medicationData.fetchChartPreVisitTestData();
				assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);			waitForPageLoad(selenium);	
				assertTrue(click(selenium,ChkselectAll),"Could not click select all button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,MedicationStopButton),"Could not click stop button,Error in clicking Stop button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				medicationData.stopreason="Change in medication/dose";
				assertTrue(selectValueFromAjaxList(selenium, ajxReleasereasonSuggest,medicationData.stopreason),"Could not select", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnContinue),"Could not click Continue button", selenium, ClassName, MethodName);		
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnDone),"Could not click Continue button", selenium, ClassName, MethodName);		
				waitForPageLoad(selenium);	
				assertTrue(VerifyTimeStamp(selenium),"Verification failed", selenium, ClassName, MethodName);
				}		
		}
			
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		

	
		
		return true;
	
	}   
	
	public boolean VerifyTimeStamp(Selenium selenium) throws IOException
	{  
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat11=new SimpleDateFormat("MMMMMMM dd, yyyy");
	  	String date1 = DateFormat11.format(cal.getTime());
	  	System.out.println("Stopped on "+date1+" due to Change in medication/doseChange");
	  	System.out.println();
	  	System.out.println(getText(selenium,lblStopedMedi));
		assertTrue(getText(selenium,lblStopedMedi).trim().contains(date1),"Verification failed", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblStopedMedi).trim().contains("Stopped on "+date1+" due to Change in medication/dose"),"Verification failed", selenium, ClassName, MethodName);
		if(isElementPresent(selenium,lblStopedMedi1))
		{
	assertTrue(getText(selenium,lblStopedMedi1).trim().contains("Stopped on "+date1+" due to Change in medication/dose"),"Verification failed", selenium, ClassName, MethodName);
	   
		}
		
		return true;
	}
	
	
	
}
