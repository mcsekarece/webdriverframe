package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateMedicalSummaryInEncounterNote extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing whether Begin Encounter button present after saving an encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createMedicalSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchChartPreVisitTestData();
		createMedicalSummaryInEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/**
	 * createMedicalSummaryInEncounter
	 * function to create Medical Summary In Encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 27, 2012
	 */
	
	
	public boolean createMedicalSummaryInEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,encounterData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib vitalsData = new ChartPreVisitLib();
			vitalsData.workSheetName = "NewPatientCheckIn";
			vitalsData.testCaseId = "TC_NP_001";
			vitalsData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnErrorClose))
			{
				click(selenium,btnErrorClose);
			}
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(deleteAllEncounters(selenium,encounterData),"Creation failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete and Create Problem List//
			//--------------------------------------------------------------------//
			ChartPreVisitLib encounterData1 = new ChartPreVisitLib();
			encounterData1.workSheetName = "CreateProblemList";
			encounterData1.testCaseId = "TC_CPL_002";
			encounterData1.fetchChartPreVisitTestData();
			
			selenium.focus(lnkProblemList);
			selenium.clickAt(lnkProblemList, "");
			//assertTrue(click(selenium,lnkProblemList),"Could not click the Problem list link;More Details");
			//waitForPageLoad(selenium);
			
			assertTrue(createProblemList(selenium,encounterData1,userAccount),"Creation failed", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete and Create Procedure//
			//--------------------------------------------------------------------//
			ChartPreVisitLib encounterData2 = new ChartPreVisitLib();
			encounterData2.workSheetName = "CreateProcedure";
			encounterData2.testCaseId = "TC_CP_002";
			encounterData2.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,lnkProcedure),"Could not click the Procedure link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createProcedure(selenium,encounterData2,userAccount),"Creation failed", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Delete and Create Medication//
			//--------------------------------------------------------------------//
			ChartPreVisitLib encounterData3 = new ChartPreVisitLib();
			encounterData3.workSheetName = "CreateMedication";
			encounterData3.testCaseId = "TC_PSM_007";
			encounterData3.fetchChartPreVisitTestData();
			
			
					
			assertTrue(click(selenium,lnkMedication),"Could not click the Procedure link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(createEncounterMedication(selenium,encounterData3,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Delete and Create Allergies//
			//--------------------------------------------------------------------//
			ChartPreVisitLib encounterData4 = new ChartPreVisitLib();
			encounterData4.workSheetName = "CreateAllergy";
			encounterData4.testCaseId = "TC_CA_002";
			encounterData4.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergies link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createAllergy(selenium,encounterData4,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Delete and Create Immunization//
			//--------------------------------------------------------------------//
			ChartPreVisitLib encounterData5 = new ChartPreVisitLib();
			encounterData5.workSheetName = "CreateImmunization";
			encounterData5.testCaseId = "TC_CIM_027";
			encounterData5.fetchChartPreVisitTestData();
			
			
			assertTrue(click(selenium,lnkImmunization),"Could not click the link;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(createImmunization(selenium,encounterData5,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*//--------------------------------------------------------------------//
			//  Step-10: Delete and Create Injection//
			//--------------------------------------------------------------------//
			ChartPreVisitLib encounterData6 = new ChartPreVisitLib();
			encounterData6.workSheetName = "CreateInjection";
			encounterData6.testCaseId = "TC_CI_004";
			encounterData6.fetchChartPreVisitTestData();
			
			
			assertTrue(click(selenium,lnkInjection),"Could not click the link;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ encounterData.switchRole , "");
			
			assertTrue(createInjection(selenium,encounterData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-11: Delete and Create SocialHistory//
			//--------------------------------------------------------------------//
			ChartPreVisitLib encounterData7 = new ChartPreVisitLib();
			encounterData7.workSheetName = "CreateSocialHistory";
			encounterData7.testCaseId = "TC_CSH_002";
			encounterData7.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createSocialHistory(selenium,encounterData7),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Delete and Create Family History//
			//--------------------------------------------------------------------//
			ChartPreVisitLib encounterData8 = new ChartPreVisitLib();
			encounterData8.workSheetName = "CreateFamilyHistory";
			encounterData8.testCaseId = "TC_CFM_004";
			encounterData8.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createFamilyHistory(selenium,encounterData8),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
