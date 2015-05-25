package com.nexia.selenium.testscripts.section.demographics.HealthCareTeam;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class SearchHealthCareTeam extends AbstractHomeTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Searching a team ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchHealthCareTeamWithTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib healthTestData = new  HomeLib();
		healthTestData.workSheetName = "SearchHealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_001";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		searchAdminHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Searching a Staff Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchHealthCareTeamWithStaff(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib healthTestData = new  HomeLib();
		healthTestData.workSheetName = "SearchHealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_002";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		searchHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Searching a External Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchHealthCareExternal(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib healthTestData = new  HomeLib();
		healthTestData.workSheetName = "CreateExternalProviders";
		healthTestData.testCaseId = "TC_CET_001";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		searchExternalHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify search Feature In Health Care Team
	* @action 		  Verifing search Feature In Health Care Team
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 15, 2012
	***************************************************************************************************/
	public boolean searchHealthCareTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib healthTestData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
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
		
			//---------------------------------------------------------- ----------//
			//  Step-4:Create a new Health Care Team//
			//--------------------------------------------------------------------//
			click(selenium,lnkPatientHealthcare);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Deleting existing Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllHealthCareteam(selenium,epData,userAccount), "Could not delete all health care team ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-6: Edit Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchHealthCare(selenium,healthTestData,epData,userAccount),"Health Care team Editing failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-7: Verify Stroe Value in Summary Page //
			//--------------------------------------------------------------------//
			if(!verifyStoreValueinSummaryPageSearchHealthcare(selenium,healthTestData,epData)){
				Assert.fail("Health Care Data details not saved properly; More Details :"+healthTestData.toString());
				returnValue = false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify search Feature In External Health Care Team
	* @action 		  Verifing search Feature In External Health Care Team
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 15, 2012
	***************************************************************************************************/
	public boolean searchExternalHealthCareTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib healthTestData) throws Exception{
		Selenium selenium = null;
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
			
			//--------------------------------------------------------------------//
			//  Step-3:Create role and reason For deletion at Admin section     //
			//--------------------------------------------------------------------//
			
			HomeLib epData = new  HomeLib();
			epData.workSheetName = "AdminHealthCareTeam";
			epData.testCaseId = "TC_HCTA_001";
			epData.fetchHomeTestData();
			
			//--------------------------------------------------------------------//
			//  Step-4: Go to System Settings and navigate to External Providers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
			assertTrue(click(selenium,"systemSettingsAction"),"Could not click the System settings link;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkExternalProvider),"Could not click on External Providers link:" + healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Deleting existing External Providers //
			//--------------------------------------------------------------------//
			int count =1;
			while(isElementPresent(selenium,"//div[@id='AdminReferringProviderList']/table/tbody/tr["+count+"]/td[2]/div/a")){
				waitForPageLoad(selenium);
				click(selenium,"//div[@id='AdminReferringProviderList']/table/tbody/tr["+count+"]/td[2]/div/a");
				waitForPageLoad(selenium);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
				int countAfterDeletion=(Integer) selenium.getXpathCount(lnkDeleteExternalProvider);
				if((count==countAfterDeletion)&&(countAfterDeletion!=0)){
					Assert.fail("Could not delete the provider;More Details:"+healthTestData .toString());
				}
				waitForPageLoad(selenium);
				count++;
			}
			
			//---------------------------------------------------------- ----------//
			//  Step-6: Add a new External Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddExternalProvider),"Could not click on Add External Providers link:" + healthTestData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createExternalProvider(selenium,healthTestData,userAccount),"External Providers Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			// Step-7: Search Patient Nexia//
			//--------------------------------------------------------------------//
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			healthTestData.workSheetName = "SearchHealthCareTeam";
			healthTestData.testCaseId = "TC_HCT_003";
			healthTestData.fetchHomeTestData();
			
			searchPatientNexia(selenium,healthTestData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkPatientHealthcare);
			waitForPageLoad(selenium);
			
			//----------------------------------------------------------------------//
			//  Step-8: Deleting existing Health Care List //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllHealthCareteam(selenium,epData,userAccount), "Could not delete all health care team ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-9: Edit Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(searchHealthCare(selenium,healthTestData,epData,userAccount),"Health Care team Editing failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-10: Verify Store Value in Summary Page //
			//--------------------------------------------------------------------//
			if(!verifyStoreValueinSummaryPageforExternalHealthCare(selenium,healthTestData,userAccount)){
				Assert.fail("Health Care Data details not saved properly; More Details :"+healthTestData.toString());
				returnValue = false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}


	/*************************************************************************************************** 
	* @purpose        To Verify search Feature In Admin Health Care Team
	* @action 		  Verifing search Feature In Admin Health Care Team
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 15, 2012
	***************************************************************************************************/
	public boolean searchAdminHealthCareTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib healthTestData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
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
			
			//---------------------------------------------------------- ----------//
			//  Step-3:Create role and reason For deletion at Admin section//
			//--------------------------------------------------------------------//
			HomeLib epData = new  HomeLib();
			epData.workSheetName = "AdminHealthCareTeam";
			epData.testCaseId = "TC_HCTA_002";
			epData.fetchHomeTestData();
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Deleting existing Admin Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
			assertTrue(click(selenium,"systemSettingsAction"),"Could not click the System settings link;More Details:"+epData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,"!adminHealthcareTeamList"),"Could not click on Health Care Team link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			epData.workSheetName = "AdminHealthCare";
			epData.testCaseId = "TC_HCT_001";
			epData.fetchHomeTestData();
			
			assertTrue(deleteAdminHCT(selenium,epData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: create Admin Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddHealthcareTeam),"Could not click on Add Health Care Datalink:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM-dd-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createAdminHealthCareTeam(selenium,epData,uniqueName)," Health Care Team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-6:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,healthTestData.patientID);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-7:Create a new Health Care Team//
			//--------------------------------------------------------------------//
			click(selenium,lnkPatientHealthcare);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-8: Deleting existing Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllHealthCareteam(selenium,epData,userAccount), "Could not delete all health care team ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//---------------------------------------------------------------------//
			//  Step-9: Edit Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchHealthCare(selenium,healthTestData,epData,userAccount),"Health Care team Editing failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//---------------------------------------------------------------------//
			//  Step-10: Verify Store Value in Summary Page //
			//--------------------------------------------------------------------//
			if(!verifyStoreValueinSummaryPageSearchHealthcare(selenium,healthTestData,epData)){
				Assert.fail("Health Care Data details not saved properly; More Details :"+healthTestData.toString());
				returnValue = false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
