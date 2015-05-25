package com.nexia.selenium.testscripts.section.smoketest;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.thoughtworks.selenium.Selenium;

public class CreateEncounterPrescribeMed extends AbstractSmokeTest {
	
	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for adding various charprevisit info to Encounters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterListAll(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_015";
		prescribeData.fetchChartPreVisitTestData();		
		goEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	
	/**
	 * goEncounter
	 * function for Prescribe Medication in Encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	Jan 17, 2013
	 */
	
	public boolean goEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID and delete any pending medication and Encounter data//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib vitalsData = new ChartPreVisitLib();
			vitalsData.workSheetName = "NewPatientCheckIn";
			vitalsData.testCaseId = "TC_NP_001";
			vitalsData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllPendingMedication_smoke(selenium),"Could not click the encounter tab", selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			//assertTrue(deleteAllEncounters(selenium,prescribeData),"could not delete the record", selenium, ClassName, MethodName);
						
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//
						
			assertTrue(goToBeginEncounter(selenium),"could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);											
						
			
			//assertTrue(click(selenium, btnBeginEncounter));
								
			//waitForPageLoad(selenium);		
	
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Prescribe Medication                                  //
			//--------------------------------------------------------------------//
		
			
			selenium.clickAt(imgPrescribeMedsIcon,"");
			selenium.focus(imgPrescribeMedsIcon);			
			selenium.fireEvent(imgPrescribeMedsIcon,"keypress");
			
			waitForPageLoad(selenium);		
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
									
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
												
			
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnAddToPending),"Could not click the add to pending;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkMedicationTab1),"Could not click the encounter tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Verify the Added Prescribe Medication                    //
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				assertTrue(selenium.isTextPresent(prescribeData.prescribeCa.toUpperCase()),"could not fine text", selenium, ClassName, MethodName);
									
			}else {
				assertTrue(selenium.isTextPresent(prescribeData.prescribe),"Could not find",selenium, ClassName, MethodName);
				
			}
					
			
			//--------------------------------------------------------------------//
			//  Step-7: Sign the Encounter				                          //
			//--------------------------------------------------------------------//
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				selenium.chooseOkOnNextConfirmation();
			}					
			assertTrue(click(selenium, btnBeginEncounter),"Couldn't click Begin encounter button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				selenium.chooseOkOnNextConfirmation();
			}
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click",selenium, ClassName, MethodName);


			assertTrue(isElementPresent(selenium,btnSign),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,btnSign),"Could not click the sign link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
		}					
		catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" );
		}
		return returnValue;
	}	
	
}