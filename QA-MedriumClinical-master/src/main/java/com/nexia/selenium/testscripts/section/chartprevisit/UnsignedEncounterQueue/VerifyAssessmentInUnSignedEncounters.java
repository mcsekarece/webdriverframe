package com.nexia.selenium.testscripts.section.chartprevisit.UnsignedEncounterQueue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAssessmentInUnSignedEncounters extends AbstractChartPreVisit{
	@Test(groups ={"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing whether Begin Encounter button present after saving an encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueOfSignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySignedEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify assessment in un signed encounters
	* @action 		  Verifying assessment in un signed encounters
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 12, 2013
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
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,encounterData.switchRole),"Could not change the switch role;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounters(selenium,encounterData),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter//
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"begin Encounter failed",selenium,ClassName,MethodName);
			
			selectValueFromAjaxList(selenium,"providerSuggestBoxIdsuggestBox",encounterData.provider);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Enter assessment Details//
			//--------------------------------------------------------------------//
			//assertTrue(assesmentSectionForSignedEncounter(selenium,encounterData),"could not Enter the data");
			
			selectValueFromAjaxList(selenium,"assessmentSearchBox",encounterData.medicalCondition);
			waitForPageLoad(selenium);
			click(selenium,"//div[5]/div/div/div/div/div");
			
			encounterData.workSheetName = "CreateProblemList";
			encounterData.testCaseId = "TC_CPL_013";
			encounterData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Problem list//
			//--------------------------------------------------------------------//
			
			assertTrue(createProblemList(selenium,encounterData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!getText(selenium, "//div[13]/div").contains(encounterData.medicalCondition)){
				return false;
			}
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the action button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnBack),"Could not click the back button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"Unsignedencounters"),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			
			assertTrue(type(selenium,"searchTextBox",encounterData.medicalCondition),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);
			selenium.keyPress("searchTextBox", "\\13");
			waitForPageLoad(selenium);
			
			
			assertTrue(verifyStoredValues(selenium, encounterData, userAccount),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return retuenValue;
		}
		return retuenValue;
	}
	
	
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib encounterData, String account ){
		String date=null;
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
		}
		if(!getText(selenium, "//div[@id='UnsignedEncounterList']/table/tbody/tr/td/div/div").contains(encounterData.medicalCondition)){
			return false;
		}
		System.out.println(getText(selenium, "//div[@id='UnsignedEncounterList']/table/tbody/tr/td/div/div"));
		if(!getText(selenium, "//div[@id='UnsignedEncounterList']/table/tbody/tr/td/div/div").contains(date)){
			return false;
		}
		return true;
		
	}
}
