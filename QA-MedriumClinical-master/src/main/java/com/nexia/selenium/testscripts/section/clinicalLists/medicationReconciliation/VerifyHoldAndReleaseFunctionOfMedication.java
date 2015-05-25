package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHoldAndReleaseFunctionOfMedication extends AbstractChartPreVisit {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying hold and Release Button For Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void StopAndReleaseButtonForMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_046";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyHoldAndReleaseButton(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	
	
	/**
	 * verifyRenewButtonForMedication
	 * function to verify Release and Hold Button For Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws Exception 
	 * @since  	    Mar 2, 2014
	 */
	
	public boolean verifyHoldAndReleaseButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws Exception{
		
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
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId),"Could not select  ", selenium, ClassName, MethodName);
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
			

			//--------------------------------------------------------------------//
			//  Step-6: Create Medication//
			//--------------------------------------------------------------------//
			assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			

			//--------------------------------------------------------------------//
			//  Step-7:	Verify Hold and Release Button 				  //
			//--------------------------------------------------------------------//
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat11=new SimpleDateFormat("MMM dd, yyyy");
		String date1 = DateFormat11.format(cal.getTime());
		waitForPageLoad(selenium);		
		String ReleaseAtt=selenium.getAttribute("release@disabled");
		waitForPageLoad(selenium);		
		assertTrue(ReleaseAtt.equals(""),"Release button must be hidden",selenium,ClassName,MethodName);
		String HoldAtt=selenium.getAttribute("hold@disabled");
		assertTrue(HoldAtt.equals(""),"Release button must be enabled",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium,ChkBoxMedication),"Could not click the CheckBox", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);				
		assertTrue(click(selenium,MedicationholdButton),"Could not click the link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);					
		selectValueFromAjaxList(selenium, btnholdreason,"Admission to hospital");			
		assertTrue(click(selenium,btnContinue),"Could not click Delete Reason", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);				
		waitForPageLoad(selenium);				
		HoldAtt=selenium.getAttribute("hold@disabled");			
		waitForPageLoad(selenium);		
		assertTrue(HoldAtt.equals(""),"Release button must be enabled",selenium,ClassName,MethodName);			
		assertTrue(selenium.isTextPresent("Held"),"Medication Not Holded properly",selenium,ClassName,MethodName);
		assertTrue(selenium.isTextPresent("Admission to hospital"), "Hold reason not present",selenium,ClassName,MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-7:	Verify Release button Button 				  //
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,ChkBoxMedication),"Could not click the CheckBox", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(click(selenium,MedicationReleaseButton),"Could not click the link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);					
		selectValueFromAjaxList(selenium, ajxReleasereasonSuggest,"Hold reasons no longer apply");
		waitForPageLoad(selenium);	
		assertTrue(click(selenium,btnContinue),"Could not click save Reason", selenium, ClassName, MethodName);		
		waitForPageLoad(selenium);	
		ReleaseAtt=selenium.getAttribute("release@disabled");
		waitForPageLoad(selenium);		
		assertTrue(ReleaseAtt.equals(""),"Release button must be hidden",selenium,ClassName,MethodName);		
		assertTrue(selenium.isTextPresent("Hold reasons no longer apply"),"Release reason not present",selenium,ClassName,MethodName);
	
		
		}		
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}	
		return returnValue;
	}

	
}
