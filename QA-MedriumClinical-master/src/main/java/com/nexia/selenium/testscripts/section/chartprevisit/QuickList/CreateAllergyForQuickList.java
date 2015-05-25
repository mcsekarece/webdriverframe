/*************************************************************************************************** 
* @purpose 			This testcase Verification the Quick list save functionality for Allergies
* @Specification 	Medical Summary - Save to QUICK LIST - Fields to be saved - Allergies    
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


public class CreateAllergyForQuickList extends AbstractChartPreVisit {

	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Cancel Encounter Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergiesQuickList(final String seleniumHost, final int seleniumPort,final String browser, final String webSite, String userAccount) throws Exception {

		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateAllergy";
		QuicklstData.testCaseId = "TC_CA_019";
		QuicklstData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuickListAllergies(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Cancel Encounter Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergiesQuickListTurnoff(final String seleniumHost, final int seleniumPort,final String browser, final String webSite, String userAccount) throws Exception {

		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateAllergy";
		QuicklstData.testCaseId = "TC_CA_023";
		QuicklstData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuickListAllergies(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}
	
	
	/**
	 * VerifyAllergiesQuickList
	 * function to Verify Allergies QuickList
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    March 18, 2013
	 */
	
	

	public boolean verifyQuickListAllergies(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib QuicklstData) throws IOException{
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
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergies link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllAllergy(selenium,QuicklstData),"Deletion Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Save Family History to Quick List						  //
			//--------------------------------------------------------------------//
			assertTrue(createAllergyQuickList(selenium,QuicklstData,userAccount),"Allergy creation failed",selenium,ClassName,MethodName);			
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-5: Verify Quick List Pop UP					  //
			//--------------------------------------------------------------------//
			if(QuicklstData.testCaseId.equals("TC_CA_023")){
				assertTrue(click(selenium,btnAllergyQuickList),"Could not click the Quick List button",selenium,ClassName,MethodName);
				if(isElementPresent(selenium,lblQuickValue1)){
					returnValue=true;
				}else{
					Assert.fail("Pick List should be getting displayed");
				}
				
			}   
					
			//--------------------------------------------------------------------//
			//  Step-6:  Verify Quick List View   								  //
			//--------------------------------------------------------------------//
			assertTrue(verifyQuickListViewForAllergy(selenium,QuicklstData,userAccount),"Verify QuickListView Failed",selenium,ClassName,MethodName);
			
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + QuicklstData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	
	
}
