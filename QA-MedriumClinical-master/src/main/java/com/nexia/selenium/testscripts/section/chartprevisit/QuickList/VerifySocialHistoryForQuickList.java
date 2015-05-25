/*************************************************************************************************** 
* @purpose 			This testcase Verification the Quick list save functionality for Social History
* @Specification 	Medical Summary - Save to QUICK LIST - Fields to be saved - Social History    
* @action 			Added the "Yes" fields values for the Social History and then save to Quick List   
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


public class VerifySocialHistoryForQuickList extends AbstractChartPreVisit {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Cancel Encounter Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySocialQuickList(final String seleniumHost, final int seleniumPort,final String browser, final String webSite, String userAccount) throws Exception {
		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateSocialHistory";
		QuicklstData.testCaseId = "TC_CSH_009";
		QuicklstData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuickListSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Cancel Encounter Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySocialQuickListIcon(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateSocialHistory";
		QuicklstData.testCaseId = "TC_CSH_009";
		QuicklstData.fetchChartPreVisitTestData();		
		verifyQuickListIcon(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}
	
	/**
	 * VerifySocialHistoryQuickList
	 * function to Verify SocialHistory QuickList
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite	 
	 * @throws IOException 
	 * @since  	    March 25, 2013
	 */

	public boolean verifyQuickListSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib QuicklstData) throws IOException{
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
			//  Step-3: Navigate to Social History and delete previous entries  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllSocialHistory(selenium,QuicklstData),"Deletion failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Save Social History to Quick List						  //
			//--------------------------------------------------------------------//
			assertTrue(createSocialHistoryQuickList(selenium,QuicklstData),"Creation failed",selenium,ClassName,MethodName);
				
			waitForPageLoad(selenium);
						
		
			//--------------------------------------------------------------------//
			//  Step-5:  Verify Quick List View   								  //
			//--------------------------------------------------------------------//
			assertTrue(verifyQuickListViewForSocialHistory(selenium,QuicklstData,userAccount),"Verify QuickListView Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + QuicklstData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify QuickList icon
	* @action 		  Verifying Quick list Icon
	* @expected       After click the Social History, Verify the Quick List Icon
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Closed
	* @defectNo       3714
	* @useraccount    Both
	* @since  	      April 18, 2013
	***************************************************************************************************/
	public boolean verifyQuickListIcon(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib QuicklstData) throws IOException{
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
			//  Step-3: Navigate to Social History   //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
	
			assertTrue(deleteAllSocialHistory(selenium,QuicklstData),"Deletion failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Save Social History to Quick List						  //
			//--------------------------------------------------------------------//
			assertTrue(createSocialHistoryQuickList(selenium,QuicklstData),"Creation failed",selenium,ClassName,MethodName);
				
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify the Quick List Icon				  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkSocialShowMore), "Could not click on show more button",selenium,ClassName,MethodName);
			assertTrue(click(selenium, "socialHistoryQuicklistButton"), "Could not click the QuickList button",selenium,ClassName,MethodName);
			
			if(isElementPresent(selenium,imgQuickListIcon)){
				return returnValue;
			}else{
				Assert.fail("The icon is not display");
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + QuicklstData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	
}
