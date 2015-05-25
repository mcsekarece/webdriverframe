/*************************************************************************************************** 
* @purpose 			This testcase Verification the Quick list save functionality for Family History
* @Specification 	Medical Summary - Save to QUICK LIST - Fields to be saved - Family History    
* @action 			Added the "Yes" fields values for the Immunization and then save to Quick List   
* @expected  		On Clicking the Quick list button the "Yes" field value should show up
* 
* @author       Jagmit 
* @state        Developing
* @useraccount  Canada and US
***************************************************************************************************/

package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateFamilyHistoryForQuickList extends AbstractChartPreVisit  {
	
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Cancel Encounter Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void CreateFamilyHistoryQuickList(final String seleniumHost, final int seleniumPort,final String browser, final String webSite, String userAccount) throws Exception {
		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateFamilyHistory";
		QuicklstData.testCaseId = "TC_CFM_010";
		QuicklstData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuickListFamilyHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}
	
	/**
	 * VerifyFamilyHistoryQuickList
	 * function to Verify FamilyHistory QuickList
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	    March 15, 2013
	 */
	
	public boolean verifyQuickListFamilyHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib QuicklstData) throws IOException{
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
			//  Step-3: Navigate to Family History								  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the Family History link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteFamilyHistory(selenium,QuicklstData ),"Deletion Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Save Family History to Quick List						  //
			//--------------------------------------------------------------------//
			assertTrue(createFamilyHistoryQuickList(selenium,QuicklstData),"FamilyHistory creation failed",selenium,ClassName,MethodName);			
			//assertTrue((selenium,createFamilyHistory),"Save Immunization to Quick List failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:  Verify Quick List View   //
			//--------------------------------------------------------------------//
			assertTrue(verifyQuickListViewForFamilyHistory(selenium,QuicklstData,userAccount),"Verify QuickListView Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + QuicklstData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}

	
}