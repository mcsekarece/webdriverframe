package com.nexia.selenium.testscripts.section.demographics.Referral;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectOptionsInReferral extends AbstractHomeTest{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default"}, description = "Test for Verifying Select Options in Referral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySelectOptionsInReferral(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib refData = new HomeLib();
		refData.workSheetName = "CreateReferral";
		refData.testCaseId = "TC_CRL_013";
		refData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySelectOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, refData);

	}

	/*************************************************************************************************** 
	* @purpose        To verify Select Options for Referral
	* @action 		  verifying Select Options for Referral
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 12, 2012
	***************************************************************************************************/
	public boolean verifySelectOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib refData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + refData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, refData.userName, refData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,refData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,refData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkReferrals);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllReferral(selenium), "Could not delete all referrals", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Verify select options display //
			//---------------------------------------------------------- ----------//
			assertTrue(click(selenium,btnAddReferral),"Could not Click on Add Referral Button:"+ refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifySelectOptionsInPatientReferral(selenium,refData),
					"Selected options are not displayed properly in the select boxes", selenium, ClassName, MethodName);
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}