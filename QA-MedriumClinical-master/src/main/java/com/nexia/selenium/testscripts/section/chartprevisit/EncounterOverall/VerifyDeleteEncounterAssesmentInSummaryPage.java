package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteEncounterAssesmentInSummaryPage  extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Delete Encounter Assesment In Summary Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueOfSignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_006";
		encounterData.fetchChartPreVisitTestData();
		verifySignedEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Delete Encounter Assessment In Summary Page
	* @action 		  Verifying Delete Encounter Assessment In Summary Page
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 29, 2013
	***************************************************************************************************/
	public boolean verifySignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		boolean retuenValue=true;
		Selenium selenium=null;
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
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib vitalsData1 = new ChartPreVisitLib();
			vitalsData1.workSheetName = "NewPatientCheckIn";
			vitalsData1.testCaseId = "TC_NP_001";
			vitalsData1.fetchChartPreVisitTestData();
			
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData1),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, txtpatientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			
			selectValueFromAjaxList(selenium,ajxEncounterProvider,encounterData.provider);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Problem list//
			//--------------------------------------------------------------------//
			encounterData.workSheetName = "CreateProblemList";
			encounterData.testCaseId = "TC_CPL_013";
			encounterData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			
			int count=0;
			while(isElementPresent(selenium,ajxAssessmentSearch)){

				selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);
				waitForPageLoad(selenium);
				selenium.fireEvent(ajxAssessmentSearch,"keydown");
				selenium.fireEvent(ajxAssessmentSearch,"keypress");                           
				selenium.fireEvent(ajxAssessmentSearch,"keyup");
				waitForPageLoad(selenium);
				selenium.clickAt(ajxAssessmentSearch, "");
				selenium.keyPress(ajxAssessmentSearch, "\\9");
			
				if(isElementPresent(selenium,txtMedicatl)){
					break;
				}
				count++;
			
				if(count>20){
					break;
				}
			}
			
			assertTrue(deleteAllProblemList(selenium, encounterData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createProblemList(selenium,encounterData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSummary),"Could not click the summary link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValue(selenium,encounterData,userAccount)){
				fail("Encounter details not saved properly; More Details :"+ encounterData.toString());				
			}
						
			assertTrue(click(selenium,lblEncounterDetails),"Could not click the created assessment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnremovebutton),"Could not click the delete button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,btnYesbutton),"Could not click the delete button", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Stored value After delete //
			//--------------------------------------------------------------------//
			if(!verifyStoredValueAfterDeleteAssessment(selenium,encounterData,userAccount)){
				Assert.fail("Signed Encounter details not saved properly; More Details :"+ encounterData.toString());
			}else
				return true;
		
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return retuenValue;
		}
		return retuenValue;
	}
	
	
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib encounterData,String account){
		//Verify created assessment in encounter
		if(!getText(selenium,lblSummaryProblemList).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.medicalCondition.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		//Verify created assessment in summary page
		if(!getText(selenium,lblSummaryProblemList).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.medicalCondition.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
	
	public boolean verifyStoredValueAfterDeleteAssessment(Selenium selenium,ChartPreVisitLib encounterData,String account){
		//Verify created assessment in encounter
		if(getText(selenium,lblSummaryProblemList).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.medicalCondition.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		//Verify created assessment in summary page
		if(getText(selenium,lblSummaryProblemList).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.medicalCondition.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}

