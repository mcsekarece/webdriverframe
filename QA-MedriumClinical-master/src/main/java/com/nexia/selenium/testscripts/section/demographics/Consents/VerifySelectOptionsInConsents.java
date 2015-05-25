package com.nexia.selenium.testscripts.section.demographics.Consents;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectOptionsInConsents extends AbstractHomeTest{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying the selected option in select boxes")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySelectOptionsInConsents(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ConsentData = new HomeLib();
		ConsentData.workSheetName = "NewConsent";
		ConsentData.testCaseId = "TC_NC_008";
		ConsentData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySelectOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, ConsentData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify select option in consents
	* @action 		  Verifying select option in consents
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      July 06, 2012
	***************************************************************************************************/
	public boolean verifySelectOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1:Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, consentData.userName, consentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,consentData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Advanced search with Patient ID
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,consentData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkConsentsPatient);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Deleting existing Consents for the selected patient 
			//--------------------------------------------------------------------//
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5:Verify the selected option in select boxes
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnConsentsAdd),"Could not Click on Add Consent Button:"+ consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifySelectOptionsConsents(selenium,consentData),"Selected options are not displayed correctly", selenium, ClassName, MethodName);
				returnValue = true;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
