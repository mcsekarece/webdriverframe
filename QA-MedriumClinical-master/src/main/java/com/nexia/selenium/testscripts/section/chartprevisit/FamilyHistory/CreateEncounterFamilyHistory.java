package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateEncounterFamilyHistory extends AbstractChartPreVisit{
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createFamilyHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_001";
		historyData.fetchChartPreVisitTestData();
		addFamilyHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	/**
	 * addFamilyHistory
	 * function to add Family History
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	  * @since  	Oct 15, 2012
	 */

	public boolean addFamilyHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,"FULL"),"unable to switch the user role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,historyData),"Could not delete", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Family History//
			//--------------------------------------------------------------------//
			// Check if the Family History Link is Visible
			assertTrue(selenium.isVisible(lnkFamilyHistory),"Family History Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//

			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkFamilyHistory),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(focus(selenium,lnkFamilyHistory),"Could not Click", selenium, ClassName, MethodName);
			assertTrue(clickAt(selenium,lnkFamilyHistory,""),"Could not Click", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-6: CreateFamily History and Verify 						 //
			//--------------------------------------------------------------------//
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//verify the added Family History		
			assertTrue(selenium.isTextPresent(historyData.medical),"Text not present", selenium, ClassName, MethodName);	
			
			//--------------------------------------------------------------------//
			//  Step-7: For SmokeTest, Sign the Encounter						  //
			//--------------------------------------------------------------------//
										
			assertTrue(click(selenium, btnBeginEncounter)," ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				selenium.chooseOkOnNextConfirmation();
			}
			assertTrue(isElementPresent(selenium,btnSign),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,btnSign),"Could not click the sign link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
