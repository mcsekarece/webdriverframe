package com.nexia.selenium.testscripts.section.smoketest;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyEncounterList extends AbstractSmokeTest {
	
	@Test(groups = {"Developing","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for adding various charprevisit info to Encounters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterListAll(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_007";
		allergyData.fetchChartPreVisitTestData();
		goEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	
	/**
	 * goEncounter
	 * function to add various charprevisit info to Encounters
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	  * @since  	Jan 17, 2013
	 */
	
	public boolean goEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID and delete any pending medication and Encounter data//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage_smoke(selenium,allergyData.patientId);
			waitForPageLoad(selenium);		
			
			deleteAllPendingMedication_smoke(selenium);	
			waitForPageLoad(selenium);
			deleteAllEncounter(selenium, allergyData);
						
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//
						
			assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);											
			
			//--------------------------------------------------------------------//
			//  Step-4: Add Allergy                                               //
			//--------------------------------------------------------------------//
			
			assertTrue(isElementPresent(selenium,lnkAllergy),"Could not find the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			selenium.clickAt(lnkAllergy,"");
			waitForPageLoad(selenium);						
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-4a: Verify Added Allergy                                     //
			//--------------------------------------------------------------------//
			
			assertTrue(verifyAllergy(selenium,allergyData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			
				
			//--------------------------------------------------------------------//
			//  Step-5: Add Family History                                        //
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib historyData = new ChartPreVisitLib();
			historyData.workSheetName = "CreateFamilyHistory";
			historyData.testCaseId = "TC_CFM_009";
			historyData.fetchChartPreVisitTestData();			
			
			
			assertTrue(isElementPresent(selenium,lnkFamilyHistory),"Could not find the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the Family History link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);								
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//verify the added Family History		
			assertTrue(selenium.isTextPresent(historyData.medical),"not present",selenium,ClassName,MethodName);			
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Immunization                                        //
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib immunizationData = new ChartPreVisitLib();
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_010";
			immunizationData.fetchChartPreVisitTestData();
			
			assertTrue(isElementPresent(selenium,lnkImmunization),"Could not find the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//verify the added Immunization						
			assertTrue(selenium.isTextPresent(immunizationData.verifyvac1),"Not present ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Add Injection                                            //
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib injectionData = new ChartPreVisitLib();
			injectionData.workSheetName = "CreateInjection";
			injectionData.testCaseId = "TC_CI_006";
			injectionData.fetchChartPreVisitTestData();			
			
			assertTrue(isElementPresent(selenium,lnkInjection),"Could not find the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkInjection),"Could not click the injection link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Verify the Added Injection
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent(injectionData.injection),"not present",selenium,ClassName,MethodName);
			
	
			//--------------------------------------------------------------------//
			//  Step-8: Add Medical and Surgical History                          //
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib medSurData = new ChartPreVisitLib();
			medSurData.workSheetName = "CreateProcedure";
			medSurData.testCaseId = "TC_CP_006";
			medSurData.fetchChartPreVisitTestData();
			
			assertTrue(isElementPresent(selenium,lnkProcedure),"Could not find the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkProcedure),"Could not click the Medical and Surgical link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);								
			assertTrue(createProcedure(selenium,medSurData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// Verify the added Medical and Surgical History
			assertTrue(selenium.isTextPresent(medSurData.proName),"not present",selenium,ClassName,MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-9: Add Medication					                          //
			//--------------------------------------------------------------------//			
		
			ChartPreVisitLib medicationData = new ChartPreVisitLib();
			medicationData.workSheetName = "CreateMedication";
			medicationData.testCaseId = "TC_PSM_013";
			medicationData.fetchChartPreVisitTestData();
			
			assertTrue(isElementPresent(selenium,lnkMedication),"Could not find the Medication link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkMedication),"Could not click the Medication link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			// Verify the Added Medication
			if(userAccount.equals(CAAccount)){
				assertTrue(selenium.isTextPresent(medicationData.prescribeNameCa),"not presenrt",selenium,ClassName,MethodName);				
			}else
				assertTrue(selenium.isTextPresent(medicationData.prescribeName),"not present",selenium,ClassName,MethodName);	
			
			//--------------------------------------------------------------------//
			//  Step-10: Add Problem List				                          //
			//--------------------------------------------------------------------//			
			
			ChartPreVisitLib proData = new ChartPreVisitLib();
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_007";
			proData.fetchChartPreVisitTestData();
			
			assertTrue(isElementPresent(selenium,lnkProblemList),"Could not find the Problem List",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkProblemList),"Could not click the Problem list;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);					
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			// Verify the Added Problem List
			assertTrue(selenium.isTextPresent(proData.medicalCondition1),"Verify added problem list failed",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-11: Add Social History				                          //
			//--------------------------------------------------------------------//			
			
			ChartPreVisitLib socialData = new ChartPreVisitLib();
			socialData.workSheetName = "CreateSocialHistory";
			socialData.testCaseId = "TC_CSH_006";
			socialData.fetchChartPreVisitTestData();
			
			assertTrue(isElementPresent(selenium,lnkSocialHistory),"Could not find the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			// Verify the Added Social History
			assertTrue(selenium.isTextPresent(socialData.type),"not present",selenium,ClassName,MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-12: Create Lab Order Page
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib orderData = new ChartPreVisitLib();
			orderData.workSheetName = "CreateLabOrder";
			orderData.testCaseId = "TC_OL_006";
			orderData.fetchChartPreVisitTestData();			
			
			assertTrue(click(selenium,imgLabOrderIcon),"Could not click on lab order link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(orderNewLabs(selenium,orderData),"Order New Labs Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-13: Create Diaganostic Imaging Lab Order Page
			//--------------------------------------------------------------------//
			ChartPreVisitLib orderDiData = new ChartPreVisitLib();
			orderDiData.workSheetName = "CreateDiganosticImaging";
			orderDiData.testCaseId = "TC_ODI_003";
			orderDiData.fetchChartPreVisitTestData();
			
			
			assertTrue(click(selenium,imgDiOrderIcon),"Could not click on lab order link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(orderNewDi(selenium,orderDiData),"Order New Diagnostic Imaging Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-14: Create Referral Order
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib orderRfData = new ChartPreVisitLib();
			orderRfData.workSheetName = "CreateReferralOrder";
			orderRfData.testCaseId = "TC_OR_003";
			orderRfData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,imgReferralIcon),"Could not click on referral order link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(orderNewReferral_smoke(selenium,orderRfData),"New Referral Order Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-15: Add Prescribe Medication		                          //
			//--------------------------------------------------------------------//			
			
			ChartPreVisitLib prescribeData = new ChartPreVisitLib();
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_015";
			prescribeData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium, btnBeginEncounter),"navigation failed",selenium,ClassName,MethodName);
								
			waitForPageLoad(selenium);		
			
			
			selenium.clickAt(imgPrescribeMedsIcon,"");
			selenium.focus(imgPrescribeMedsIcon);			
			selenium.fireEvent(imgPrescribeMedsIcon,"keypress");
			
			waitForPageLoad(selenium);		
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
									
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
												
			
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnAddToPending),"Could not click the add to pending;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// Verify the Added Prescribe Medication
			
			if(userAccount.equals(CAAccount)){
				assertTrue(selenium.isTextPresent(prescribeData.prescribeCa),"Text not present",selenium,ClassName,MethodName);
									
			}else {
				assertTrue(selenium.isTextPresent(prescribeData.prescribe),"not present ",selenium,ClassName,MethodName);
				
			}
					
			
			//--------------------------------------------------------------------//
			//  Step-16: Sign the Encounter				                          //
			//--------------------------------------------------------------------//
											
			assertTrue(click(selenium, btnBeginEncounter),"could not click",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		    
			assertTrue(isElementPresent(selenium,btnSign),"Could not find the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,btnSign),"Could not click the sign link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
						
		}					
		catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" );
		}
		return returnValue;
	}	
	
}