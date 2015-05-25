package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTitleOnAddingAssesmentInEncounterTab extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Title On Adding Assesment In Encounter Tab")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTitleOnAddingAssesmentInEncounterTab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_016";
		encounterData.fetchChartPreVisitTestData();
		verifySignedEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Search Assesment By ICD Code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchAssesmentByICDCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_017";
		encounterData.fetchChartPreVisitTestData();
		verifySignedEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Title On Adding Assessment In Encounter Tab
	* @Specification  SRS_EMR_Med_Summary_Procedures_Rev0.0
	* @action 		  Verifying Title On Adding Assessment In Encounter Tab
	* @expected       After add the procedure, When click the quick list, It should shows the added procedure
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      March 21, 2013
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
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);			
			assertTrue(selenium.isVisible(lnkProblemList),"Problem List Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(deleteAllProblemList(selenium, encounterData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveProblemList),"Could not find Encounters button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounters(selenium,encounterData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter//
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Enter All Details//
			//--------------------------------------------------------------------//
		
			if(encounterData.testCaseId.equals("TC_EO_017")){
				selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);
				waitForPageLoad(selenium);
				if(!isElementPresent(selenium,txtMedicatl)){
					Assert.fail("Verifing Search Assesment By ICD Code");
				}else{
					return true;
				}
			}else{
				selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);
				waitForPageLoad(selenium);
				click(selenium,"//div[5]/div/div/div/div/div");	
			}
			ChartPreVisitLib encounterData1 = new ChartPreVisitLib();
			encounterData1.workSheetName = "CreateProblemList";
			encounterData1.testCaseId = "TC_CPL_013";
			encounterData1.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Problem list//
			//--------------------------------------------------------------------//
			
			assertTrue(createProblemList(selenium,encounterData1,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,"problemEditSaveButton"),"Could not click the  sign button", selenium, ClassName, MethodName);

			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to chart Encounter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Stored value //
			//--------------------------------------------------------------------//
			
			selectValueFromAjaxList(selenium,ajxRxShow,"Signed");
			if(getText(selenium,lblProDetails).contains(encounterData1.medicalCondition1)){
				assertTrue(click(selenium,lnkExpand),"Could not click the arrow", selenium, ClassName, MethodName);
				if(!verifyStoredValue(selenium,encounterData1)){
       				Assert.fail("Signed Encounter details not saved properly; More Details :"+ encounterData.toString());
				}else
				return true;
			}
		
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return retuenValue;
		}
		return retuenValue;
	}
	
	
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib encounterData){
		
		if(!getText(selenium,lblProDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains("Assessments:".trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
	//	if(getText(selenium,lblSignedEncounter).toLowerCase(new java.util.Locale("en","US")).trim().contains("Recommendations and Plan:".trim().toLowerCase(new java.util.Locale("en","US")))){
	//		return false;
	//	}
		return true;
	}
}
