package com.nexia.selenium.testscripts.section.chartprevisit.TimeLine;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEncounterInTimeLine extends AbstractChartPreVisit {
	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Encounter In TimeLine")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchChartPreVisitTestData();
		verifyEncounterInTimeLine(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Encounter In TimeLine
	* @action 		  verify Encounter In TimeLine
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 23, 2013
	***************************************************************************************************/
	public boolean verifyEncounterInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			assertTrue(switchRole(selenium,encounterData.switchRole),"Could not change the switch role;More Details:"+encounterData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
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
			
			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter										  //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);  

		/*	try{
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}catch(Exception e){
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}if(isElementPresent(selenium,lblEncounterChoosePanel))
				if(isElementPresent(selenium,"beginNewEncounter"))
					click(selenium,"beginNewEncounter");
			
			selectValueFromAjaxList(selenium,"providerSuggestBoxIdsuggestBox",encounterData.provider);*/
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication							  			  //
			//--------------------------------------------------------------------//
			ChartPreVisitLib encounterData1 = new ChartPreVisitLib();
			encounterData1.workSheetName = "CreateMedication";
			encounterData1.testCaseId = "TC_PSM_007";
			encounterData1.fetchChartPreVisitTestData();
					
			assertTrue(click(selenium,lnkMedication),"Could not click the Procedure link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(createEncounterMedication(selenium,encounterData1,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Allergies										  //
			//--------------------------------------------------------------------//
			ChartPreVisitLib encounterData2 = new ChartPreVisitLib();
			encounterData2.workSheetName = "CreateAllergy";
			encounterData2.testCaseId = "TC_CA_002";
			encounterData2.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergies link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createAllergy(selenium,encounterData2,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkTimeLine),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify simple view of Encounters in timeline Summary page //
			//--------------------------------------------------------------------//
			//String lblSimpleView="headerPanel";
			waitForPageLoad(selenium);
			String str = getText(selenium, lnkTopMenu);
			String Rprovider = str.replaceAll(", " + encounterData.switchRole, "");

			assertTrue(getText(selenium, lblEventLastVisit).contains(Rprovider),"Could not find Provider", selenium, ClassName, MethodName);

			/*if(!getText(selenium, lblSimpleView).contains(Rprovider)){
				return false;
			}*/
			
			//------------------------------------------------------------------------//
			//  Step-7: Verify expand view of encounters in timeline Summary page 	  //
			//------------------------------------------------------------------------//
			//String lblSummaryLab="contentPanel";
			assertTrue(click(selenium,lblEventLastVisit),"Could not click the  sign button", selenium, ClassName, MethodName);

			//String lnkExpandLab="css=a.closedArrowTimeline";
			
			/*if(isElementPresent(selenium, lnkExpandLab)){
				click(selenium, lnkExpandLab);
			}*/
			if(userAccount.equals(CAAccount)){
				assertTrue(getText(selenium, lblSummaryLab).toLowerCase().contains(encounterData1.prescribeCa.toLowerCase()),"Could not find prescribe", selenium, ClassName, MethodName);

				assertTrue(getText(selenium, lblSummaryLab).toLowerCase().contains(encounterData2.allergenCa.toLowerCase()),"Could not find Allergen", selenium, ClassName, MethodName);
					
			}
			else{
				assertTrue(getText(selenium, lblSummaryLab).toLowerCase().contains(encounterData1.prescribe.toLowerCase()),"Could not find prescribe", selenium, ClassName, MethodName);
					
				assertTrue(getText(selenium, lblSummaryLab).toLowerCase().contains(encounterData2.allergen.toLowerCase()),"Could not find Allergen", selenium, ClassName, MethodName);
					
			}
			
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
