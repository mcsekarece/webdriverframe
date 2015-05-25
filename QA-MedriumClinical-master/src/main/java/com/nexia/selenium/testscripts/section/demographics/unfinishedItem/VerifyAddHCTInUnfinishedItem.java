package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddHCTInUnfinishedItem extends AbstractHomeTest {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editHealthCareEndby(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib healthTestData = new  HomeLib();
		healthTestData.workSheetName = "EditHealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_005";
		healthTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Edit Health Care Team
	* @action 		  Editing Health Care Team
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean editHealthCareTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib healthTestData) throws Exception{
		Selenium selenium = null;
		String currentUnfinishedItem="Add Healthcare Team for";
		boolean returnValue = true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + healthTestData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, healthTestData.userName, healthTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,healthTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Create role and reason For deletion at Admin section
			HomeLib epData = new  HomeLib();
			epData.workSheetName = "AdminHealthCareTeam";
			epData.testCaseId = "TC_HCTA_001";
			epData.fetchHomeTestData();
			
			//---------------------------------------------------------- ----------//
			//  Step-3:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,healthTestData.patientID);
			waitForPageLoad(selenium);
			
			//Create a new Health Care Team
			click(selenium,lnkPatientHealthcare);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Deleting existing Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllHealthCareteam(selenium,epData,userAccount), "Could not delete all health care team ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-5: Edit Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "link=Continue")){
				click(selenium, "link=Continue");
			}
			assertTrue(createHealthCare(selenium,healthTestData,epData,userAccount),"Health Care team Editing failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			assertTrue(storeDataInUnfinishedItem(selenium),"Could not Store data in unfinished item; More Details :"+ healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to unfinished item							  //
			//--------------------------------------------------------------------//
			//get the current patient name
			String patientName[]= getText(selenium, lblPatientName).split(",");
			
			//customize the patient name for our need
			String patientNameAltered= patientName[1] +" "+ patientName[0];
			
			//append the patient name with the current unfinished item section
			currentUnfinishedItem= currentUnfinishedItem + patientNameAltered ;
			
			assertTrue(navigateToUnfinishedItem(selenium, currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			// Complete the unfinished item
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + healthTestData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoreValueinSummaryPageHealthCare(selenium,healthTestData,epData),"Health Care Data details not saved properly; More Details :"+healthTestData.toString(), selenium, ClassName, MethodName);
		
		}
			catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return true;
		}
}
