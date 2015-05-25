package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyShowMarkup extends AbstractChartPreVisit {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing show markup")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMarkupDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchChartPreVisitTestData();
		verifyEncounterMarkup(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing show markup")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultiUserLegend(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_001";
		encounterData.fetchChartPreVisitTestData();
;		verifyEncounterMarkup(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/**
	 * verifyEncounterMarkup
	 * function to verify encounter markup
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    May 26, 2012
	 */
	
	public boolean verifyEncounterMarkup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			assertTrue(switchRole(selenium,encounterData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
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
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
		
			
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
				
			assertTrue(createProblemList(selenium,encounterData1,userAccount),"Creation failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6: Enter other encounter details and Save//
			//--------------------------------------------------------------------//
			
			String cc="complaint";
			String illness="illness";
			String generic="gen";
			String cc1="1complaint";
			String illness1="1illness";
			String generic1="1gen";
			
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.replaceAll(", " + encounterData.switchRole, "");
			String tempArray[] = pName.split(" ");
			String providerName = tempArray[0];
			
			assertTrue(type(selenium, chiefComplaintText,cc),"Could not type cheif complaint", selenium, ClassName,MethodName);
			selenium.fireEvent(chiefComplaintText, "blur");
			assertTrue(type(selenium, txtIllness,illness),"Could not type illness", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtGeneric,generic),"Could not type review details", selenium, ClassName,MethodName);
			
			assertTrue(click(selenium,lnkEncounterAction),"Could not click Action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lstActionSaveEncounter),"Could not click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Second user Login//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkTopMenu),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignout),"Could not click the log out button",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnYesButton),"Could not click yes button;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, "doctor", "orthodoc"),"Login Failed while using the password which has been reset",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,encounterData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);

			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkPatientOption),"Could not click the Patient Options link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		//	assertTrue(click(selenium, lnkViewChart),"Could not click the View Chart link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(clickAt(selenium,lnkencounterTab,""),"Could not find Encounters button", selenium, ClassName, MethodName);
			assertTrue(focus(selenium,lnkencounterTab),"Could not focus first Encounter", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lblFirstEncounter),"Could not find first Encounters", selenium, ClassName, MethodName);
			/*if(isElementPresent(selenium,lnkEditEncounter)){
				assertTrue(click(selenium,lnkEditEncounter),"Could not find Encounters button", selenium, ClassName, MethodName);
			}	*/	
			//--------------------------------------------------------------------//
			//  Step-8: Add Procedure//
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib encounterData2 = new ChartPreVisitLib();
			encounterData2.workSheetName = "CreateProcedure";
			encounterData2.testCaseId = "TC_CP_003";
			encounterData2.fetchChartPreVisitTestData();
			
			String providerNameTemp1 = getText(selenium, lnkTopMenu);
			String pName1 = providerNameTemp1.replaceAll(", " + encounterData.switchRole, "");
			String tempArray1[] = pName1.split(" ");
			//String providerName1 = tempArray[1] + ", " + tempArray1[0];
			String providerName1 =tempArray1[0];
			
			assertTrue(click(selenium,lnkProcedure),"Could not click the Procedure link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createProcedure(selenium,encounterData2,userAccount),"Creation failed", selenium, ClassName, MethodName);
			/*assertTrue(
					click(selenium, btnSaveProcedures),
					"Could not click the add button;More details:"
							,selenium, ClassName, MethodName);*/
			assertTrue(type(selenium, chiefComplaintText,cc1),"Could not type cheif complaint", selenium, ClassName,MethodName);
			selenium.fireEvent(chiefComplaintText, "blur");
			assertTrue(type(selenium, txtIllness,illness1),"Could not type illness", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtGeneric,generic1),"Could not type review details", selenium, ClassName,MethodName);
			
			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Encounter Markup//
			//--------------------------------------------------------------------//
			assertTrue(clickAt(selenium,lnkencounterTab,""),"Could not find Encounters button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(clickAt(selenium,lnkEncounterActions,""),"Could not find actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMarkup),"Could not find markup", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnunsignedsave))
			{
				assertTrue(click(selenium,btnunsignedsave),"Could not Click continue button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-7: Verify Markup Details//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent(encounterData1.medicalCondition1),"Could not find markup", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(encounterData2.proName),"Could not find markup", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(cc1),"Could not find markup", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(illness1),"Could not find markup", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(generic1),"Could not find markup", selenium, ClassName, MethodName);			
			//assertTrue(click(selenium,),"Could not find markup", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSecondMarkupLink),"Could not find second markup", selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
             waitForPageLoad(selenium);
             waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent(encounterData1.medicalCondition1),"Could not find markup", selenium, ClassName, MethodName);
			//assertTrue(!selenium.isTextPresent(encounterData2.proName),"Could not find markup", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(cc),"Could not find markup", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(illness),"Could not find markup", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(generic),"Could not find markup", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(providerName1),"Could not find user1", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(providerName),"Could not find user2", selenium, ClassName, MethodName);
			
			if(encounterData.testCaseId.equals("TC_EO_001")){
				selenium.mouseOver(lnkLegends);
				assertTrue(getText(selenium,lblLegend).contains(providerName),"Could not legends", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblLegend).contains(providerName1),"Could not legends", selenium, ClassName, MethodName);
			}
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}