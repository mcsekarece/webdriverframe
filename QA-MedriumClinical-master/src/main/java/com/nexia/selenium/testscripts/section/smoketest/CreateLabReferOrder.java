package com.nexia.selenium.testscripts.section.smoketest;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.thoughtworks.selenium.Selenium;

public class CreateLabReferOrder extends AbstractSmokeTest {
	
	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for adding various charprevisit info to Encounters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterListAll(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateLabOrder";
		orderData.testCaseId = "TC_OL_006";
		orderData.fetchChartPreVisitTestData();
		goEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	
	
	/**
	 * goEncounter
	 * function to create Lab Order and Referal in  Encounters
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	  * @since  	Jan 17, 2013
	 */
	
	public boolean goEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{{
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
			//  Step-2: Advanced search with Patient ID and delete any pending medication and Encounter data//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage_smoke(selenium,orderData.patientId),"Could Select", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			//assertTrue(deleteAllEncounters(selenium,orderData),"could not delete the record", selenium, ClassName, MethodName);
			
						
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//
						
			assertTrue(goToBeginEncounter(selenium),"Could not begin", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);											
			
				
			//--------------------------------------------------------------------//
			//  Step-5: Create Lab Order Page
			//--------------------------------------------------------------------//
			
			assertTrue(clickLabIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,imgLabOrderIcon),"Could not click on lab order link");
			//(selenium);
			assertTrue(orderNewLabs(selenium,orderData),"Order New Labs Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Diaganostic Imaging Lab Order Page
			//--------------------------------------------------------------------//
			ChartPreVisitLib orderDiData = new ChartPreVisitLib();
			orderDiData.workSheetName = "CreateDiganosticImaging";
			orderDiData.testCaseId = "TC_ODI_003";
			orderDiData.fetchChartPreVisitTestData();
			
			
			assertTrue(clickDiIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(orderNewDi(selenium,orderDiData),"Order New Diagnostic Imaging Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Create Referral Order
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib orderRfData = new ChartPreVisitLib();
			orderRfData.workSheetName = "CreateReferralOrder";
			orderRfData.testCaseId = "TC_OR_003";
			orderRfData.fetchChartPreVisitTestData();
			assertTrue(clickReferralIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(orderNewReferral_smoke(selenium,orderRfData),"New Referral Order Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			
			//--------------------------------------------------------------------//
			//  Step-8: Sign the Encounter				                          //
			//--------------------------------------------------------------------//
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				selenium.chooseOkOnNextConfirmation();
			}						
		//	assertTrue(click(selenium, btnBeginEncounter));
			waitForPageLoad(selenium);	
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				selenium.chooseOkOnNextConfirmation();
			}
			assertTrue(isElementPresent(selenium,btnSign),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,btnSign),"Could not click the sign link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
		}					
		catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" );
		}
		return returnValue;
		}	
	}
}