package com.nexia.selenium.testscripts.section.demographics.Consents;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyListFeatureForConsents extends AbstractHomeTest{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the listed consents in the consent summary page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewConsentSignedByPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ConsentData = new HomeLib();
		ConsentData.workSheetName = "NewConsent";
		ConsentData.testCaseId = "TC_NC_007";
		ConsentData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewConsent(seleniumHost, seleniumPort, browser, webSite, userAccount, ConsentData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify list feature for consents
	* @action 		  Verifying list feature for consents
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      Augest 09, 2012
	***************************************************************************************************/
	public boolean createNewConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, consentData.userName, consentData.userPassword),"Login Failed", selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,consentData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			searchPatientNexia(selenium,consentData.patientID);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Consents and deleting existing Consents       //
			//--------------------------------------------------------------------//
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-4: Verify whether "No consents added" is present      //
			//--------------------------------------------------------------------//
			if(!isElementPresent(selenium, lnkExpandAll))
				assertTrue(getText(selenium, lblNoDetailsAdded).equalsIgnoreCase("No consents added"),"Expand all is present in contact summary Page after deleted the existing contacts", selenium, ClassName, MethodName);
					returnValue = true;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}	
}

