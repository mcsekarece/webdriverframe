package com.nexia.selenium.testscripts.section.chartprevisit.OrderLabDiReferral;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValuesInLabReport extends AbstractChartPreVisit {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for ordering Labs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForLabOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateLabOrder";
		orderData.testCaseId = "TC_OL_001";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createLabOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	/**
	 * createLabOrder
	 * function to create order for labs
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 15, 2012
	 */
	
	public boolean createLabOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + orderData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NPC_002";
			PatientData.fetchHomeTestData();
			
			assertTrue(goToRegisterPatient(selenium), "Could not go to register patient", selenium, ClassName, MethodName);
			createNewPatientWithMandatory(selenium,PatientData);
			waitForPageLoad(selenium);
			
			assertTrue(navigateTofileReport(selenium,orderData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,orderData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Lab Orders//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteOrders(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Lab Order Page//
			//--------------------------------------------------------------------//
			assertTrue(clickLabIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Lab Order Page//
			//--------------------------------------------------------------------//
			
			assertTrue(orderNewLabs(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"sign"),"Could not click on sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(navigateTofileReport(selenium,orderData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValues(selenium,orderData)){
				Assert.fail("Contacts details not saved properly in summary section; More Details :"+ orderData.toString());
				returnValue=false;
			}
			else
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib orderData) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lblCollapseTitle),"Could not click on expand button", selenium, ClassName, MethodName);
		//waitForPageLoad(selenium);

		System.out.println(orderData.testName);
    	assertTrue(isTextPresent(selenium,orderData.testName),"verify Stored Values Failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		/*System.out.println(getText(selenium,"//div[2]/div/div/div[2]/table/tbody/tr/td").toLowerCase(new java.util.Locale("en","US")));
		if(!getText(selenium,"//div[2]/div/div/div[2]/table/tbody/tr/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(orderData.labTestName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounter link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,arrowExpand),"Could not click the expand arrow", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!getText(selenium,"EncountersSignedList").contains(orderData.testName))
			return false;
		return true;
	}	
}
