package com.nexia.selenium.testscripts.section.chartprevisit.ProblemList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditProblemListInEncounter extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editProblemListWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_024";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/**
	 * editProblemList
	 * function to edit Problem List
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 17, 2012
	 */

	public boolean editProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
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
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			//searchPatientNexiaForProviderHomePage(selenium,"mathew");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion Failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-4: Delete Encounter Problem list//
			//--------------------------------------------------------------------//
		
			assertTrue(isElementPresent(selenium,lnkEncounterProblemList),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterProblemList,"");
			//selenium.focus(lnkProblemList);
			//selenium.fireEvent(lnkProblemList,"keypress");
			
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Add Problem List //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllProblemList(selenium,proData),"deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Edit Problem List//
			//--------------------------------------------------------------------//
			
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_005";
			proData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//assertTrue(isElementPresent(selenium,lblEncouterSumDetails),"Could not find the Data;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,lblEnProblemList),"Could not find the Data;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(editProblemList(selenium,proData,userAccount),"Editing Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEnProblemList)){
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