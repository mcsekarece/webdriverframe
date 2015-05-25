package com.nexia.selenium.testscripts.section.chartprevisit.EMRSecurity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDataSharingForEncounterBottomIcons extends AbstractChartPreVisit{
	
	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Immunization data sharing")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dataSharingForImmunizationTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_051";
		immunizationData.fetchChartPreVisitTestData();
		dataSharingEncounterBottomIcons(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying procedure data sharing")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dataSharingForProcedureTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProcedure";
		proData.testCaseId = "TC_CP_002";
		proData.fetchChartPreVisitTestData();
		dataSharingEncounterBottomIcons(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	
	public boolean dataSharingEncounterBottomIcons(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		
		try{
			ChartPreVisitLib practiceData = new ChartPreVisitLib();
			practiceData.workSheetName = "EMRSecurity";
			practiceData.testCaseId = "TC_ES_017";
			practiceData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + practiceData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, practiceData.userName, practiceData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click the Close button", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			// Step-2: Set Data Sharing between Practices
			//--------------------------------------------------------------------//
			assertTrue(setDataSharingBetweenPractices(selenium, practiceData), "Could not set Data Sharing level between practices", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			// Step-3: Switch practice to Practice which will share data
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium, practiceData.practice), "Could not switch the practice", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Change Switch Role - FULL  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,practiceData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Verify Encounter Icons
			//--------------------------------------------------------------------//
			//verify Immunization
			if (encounterData.workSheetName == "CreateImmunization"){
				System.out.println("CreateImmunization");
				assertTrue(dataSharingForImmunization(selenium, userAccount, encounterData), "Data sharing not successfull for Procedure", selenium, ClassName, MethodName);
				
			}
			//verify Procedure
			if (encounterData.workSheetName == "CreateProcedure") {
				System.out.println("CreateProcedure");
				assertTrue(dataSharingForProcedureTest(selenium, userAccount, encounterData), "Data sharing not successfull for Immunization", selenium, ClassName, MethodName);
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}




	/*************************************************************************************************** 
	 * @purpose        Test for verifying Procedure data sharing 
	 * @Specification  TCH-5 - Improve Security in Nexia 
	 * @action 		   Data Sharing function for a practice
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       July 16, 2014
	 ***************************************************************************************************/	
	public boolean dataSharingForProcedureTest(Selenium selenium,String userAccount, ChartPreVisitLib proData) throws IOException{
		boolean returnValue=true;
		String date=null;
		try{
			
			//Advanced search with Patient ID
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			
			//Delete  Procedure
			assertTrue(click(selenium,lnkProcedure),"Could not click the Medical and Surgical History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProcedure(selenium,proData),"Could not delete the procedure", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+proData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//Delete all encounter in encounter tab
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"Cpould not delete the record", selenium, ClassName, MethodName);

			//Navigate to Encounter 
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);

			//Delete  Encounter Procedure
			assertTrue(deleteEncounterProcedure(selenium,proData),"Could not delete the procedure", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Delete existing Recommendation and plan list	
			assertTrue(deleteAllRecommendationAndPlan(selenium, proData), "Could not delete existing recommandation and plan list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Navigate to add procedure page
			selenium.clickAt(lnkProcedure, "");;
			
			//Add Procedure
			assertTrue(createProcedure(selenium,proData,userAccount),"procedure Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,action),"Could not find the link;More Details:"+proData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,action),"Could not click the button;More Details:"+proData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+proData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Verify Stored Value in patient summary under procedure 
			selenium.clickAt(lnkProcedure, "");	
			assertTrue(verifyCollapseViewForProcedure(selenium,proData,userAccount),"procedure details not saved properly; More Details :"+ proData.toString(),selenium, ClassName, MethodName);
			
			
			assertTrue(verifyExpandViewForProcedure(selenium,proData,userAccount),"procedure details not saved properly; More Details :"+ proData.toString(),selenium, ClassName, MethodName);
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}


	/*************************************************************************************************** 
	 * @purpose        Test for verifying Immunization data sharing 
	 * @Specification  TCH-5 - Improve Security in Nexia 
	 * @action 		   Data Sharing function for a practice
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       July 16, 2014
	 ***************************************************************************************************/

	public boolean dataSharingForImmunization(Selenium selenium , String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		boolean returnValue=false;
		
		try{
		
			//Advanced search with Patient ID
			searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId);
			waitForPageLoad(selenium);
			
			// Delete All existing Immunization
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCancel),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Delete all encounter in encounter tab
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,immunizationData),"Could not delete", selenium, ClassName, MethodName);

			//Navigate to Encounter 
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			
			//Delete All Exist Encounter Immunization
			assertTrue(deleteEncounterImmunization(selenium),"Could not delete immunization in encounter page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Delete existing Recommendation and plan list			 
			assertTrue(deleteAllRecommendationAndPlan(selenium, immunizationData), "Could not delete existing recommandation and plan list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Create Immunization
			selenium.focus(imgImmunizationIcon);
			selenium.clickAt(imgImmunizationIcon,"");
			//assertTrue(click(selenium,immunization_icon),"Could not click Immunization icon;More Details:"+immunizationData.toString());
			//waitForPageLoad(selenium);	
			
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"immunization Creation failed", selenium, ClassName, MethodName);
			
			
			//Click on Action and select save 
			assertTrue(isElementPresent(selenium,action),"Could not find the link;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,action),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: verify Stored Value in Family History //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyCollapseViewForImmunization(selenium,immunizationData,userAccount)){
				Assert.fail("Immunization details not saved properly; More Details :"+ immunizationData.toString());
			}
			if(!verifyExpandViewForImmunization(selenium,immunizationData,userAccount)){
				Assert.fail("Immunization details not saved properly; More Details :"+ immunizationData.toString());
			}
			else
				returnValue=true;
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
}
