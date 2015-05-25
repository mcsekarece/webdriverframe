package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyQuickListForAssessment extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the added procedure in quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProblemListInQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateProblemList";
		QuicklstData.testCaseId = "TC_QL_002";
		QuicklstData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuickListProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the added procedure in quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditAssesmentWithQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateProblemList";
		QuicklstData.testCaseId = "TC_QL_002";
		QuicklstData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEditAssesmentWithQuickList(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}

	/*************************************************************************************************** 
	 * @purpose        To verify added quick list Problem List is displayed
	 * @action 		  verifying added quick list problem list is displayed
	 * @expected       After add the Problem list, When search the problem list in assement filed, It should shows the added Problem list
	 * @author         Aspire QA
	 * @throws IOException 
	 * @state          Closed
	 * @useraccount    Both
	 * @since  	      Apr 22, 2013
	 ***************************************************************************************************/
	public boolean verifyQuickListProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib QuicklstData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + QuicklstData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, QuicklstData.userName, QuicklstData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//

			searchPatientNexiaForProviderHomePage(selenium,QuicklstData.patientId);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3:Delete Encouter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium,ClassName,MethodName);
			assertTrue(deleteAllEncounters(selenium,QuicklstData),"delete all encounters failed",selenium,ClassName,MethodName);
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllProblemList(selenium, QuicklstData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Begin Encouter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Begin encounter failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			selectValueFromAjaxList(selenium,ajxAssessmentSearch,QuicklstData.quickList);
			selenium.keyPress(ajxAssessmentSearch, "\\13");
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Create Problem List//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,QuicklstData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Verify Quick List View//
			//--------------------------------------------------------------------//
			assertTrue(verifyQuickListViewForAssessment(selenium,QuicklstData,userAccount),"Verify QuickListView Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + QuicklstData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}

	/*************************************************************************************************** 
	 * @purpose        To verify added quick list Problem List is displayed
	 * @action 		  verifying added quick list problem list is displayed
	 * @expected       After add the Problem list, When search the problem list in assement filed, It should shows the added Problem list
	 * @defectId       #3617
	 * @author         Aspire QA
	 * @throws IOException 
	 * @state          Closed
	 * @useraccount    Both
	 * @since  	      Apr 22, 2013
	 ***************************************************************************************************/
	public boolean verifyEditAssesmentWithQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib QuicklstData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + QuicklstData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, QuicklstData.userName, QuicklstData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//

			searchPatientNexiaForProviderHomePage(selenium,QuicklstData.patientId);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3:Delete Encouter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium,ClassName,MethodName);
			assertTrue(deleteAllEncounters(selenium,QuicklstData),"delete all encounters",selenium,ClassName,MethodName);
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllProblemList(selenium, QuicklstData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Begin Encouter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"begin encounter failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			selenium.typeKeys(ajxAssessmentSearch, "\b");
			selenium.type(ajxAssessmentSearch, "");
			waitForPageLoad(selenium);
			selenium.focus(ajxAssessmentSearch);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			selenium.type(ajxAssessmentSearch,QuicklstData.quickList);
			//selenium.typeKeys(textboxName,valueForSelection);
			selenium.fireEvent(ajxAssessmentSearch,"keydown");
			selenium.fireEvent(ajxAssessmentSearch,"keypress");                           
			selenium.fireEvent(ajxAssessmentSearch,"keyup");
			selenium.keyPress(ajxAssessmentSearch, "\\13");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//*[contains(@id,'currentItem_')]")
					&& (getText(selenium, "//*[contains(@id,'currentItem_')]").toLowerCase().contains(QuicklstData.quickList.toLowerCase()))){
				click(selenium,"//*[contains(@id,'currentItem_')]");
			}else
				selectValueFromAjaxList(selenium,ajxAssessmentSearch,QuicklstData.quickList);
			
			
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Create Problem List//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,QuicklstData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkProblemListTitle),"Could not click the encounter tab",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnEditMedication),"Could not click the encounter tab",selenium,ClassName,MethodName);

			assertTrue(click(selenium,chkQuickList),"Could not click the encounter tab",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + QuicklstData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}

}
