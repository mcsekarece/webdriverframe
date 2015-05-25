package com.nexia.selenium.testscripts.section.chartprevisit.EncounterAddEdit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class AddImmunizationInRecommendationAndPlan extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Encounter Immunization")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEncounterRefusedByPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_006";
		immunizationData.fetchChartPreVisitTestData();
		addEncounterImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Encounter Immunization")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEncounterAdministered(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_007";
		immunizationData.fetchChartPreVisitTestData();
		addEncounterImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Encounter Immunization")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEncounterImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_003";
		immunizationData.fetchChartPreVisitTestData();
		addEncounterImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}

	/**
	 * addEncounterImmunization
	 * function to add Encounter Immunization
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 05, 2012
	 */
	
	public boolean addEncounterImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
					selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,immunizationData),"could not Delete", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
		//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: delete existing Recommendation and plan list			  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllRecommendationAndPlan(selenium, immunizationData), "Could not delete existing recommandation and plan list", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
			//--------------------------------------------------------------------//
			//  Step-5: Create Immunization//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			selenium.focus(imgImmunizationIcon);
			selenium.clickAt(imgImmunizationIcon, "");
			//selenium.fireEvent(immunization_icon, "keyPres");
			
			//waitForPageLoad(selenium);
			//assertTrue(click(selenium,immunization_icon),"Could not click Immunization icon;More Details:"+immunizationData.toString());
			//waitForPageLoad(selenium);	
			
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"immunization Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEncounterData)){
				returnValue=true;
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
