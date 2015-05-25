package com.nexia.selenium.testscripts.section.chartprevisit.ProblemList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateProblemListInEncounter extends AbstractChartPreVisit {
	
	// Smoke TestCase
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProblemListWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_020";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	
	/**
	 * addProblemList
	 * function to add ProblemList
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 04, 2012
	 */

	public boolean addProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion Failed",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing Problem List							  //
			//--------------------------------------------------------------------//
			
			//Check if the Problem List link is Visible
			assertTrue(selenium.isVisible(lnkProblemList),"Problem List Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounter//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		

			//--------------------------------------------------------------------//
			//  Step-5: Delete Encounter Problem list//
			//--------------------------------------------------------------------//
		
			
			assertTrue(isElementPresent(selenium,lnkProblemList),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkProblemList,"");
			selenium.focus(lnkProblemList);
			selenium.fireEvent(lnkProblemList,"keypress");
			
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Added Procedure									  //
			//--------------------------------------------------------------------//
			
			assertTrue(selenium.isTextPresent(proData.medicalCondition1),"Text is not present",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-8: Sign the Encounter   									 //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnBeginEncounter),"Could not click Begin Encounter button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		    
			assertTrue(isElementPresent(selenium,btnSign),"Could not find the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
				}
			assertTrue(click(selenium,btnSign),"Could not click the sign link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
						
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}